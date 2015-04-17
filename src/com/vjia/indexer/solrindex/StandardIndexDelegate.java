package com.vjia.indexer.solrindex;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import com.vjia.IndexDelegate;

public class StandardIndexDelegate implements IndexDelegate {
	private static final Logger logger= Logger.getLogger(StandardIndexDelegate.class);

	@Override
	public void index(SolrServer solrServer, SolrInputDocument doc) {
		// TODO Auto-generated method stub
		try {
			UpdateResponse updateResponse = solrServer.add(doc);
			solrServer.commit();
			String requestUrl = updateResponse.getRequestUrl();
			int status = updateResponse.getStatus();
			int qtime = updateResponse.getQTime();
			logger.debug(String.format("requestUrl=%s, status=%d, qtime=%d", requestUrl, status, qtime));
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
