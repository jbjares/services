package com.inbracompany.hpd.callcenter.model.impl;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

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
	
	@XStreamImplicit(itemFieldName="intents")
	private Map<IntentModel, PathModel> intents = new TreeMap<IntentModel, PathModel>();

	private String context;
	
	

    public Map<IntentModel, PathModel> getIntents() {
		return intents;
	}

	public void setIntents(Map<IntentModel, PathModel> intents) {
		this.intents = intents;
	}

	public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

	@Override
	public void setContext(String context) {
		this.context=context;
	}

	@Override
	public String getContext() {
		return this.context;
	}

	
}
