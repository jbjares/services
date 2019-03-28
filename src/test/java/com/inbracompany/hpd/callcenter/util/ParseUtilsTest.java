package com.inbracompany.hpd.callcenter.util;

import org.junit.Ignore;
import org.junit.Test;

import com.inbracompany.hpd.callcenter.model.impl.CallerModel;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;
import com.inbracompany.hpd.callcenter.model.impl.IntentModel;



public class ParseUtilsTest {
	

	@Test
	public void parseJsonFromContextt() {
		ContextModel context = new ContextModel();
		context.setContext("565677567676769779");
		System.out.println(ParseUtils.getJsonObjFromObject(context));
	}
	@Ignore
	@Test
	public void parseJsonFromCaller() {
		CallerModel caller = new CallerModel();
		caller.setContext("565677567676769779");
		caller.setName("jbjares");
		caller.setIntent(IntentModel.CONSULTA);
		System.out.println(ParseUtils.getJsonObjFromObject(caller));
	}

}
