package com.inbracompany.hpd.callcenter.model.impl;
import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("caller")
@Document(collection = "caller")
public class CallerModel  implements  IMongo, IMetadata, Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2994897932355760424L;

	@Id
	private ObjectId _id;
	
	@XStreamAlias("name")
	private String name;
	
	@XStreamAlias("intent")
	private IntentModel intent;

	@XStreamAlias("context")	
	private String context;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IntentModel getIntent() {
		return intent;
	}

	public void setIntent(IntentModel intent) {
		this.intent = intent;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
