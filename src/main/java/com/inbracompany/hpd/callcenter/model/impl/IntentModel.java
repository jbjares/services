package com.inbracompany.hpd.callcenter.model.impl;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("intent")
@Document(collection = "intent")
public enum IntentModel implements  IMongo, Serializable{
	

	@XStreamAlias("consulta")
	CONSULTA("CONSULTA"), 
		@XStreamAlias("exames")
	EXAMES("EXAMES"), 
		@XStreamAlias("cancelamentos")
	CANCELAMENTOS("CANCELAMENTOS");  
	  
	 private final String value;  
	  
	 IntentModel(String value) {  
	   this.value = value;  
	 }  
	  
	 public static IntentModel fromValue(String value) {  
	   if (value != null) {  
	     for (IntentModel intent : values()) {  
	       if (intent.value.equals(value)) {  
	         return intent;  
	       }  
	     }  
	   }  

	   throw new RuntimeException("Error to define Intent Enum");
	 }  


}
