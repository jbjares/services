package com.inbracompany.hpd.callcenter.services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inbracompany.hpd.callcenter.action.CallcenterAction;
import com.inbracompany.hpd.callcenter.model.impl.CallerModel;
import com.inbracompany.hpd.callcenter.model.impl.CancelamentoModel;
import com.inbracompany.hpd.callcenter.model.impl.ConsultaModel;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;
import com.inbracompany.hpd.callcenter.model.impl.ConversationModel;
import com.inbracompany.hpd.callcenter.model.impl.ExameModel;
import com.inbracompany.hpd.callcenter.model.impl.PatientModel;
import com.inbracompany.hpd.callcenter.model.impl.PatientQueryModel;
import com.inbracompany.hpd.callcenter.model.impl.PreparoModel;

//@Configuration(value= "AppConfig.class")
//@Configuration(value= "SwaggerConfig.class")
//@ComponentScan(basePackageClasses = 
//{
//		com.inbracompany.hpd.callcenter.action.CallcenterAction.class,
//		com.inbracompany.hpd.callcenter.services.CallcenterService.class,
//		com.inbracompany.hpd.callcenter.model.impl.ContextModel.class,
//		com.inbracompany.hpd.callcenter.persistence.data.repository.IContextRepository.class
//})
@EnableAspectJAutoProxy
@RestController
@Service
public class CallcenterService {

	@Autowired CallcenterAction callcenterAction;
	
	//====================================================================
	//==== context: CREATE	
	@PostMapping(value = "/context")//http://localhost:8080/hpd/context
	ContextModel saveContext(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertContext(context);
	}
	//====================================================================
	
	
	//====================================================================
	//==== conversation: CREATE
	@PostMapping(value = "/conversation")
	ConversationModel saveConversation(@RequestBody ConversationModel obj) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertConversation(obj);
	}
	
	//==== conversation: UPDATE
	@PutMapping(value = "/conversation")
	ConversationModel updateConversation(@RequestBody ConversationModel obj) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertConversation(obj);
	}
	
	//==== conversation: VIEW
	@GetMapping(value = "/conversation")
	ConversationModel viewConversation(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException, Exception {
		return callcenterAction.retrieveConversation(context);
	}
	//====================================================================
	
	

	//====================================================================
	//==== conversation: CREATE
	@PostMapping(value = "/caller") //http://localhost:8080/hpd/caller
	CallerModel saveCaller(@RequestBody CallerModel caller) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertCaller(caller);
	}
	
	//==== conversation: UPDATE
	@PutMapping(value = "/caller") //http://localhost:8080/hpd/caller
	CallerModel updateCaller(@RequestBody CallerModel caller) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertCaller(caller);
	}
	
	//==== conversation: VIEW
	@GetMapping(value = "/caller")
	CallerModel viewCaller(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException, Exception {
		return callcenterAction.retrieveCaller(context);
	}
	//====================================================================

	
	
	//====================================================================
	//==== patient: CREATE
	@PostMapping(value = "/patient") //http://localhost:8080/hpd/caller
	PatientModel saveCaller(@RequestBody PatientModel patient) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertPatient(patient);
	}
	
	//==== patient: UPDATE
	@PutMapping(value = "/patient") //http://localhost:8080/hpd/caller
	PatientModel updateCaller(@RequestBody PatientModel patient) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertPatient(patient);
	}
	
	//==== patient: VIEW
	@GetMapping(value = "/patient")
	PatientModel viewPatient(@RequestBody PatientQueryModel patientQueryModel) throws NoSuchAlgorithmException, IOException, Exception {
		PatientModel patient = null;
		patient = callcenterAction.retrievePatientByDataNascimentoNomeCompleto(patientQueryModel);
		if(patient!=null) {
			return patient;
		}
		patient = callcenterAction.retrievePatientByDataNascimento(patientQueryModel);
		if(patient!=null) {
			return patient;
		}
		
		return callcenterAction.retrievePatientByNomeCompleto(patientQueryModel);
	}
	

	
	
	//====================================================================
	
	//====================================================================
	@PostMapping(value = "/consulta") //http://localhost:8080/hpd/caller
	ConsultaModel saveConsulta(@RequestBody ConsultaModel req) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertConsulta(req);
	}
	
	//==== patient: UPDATE
	@PutMapping(value = "/consulta") //http://localhost:8080/hpd/caller
	ConsultaModel updateConsulta(@RequestBody ConsultaModel req) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertConsulta(req);
	}
	
	//==== patient: VIEW: context
	@GetMapping(value = "/consulta")
	ConsultaModel viewConsultaByContext(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException, Exception {
		return callcenterAction.retrieveConsulta(context);
	}
	
	//====================================================================
	
	//====================================================================
	@PostMapping(value = "/exame") //http://localhost:8080/hpd/caller
	ExameModel saveExame(@RequestBody ExameModel req) throws Exception {
		PreparoModel preparo = callcenterAction.retrievePreparoByExame(req);
		req.setPreparo(preparo);
		return callcenterAction.upsertExame(req);
	}
	
	//==== patient: UPDATE
	@PutMapping(value = "/exame") //http://localhost:8080/hpd/caller
	ExameModel updateExame(@RequestBody ExameModel req) throws Exception {
		PreparoModel preparo = callcenterAction.retrievePreparoByExame(req);
		req.setPreparo(preparo);
		return callcenterAction.upsertExame(req);
	}
	
	//==== patient: VIEW: context
	@GetMapping(value = "/exame")
	ExameModel viewExameByContext(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException, Exception {
		return callcenterAction.retrieveExame(context);
	}
	
	//====================================================================
	
	//====================================================================
	@PostMapping(value = "/cancelamento") //http://localhost:8080/hpd/caller
	CancelamentoModel saveCancelamento(@RequestBody CancelamentoModel req) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertCancelamento(req);
	}
	
	//==== patient: UPDATE
	@PutMapping(value = "/cancelamento") //http://localhost:8080/hpd/caller
	CancelamentoModel updateCancelamento(@RequestBody CancelamentoModel req) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertCancelamento(req);
	}
	
	//==== patient: VIEW: context
	@GetMapping(value = "/cancelamento")
	CancelamentoModel viewCancelamentoByContext(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException, Exception {
		return callcenterAction.retrieveCancelamento(context);
	}
	
	//====================================================================
	
	
	//====================================================================
	@PostMapping(value = "/preparo") //http://localhost:8080/hpd/caller
	PreparoModel saveCancelamento(@RequestBody PreparoModel req) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertPreparo(req);
	}
	
	//==== patient: UPDATE
	@PutMapping(value = "/preparo") //http://localhost:8080/hpd/caller
	PreparoModel updateCancelamento(@RequestBody PreparoModel req) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.upsertPreparo(req);
	}
	
	//==== patient: VIEW: context
	@GetMapping(value = "/preparo")
	PreparoModel viewPreparoByContext(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException, Exception {
		return callcenterAction.retrievePreparoByContext(context);
	}
	
	//====================================================================
	
	
	
	//http://localhost:8080/hpd/ping
    @RequestMapping(value = "/ping")
    public String ping() {
       return "UP";
    }
    

}
