package com.inbracompany.hpd.callcenter.model.impl;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exame")
@Document(collection = "exame")
public class PreparoModel  implements  IMongo, IMetadata{
	

	@Id
	private ObjectId _id;
	
	@XStreamAlias("exame")
	private Boolean exame;

	
	@XStreamAlias("context")
	private String context;


	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public Boolean getExame() {
		return exame;
	}


	public void setExame(Boolean exame) {
		this.exame = exame;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}
	



	
}
