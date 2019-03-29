package com.inbracompany.hpd.callcenter.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("conversation")
@Document(collection = "conversation")
public class ConversationModel implements  IMongo, IMetadata, Serializable{

	private static final long serialVersionUID = 2994897932355760424L;

	@Id
	private ObjectId _id;
	
	@XStreamAlias("currently_intent")
	private IntentModel currentlyIntent;
	
	@XStreamImplicit(itemFieldName="previous_intent")
	private List<IntentModel> previousIntent = new ArrayList<IntentModel>();

	@XStreamAlias("context")	
	private String context;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	


	public IntentModel getCurrentlyIntent() {
		return currentlyIntent;
	}

	public void setCurrentlyIntent(IntentModel currentlyIntent) {
		this.currentlyIntent = currentlyIntent;
	}

	public List<IntentModel> getPreviousIntent() {
		return previousIntent;
	}

	public void setPreviousIntent(List<IntentModel> previousIntent) {
		this.previousIntent = previousIntent;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	
	
}
