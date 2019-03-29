package com.inbracompany.hpd.callcenter.model.impl;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("consulta")
@Document(collection = "consulta")
public class ConsultaModel  implements  IMongo, IMetadata{
	

	@Id
	private ObjectId _id;
	

	
	@XStreamAlias("context")
	private String context;
	
	
	@XStreamAlias("data")
	private String data;
	
	@XStreamAlias("hora")
	private String hora;
	
	@XStreamAlias("medico")
	private String medico;
	
	@XStreamAlias("especialidade")
	private String especialidade;
	


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

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	
	
	
}
