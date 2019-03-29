package com.inbracompany.hpd.callcenter.model.impl;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("patientQuery")
public class PatientQueryModel  implements  Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5762852769432164194L;


	@XStreamAlias("nomeCompleto")
	private String nomeCompleto;

	
	@XStreamAlias("dataNascimento")
	private String dataNascimento;
	
	@XStreamAlias("context")
	private String context;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	
}
