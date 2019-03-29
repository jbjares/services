package com.inbracompany.hpd.callcenter.util;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Ignore;
import org.junit.Test;

import com.inbracompany.hpd.callcenter.model.impl.CallerModel;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;
import com.inbracompany.hpd.callcenter.model.impl.ConversationModel;
import com.inbracompany.hpd.callcenter.model.impl.IntentModel;
import com.inbracompany.hpd.callcenter.model.impl.PatientModel;
import com.inbracompany.hpd.callcenter.model.impl.PlanoSaudeModel;
import com.inbracompany.hpd.callcenter.model.impl.PatientQueryModel;
import com.inbracompany.hpd.callcenter.model.impl.SexoModel;



public class ParseUtilsTest {
	

	private static final String CONTEXT = "565677567676769779";
	
	@Ignore
	@Test
	public void parseJsonFromContextt() {
		ContextModel context = new ContextModel();
		context.setContext(CONTEXT);
		//{"context":"565677567676769779"}
		System.out.println(ParseUtils.getJsonObjFromObject(context));
	}
	
	@Ignore
	@Test
	public void parseJsonFromCaller() {
		CallerModel caller = new CallerModel();
		caller.setContext(CONTEXT);
		caller.setNomeCompleto("Joao Bosco Jares");
		//{"nomeCompleto":"Joao Bosco Jares","context":"565677567676769779"}
		System.out.println(ParseUtils.getJsonObjFromObject(caller));
	}
	
	@Ignore
	@Test
	public void parseJsonFromConversation() {
		ConversationModel conversation = new ConversationModel();
		conversation.setContext(CONTEXT);
		conversation.setCurrentlyIntent(IntentModel.CONSULTA);
		conversation.setPreviousIntent(Arrays.asList(IntentModel.CANCELAMENTOS,IntentModel.ONCOLOGIA));
		//{"currentlyIntent":"CONSULTA","previousIntent":["CANCELAMENTOS","ONCOLOGIA"],"context":"565677567676769779"}
		System.out.println(ParseUtils.getJsonObjFromObject(conversation));
	}
	
	@Ignore
	@Test
	public void parseJsonFromPatient() {
		PatientModel patient = getPatientMock();
		//{"nomeCompleto":"Joao Bosco Jares","context":"565677567676769779","planoSaude":"UNIMED","previousContext":[],"cpf":"1234567989","nacionalidade":"Brasileira","sexo":"MASCULINO","religiao":"Catolico","telefone":"11989252380","email":"jbjares@gmail.com","fluenciaPT_br":true,"dataNascimento":"28 de Junho de 1982"}
		System.out.println(ParseUtils.getJsonObjFromObject(patient));
	}
	
	@Test
	public void parseJsonFromRequisicao() {
		PatientQueryModel qe = new PatientQueryModel();
		qe.setDataNascimento("28 06 82");
		qe.setNomeCompleto("Joao Bosco Jares");
		//{"nomeCompleto":"Joao Bosco Jares","dataNascimento":"28 06 82"}
		System.out.println(ParseUtils.getJsonObjFromObject(qe));
	}
	
	
	public PatientModel getPatientMock() {
		PatientModel patient = new PatientModel();
		
		patient.setContext("565677567676769779");
		patient.setCpf("1234567989");
		patient.setEmail("jbjares@gmail.com");
		patient.setFluenciaPT_br(Boolean.TRUE);
		patient.setNacionalidade("Brasileira");
		patient.setNomeCompleto("Joao Bosco Jares");
		patient.setPlanoSaude(PlanoSaudeModel.UNIMED);
		patient.setPreviousContext(Collections.EMPTY_LIST);
		patient.setReligiao("Catolico");
		patient.setSexo(SexoModel.MASCULINO);
		patient.setTelefone("11989252380");
		patient.setDataNascimento("28 de Junho de 1982");
		return patient;
	}

}
