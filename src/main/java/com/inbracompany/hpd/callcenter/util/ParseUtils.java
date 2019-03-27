package com.inbracompany.hpd.callcenter.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.converter.json.GsonFactoryBean;

import com.google.gson.Gson;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;

public class ParseUtils {
	
	public static String getException(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}
	
	public static String getJsonObjFromObject(Object context) {
		Gson gson = new Gson();
		String result = gson.toJson(context);
		return result;
	}
	

}
