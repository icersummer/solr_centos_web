package com.vjia.indexer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.vjia.RealIndexer;
import com.vjia.indexable.JavaFile;

public class JavaFileIndexer {
	
	Logger logger = Logger.getLogger(JavaFileIndexer.class);
	
	public void index(){

		String basePath = "/home/vjia/solr_deploy/solr_centos_web/sampledocs/eng";
		
		// file_name
		// file_path
		// file_content
		// file_create_time
		// file_modify_time
		// file_creator: administrator -- all set to default
		
		File sampleFolder = new File(basePath);
		String[] files = sampleFolder.list();
		for(String filename : files){
			logger.debug("filename="+filename);
			String fullFilename = basePath+File.separator+filename;
			logger.debug("fullFilename="+fullFilename);
			
			try{
				File textFile = new File(fullFilename);
				BufferedReader br = new BufferedReader(new FileReader(textFile));
				String line;
				StringBuffer body = new StringBuffer();
				while((line=br.readLine())!=null){
					debug("current line = %s", line, line);
					if(line.trim().length() == 0)	continue;
					line = sanitize(line);
					body.append(line);
				}
				
				// construct the JavaFile Object
				JavaFile entity = new JavaFile();
				
				
				RealIndexer indexer = new RealIndexer();
				indexer.index(entity);
				logger.debug("A FILE IS INDEXED COMPLETE ! ");
			} catch(FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void debug(String format, Object... line) {
		// TODO Auto-generated method stub
		if(format.length()==0)
			logger.debug(line);
		else 
			logger.debug(String.format(format, line));
	}
	/**
	 * encode 
	 * @param str
	 * @return
	 */
	private String sanitize(String str){
		
		return str;
	}
}
