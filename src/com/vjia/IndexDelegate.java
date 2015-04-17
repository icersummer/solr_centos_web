package com.vjia;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;

public interface IndexDelegate {

	void index(SolrServer solrServer, SolrInputDocument solrInputDocument);

}
