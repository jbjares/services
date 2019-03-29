package com.inbracompany.hpd.callcenter.model.impl;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inbracompany.hpd.callcenter.model.IMetadata;
import com.inbracompany.hpd.callcenter.model.IMongo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("context")
@Document(collection = "context")
public class ContextModel implements  IMongo, IMetadata, Serializable{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 5261593300769642821L;


		@Id
		@XStreamAlias("_id")
		private ObjectId _id;

		
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
		

}
