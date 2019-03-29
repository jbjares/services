package com.inbracompany.hpd.callcenter.model.impl;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cancelamento")
@Document(collection = "cancelamento")
public class CancelamentoModel  implements  IMongo, IMetadata{
	

	@Id
	private ObjectId _id;
	
	@XStreamAlias("data")
	private String data;
	
	@XStreamAlias("hora")
	private String hora;
	
	@XStreamAlias("context")
	private String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	

	
	
}
