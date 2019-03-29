package com.inbracompany.hpd.callcenter.model.impl;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("sexo")
@Document(collection = "sexo")
public enum SexoModel implements  IMongo, Serializable{
	

	@XStreamAlias("masculino")
	MASCULINO("MASCULINO"), 
		@XStreamAlias("feminino")
	FEMININO("FEMININO");
	
	 private final String value;  
	  
	 SexoModel(String value) {  
	   this.value = value;  
	 }  
	  
	 public static SexoModel fromValue(String value) {  
	   if (value != null) {  
	     for (SexoModel intent : values()) {  
	       if (intent.value.equals(value)) {  
	         return intent;  
	       }  
	     }  
	   }  

	   throw new RuntimeException("Error to define Intent Enum");
	 }  



}
