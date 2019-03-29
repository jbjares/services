package com.inbracompany.hpd.callcenter.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.inbracompany.hpd.callcenter.model.impl.CallerModel;
import com.inbracompany.hpd.callcenter.model.impl.CancelamentoModel;
import com.inbracompany.hpd.callcenter.model.impl.ConsultaModel;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;
import com.inbracompany.hpd.callcenter.model.impl.ConversationModel;
import com.inbracompany.hpd.callcenter.model.impl.ExameModel;
import com.inbracompany.hpd.callcenter.model.impl.PatientModel;
import com.inbracompany.hpd.callcenter.model.impl.PatientQueryModel;
import com.inbracompany.hpd.callcenter.model.impl.PreparoModel;
import com.inbracompany.hpd.callcenter.persistence.data.repository.ICallerRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.ICancelamentoRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IConsultaRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IContextRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IConversationRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IExameRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IPatientRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IPreparoRepository;

@EnableAspectJAutoProxy
@Service
public class CallcenterAction {
	
	@Autowired IContextRepository contextRepository;
	
	@Autowired ICallerRepository callerRepository;
	
	@Autowired IConversationRepository conversationRepository;
	
	@Autowired IPatientRepository patientRepository;
	
	@Autowired IConsultaRepository consultaRepository;
	
	@Autowired IExameRepository exameRepository;
	
	@Autowired ICancelamentoRepository cancelamentoRepository;
	
	@Autowired IPreparoRepository preparoRepository;
	
	
	public PreparoModel upsertPreparo(PreparoModel obj) throws NoSuchAlgorithmException, IOException {
		return preparoRepository.save(obj);
	}
	
	public ConsultaModel upsertConsulta(ConsultaModel obj) throws NoSuchAlgorithmException, IOException {
		return consultaRepository.save(obj);
	}
	
	public ExameModel upsertExame(ExameModel obj) throws NoSuchAlgorithmException, IOException {
		return exameRepository.save(obj);
	}
	
	public CancelamentoModel upsertCancelamento(CancelamentoModel obj) throws NoSuchAlgorithmException, IOException {
		return cancelamentoRepository.save(obj);
	}
	

	public ContextModel upsertContext(ContextModel obj) throws NoSuchAlgorithmException, IOException {
		return contextRepository.save(obj);
	}
	
	public ConversationModel upsertConversation(ConversationModel obj) throws NoSuchAlgorithmException, IOException {
		return conversationRepository.save(obj);
	}
	
	
	public CallerModel upsertCaller(CallerModel caller) throws NoSuchAlgorithmException, IOException {
		return callerRepository.save(caller);
	}
	
	public PatientModel upsertPatient(PatientModel patient) throws NoSuchAlgorithmException, IOException {
		return patientRepository.save(patient);
	}
	

	

	public  PatientModel retrievePatientByDataNascimentoNomeCompleto(PatientQueryModel patientQueryModel) throws Exception {
		Gson gson = new Gson();
		String contextStr1 = gson.toJson(patientQueryModel);
		JSONObject mJSONObject1 = new JSONObject(contextStr1);
		contextStr1 = mJSONObject1.get("dataNascimento").toString();
		//
		String contextStr2 = gson.toJson(patientQueryModel);
		JSONObject mJSONObject2 = new JSONObject(contextStr2);
		contextStr2 = mJSONObject2.get("nomeCompleto").toString();
		
		List<PatientModel> result = patientRepository.findOneByDataNascimentoNomeCompleto(contextStr1,contextStr2);
		PatientModel caller = null;
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = patientRepository.findOneByDataNascimentoNomeCompleto(contextStr1,contextStr2).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<PatientModel> opt = patientRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	
	public  PatientModel retrievePatientByDataNascimento(PatientQueryModel patientQueryModel) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(patientQueryModel);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("dataNascimento").toString();
		
		List<PatientModel> result = patientRepository.findOneByDataNascimento(contextStr);
		PatientModel caller = null;
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = patientRepository.findOneByDataNascimento(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<PatientModel> opt = patientRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	
	public  PatientModel retrievePatientByNomeCompleto(PatientQueryModel patientQueryModel) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(patientQueryModel);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("nomeCompleto").toString();
		
		List<PatientModel> result = patientRepository.findOneByNomeCompleto(contextStr);
		PatientModel caller = null;
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = patientRepository.findOneByNomeCompleto(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<PatientModel> opt = patientRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}
	}
	
	public  PatientModel retrievePatientByContext(PatientQueryModel patientQueryModel) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(patientQueryModel);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		
		List<PatientModel> result = patientRepository.findAllByContext(contextStr);
		PatientModel caller = null;
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = patientRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<PatientModel> opt = patientRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}
		

	}

	public  CallerModel retrieveCaller(ContextModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		CallerModel caller = null;
		List<CallerModel> result = callerRepository.findAllByContext(contextStr);
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = callerRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<CallerModel> opt = callerRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	

	public  ConversationModel retrieveConversation(ContextModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		
		ConversationModel caller = null;
		List<ConversationModel> result = conversationRepository.findAllByContext(contextStr);
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = conversationRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<ConversationModel> opt = conversationRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	
	
	//
	
	public  CancelamentoModel retrieveCancelamento(ContextModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		
		CancelamentoModel caller = null;
		List<CancelamentoModel> result = cancelamentoRepository.findAllByContext(contextStr);
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = cancelamentoRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<CancelamentoModel> opt = cancelamentoRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	
	//
	public  ExameModel retrieveExame(ContextModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		
		ExameModel caller = null;
		List<ExameModel> result = exameRepository.findAllByContext(contextStr);
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = exameRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<ExameModel> opt = exameRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	
	//
	public  ConsultaModel retrieveConsulta(ContextModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		
		ConsultaModel caller = null;
		List<ConsultaModel> result = consultaRepository.findAllByContext(contextStr);
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = consultaRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<ConsultaModel> opt = consultaRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	
	//==
	
	public  PreparoModel retrievePreparoByContext(ContextModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		
		PreparoModel caller = null;
		List<PreparoModel> result = preparoRepository.findAllByContext(contextStr);
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = preparoRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<PreparoModel> opt = preparoRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	
	public  PreparoModel retrievePreparoByExame(ExameModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("exame").toString();
		
		PreparoModel caller = null;
		List<PreparoModel> result = preparoRepository.findAllByExame(contextStr);
		if(!result.isEmpty() && result.get(0)!=null) {
			caller = preparoRepository.findAllByContext(contextStr).get(0);			
		}
		if(caller!=null && caller.get_id()!=null && !"".equals(caller.get_id())) {
			Optional<PreparoModel> opt = preparoRepository.findById(caller.get_id().toString());
			System.out.println(opt.get());
			return opt.get();
		}else {
			return null;
		}

	}
	


}
