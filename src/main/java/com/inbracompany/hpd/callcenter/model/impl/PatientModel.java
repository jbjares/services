package com.inbracompany.hpd.callcenter.model.impl;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("patient")
@Document(collection = "patient")
public class PatientModel  implements  IMongo, IMetadata{
	

	@Id
	private ObjectId _id;
	
	@XStreamAlias("nomeCompleto")
	private String nomeCompleto;
	
	@XStreamAlias("context")
	private String context;
	
	@XStreamAlias("planoSaude")
	private PlanoSaudeModel planoSaude;
	
	@XStreamImplicit(itemFieldName="previousContext")
	private List<ContextModel> previousContext = new ArrayList<ContextModel>();
	
	@XStreamAlias("cpf")
	private String cpf;
	
	@XStreamAlias("nacionalidade")
	private String nacionalidade;
	
	@XStreamAlias("sexo")
	private SexoModel sexo;

	@XStreamAlias("religiao")
	private String religiao;

	@XStreamAlias("telefone")
	private String telefone;
	
	@XStreamAlias("email")
	private String email;
	
	@XStreamAlias("fluenciaPT_br")
	private Boolean fluenciaPT_br;
	
	
	
	@XStreamAlias("dataNascimento")
	private String dataNascimento;


	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public PlanoSaudeModel getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaudeModel planoSaude) {
		this.planoSaude = planoSaude;
	}

	public List<ContextModel> getPreviousContext() {
		return previousContext;
	}

	public void setPreviousContext(List<ContextModel> previousContext) {
		this.previousContext = previousContext;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public SexoModel getSexo() {
		return sexo;
	}

	public void setSexo(SexoModel sexo) {
		this.sexo = sexo;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getFluenciaPT_br() {
		return fluenciaPT_br;
	}

	public void setFluenciaPT_br(Boolean fluenciaPT_br) {
		this.fluenciaPT_br = fluenciaPT_br;
	}
	
	
	
}
