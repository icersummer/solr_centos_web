package com.vjia;

import java.util.Date;
import java.util.Hashtable;

public class IndexObject {
	
	private static final String CLASSNAME = IndexObject.class.getName();
	
	public String name;
	public String fileName;
	public Date createTimestamp;
	public Date modifyTimestamp;
	public String creator;
	public String modifier;
	public StringBuffer metadata;
	public Hashtable customFields;
	public StringBuffer body;
	
	public IndexObject(){
		metadata= new StringBuffer();
		customFields= new Hashtable();
		body = new StringBuffer();
	}

	public void appendMetadataField(String value) {
		// TODO Auto-generated method stub
		metadata.append(value).append(' ');
	}
	
	public void addField(String fieldName, String value){
		customFields.put(fieldName, value);
	}
	
	//TODO logic of KeywordsLeadingWildcard

}
