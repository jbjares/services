package com.inbracompany.hpd.callcenter.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inbracompany.hpd.callcenter.model.impl.ContextModel;


@RunWith(SpringJUnit4ClassRunner.class)
public class ParseUtilsTest {
	
	
	@Test
	public void parseJsonFromObject() {
		ContextModel context = new ContextModel();
		context.setContext("565677567676769779");
		System.out.println(ParseUtils.getJsonObjFromObject(context));
	}

}
