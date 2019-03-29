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

	private static final long serialVersionUID = 2994897932355760424L;

	@Id
	private ObjectId _id;
	
	@XStreamAlias("nomeCompleto")
	private String nomeCompleto;

	@XStreamAlias("context")	
	private String context;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	
	

	
}
