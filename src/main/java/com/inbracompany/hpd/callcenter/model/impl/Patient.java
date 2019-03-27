package com.inbracompany.hpd.callcenter.model.impl;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("patient")
@Document(collection = "patient")
public class Patient  implements  IMongo, IMetadata{
	

	@Id
	private ObjectId _id;
	
	@XStreamAlias("fullName")
	private String fullName;
	
	@XStreamAlias("context")
	private String context;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	
	
}
