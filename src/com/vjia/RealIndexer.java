package com.vjia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;

public class RealIndexer {
	
	Logger logger = Logger.getLogger(RealIndexer.class);
	
	SolrServer solrServer = null;

	/**
	 * @param indexable the entity to be indexed, e.g. Book, Person...
	 */
	public void index(Indexable indexable){
		
		IndexObject indexObject = null;// the Object passed to the real Index logic
		IndexDelegate indexDelegate= null;// the real Index logic class
		
		populateIndexObject(indexable, indexObject);
		
		indexObject.appendMetadataField(" somevalue ");
		
		indexDelegate.index(solrServer, indexObject);
		
	}
	
	private void debug(String format, Object... line) {
		// TODO Auto-generated method stub
		logger.debug(String.format(format, line));
	}

	public void index_(){
		String basePath = "/home/vjia/solr_deploy/solr_centos_web/sampledocs/eng";
		
		// file_name
		// file_path
		// file_content
		// file_create_time
		// file_modify_time
		// file_creator: administrator -- all set to default
		
		Indexable indexable= null;// the entity to be indexed, e.g. Book, Person...
		IndexObject indexObject = null;// the Object passed to the real Index logic
		IndexDelegate indexDelegate= null;// the real Index logic class
		
		populateIndexObject(indexable, indexObject);
		
		indexObject.appendMetadataField(" somevalue ");
		
		indexDelegate.index(solrServer, indexObject);
		
	}
	
	/**
	 * construct the IndexObject
	 * @param indexable
	 * @param indexObject
	 */
	private void populateIndexObject(Indexable indexable,
			IndexObject indexObject) {
		// TODO Auto-generated method stub
		
	}

	private void addDynamicFieldValue(IndexObject indexObject, String name, String value){
	}
	
	private void addFieldToSolrInputDocument(SolrInputDocument inputDocument, String name, Object value){
		inputDocument.addField(name, value);
	}
	
	private Object createSolrDoc(IndexObject io){
		SolrInputDocument inputDocument= null;
		
		addFieldToSolrInputDocument(inputDocument,"name", io.name);
		addFieldToSolrInputDocument(inputDocument,"createTimestamp", io.createTimestamp);
		addFieldToSolrInputDocument(inputDocument,"metadata", io.metadata.toString());
		
		return inputDocument;
	}
	
	/**
	 * encode 
	 * @param str
	 * @return
	 */
	private String sannitize(String str){
		
		return null;
	}

}
