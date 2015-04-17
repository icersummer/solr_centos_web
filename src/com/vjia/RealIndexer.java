package com.vjia;

import java.util.Date;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import com.vjia.indexable.Book;
import com.vjia.indexable.JavaFile;
import com.vjia.indexable.Person;
import com.vjia.indexer.solrindex.StandardIndexDelegate;

public class RealIndexer {
	
	Logger logger = Logger.getLogger(RealIndexer.class);
	
	private static final String baseURL = "http://192.168.71.151:8080/solr35/";
	private static final SolrServer solrServer;

	static {
		solrServer = new HttpSolrServer(baseURL);
	}
	
	/**
	 * @param indexable the entity to be indexed, e.g. Book, Person...
	 */
	public void index(Indexable indexable){
		
		IndexObject indexObject = null;// the Object passed to the real Index logic
		IndexDelegate indexDelegate= null;// the real Index logic class
		
		// build IndexObject
		indexObject= new IndexObject();
		populateIndexObject(indexable, indexObject);		
		indexObject.appendMetadataField(" somevalue ");
		
		// build SolrInputDocument, index it.
		SolrInputDocument solrInputDocument = createSolrDoc(indexObject);
		indexDelegate= new StandardIndexDelegate();
		indexDelegate.index(solrServer, solrInputDocument);
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
		
//		indexDelegate.index(solrServer, indexObject);
		
	}
	
	/**
	 * construct the IndexObject
	 * @param indexable
	 * @param indexObject
	 */
	private void populateIndexObject(Indexable indexable,
			IndexObject io) {
		// TODO Auto-generated method stub
		
		if(indexable instanceof JavaFile){
			JavaFile obj = (JavaFile)indexable;
			io.name = obj.name;
			io.fileName=obj.fileName;
			io.createTimestamp=obj.createTimestamp;
			io.modifyTimestamp=obj.modifyTimestamp;
			io.creator=obj.creator;
			io.modifier=obj.modifier;
			io.body=obj.body;
		} else if(indexable instanceof Book){
			
		} else if(indexable instanceof Person){
			
		} else {
			logger.debug("THE OBJECT IS NOT SUPPORT NOW.");
		}
		
	}

	private void addDynamicFieldValue(IndexObject indexObject, String name, String value){
	}
	
	private void addFieldToSolrInputDocument(SolrInputDocument inputDocument, String name, Object value){
		inputDocument.addField(name, value);
	}
	
	private SolrInputDocument createSolrDoc(IndexObject io){
		SolrInputDocument inputDocument= new SolrInputDocument();
		
		addFieldToSolrInputDocument(inputDocument,"id", io.fileName);
		addFieldToSolrInputDocument(inputDocument,"name", io.name);
		addFieldToSolrInputDocument(inputDocument,"fileName", io.fileName);
		addFieldToSolrInputDocument(inputDocument,"createTimestamp", io.createTimestamp);
		addFieldToSolrInputDocument(inputDocument,"modifyTimestamp", io.modifyTimestamp);
		addFieldToSolrInputDocument(inputDocument,"creator", io.creator);
		addFieldToSolrInputDocument(inputDocument,"modifier", io.modifier);
		addFieldToSolrInputDocument(inputDocument,"body", io.body.toString());
		
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
