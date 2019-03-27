package com.inbracompany.hpd.callcenter.model.impl;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("path")
@Document(collection = "path")
public class PathModel  implements IMongo{
	

	@Id
	private ObjectId _id;
	
	@XStreamAlias("intent")
	private IntentModel intent;
	
	
	
	public PathModel(String name,IntentModel intent) {
		super();
		this.intent=intent;
	}




	
	

}
