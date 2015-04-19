package com.vjia;

import org.apache.solr.client.solrj.SolrServer;

public interface IndexDelegate {

	void index(SolrServer solrServer, IndexObject indexObject);

}
