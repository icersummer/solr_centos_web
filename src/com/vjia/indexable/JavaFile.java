package com.vjia.indexable;

import java.util.Date;
import java.util.Hashtable;

import com.vjia.Indexable;

public class JavaFile implements Indexable {

	public String name;
	public String fileName;
	public Date createTimestamp;
	public Date modifyTimestamp;
	public String creator;
	public String modifier;
	public StringBuffer metadata;
	public StringBuffer body;
}
