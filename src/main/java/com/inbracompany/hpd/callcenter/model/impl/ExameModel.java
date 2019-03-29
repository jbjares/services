package com.inbracompany.hpd.callcenter.model.impl;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exame")
@Document(collection = "exame")
public class ExameModel  implements  IMongo, IMetadata{
	

	@Id
	private ObjectId _id;
	
	@XStreamAlias("guia")
	private Boolean guia;
	
	@XStreamAlias("autorizacao")
	private Boolean autorizacao;
	
	@XStreamAlias("municipio")
	private Boolean municipio;
	
	@XStreamAlias("exame")
	private String exame;
	
	@XStreamAlias("data")
	private String data;
	
	@XStreamAlias("hora")
	private String hora;
	
	@XStreamAlias("context")
	private String context;
	
	@XStreamAlias("preparo")
	private PreparoModel preparo;
	
	


	public PreparoModel getPreparo() {
		return preparo;
	}

	public void setPreparo(PreparoModel preparo) {
		this.preparo = preparo;
	}

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

	public Boolean getGuia() {
		return guia;
	}

	public void setGuia(Boolean guia) {
		this.guia = guia;
	}

	public Boolean getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(Boolean autorizacao) {
		this.autorizacao = autorizacao;
	}

	public Boolean getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Boolean municipio) {
		this.municipio = municipio;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
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
