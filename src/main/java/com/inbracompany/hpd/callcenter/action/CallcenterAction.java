package com.inbracompany.hpd.callcenter.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.inbracompany.hpd.callcenter.model.impl.CallerModel;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;
import com.inbracompany.hpd.callcenter.persistence.data.repository.ICallerRepository;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IContextRepository;

@EnableAspectJAutoProxy
@Service
public class CallcenterAction {
	
	@Autowired IContextRepository contextRepository;
	
	@Autowired ICallerRepository callerRepository;
	
	//@Autowired MongoTemplate mongot;
	
	//TrackMessageOrg(name = "trackMessageOrg")
	public ContextModel saveContext(ContextModel contextModel) throws NoSuchAlgorithmException, IOException {
		return contextRepository.save(contextModel);
	}
	
	public CallerModel saveCaller(CallerModel caller) throws NoSuchAlgorithmException, IOException {
		return callerRepository.save(caller);
	}

	public  CallerModel getCaller(ContextModel context) throws Exception {
		Gson gson = new Gson();
		String contextStr = gson.toJson(context);
		JSONObject mJSONObject = new JSONObject(contextStr);
		contextStr = mJSONObject.get("context").toString();
		CallerModel caller = callerRepository.findCallerByContext(contextStr).get(0);
		Optional<CallerModel> opt = callerRepository.findById(caller.get_id().toString());
		System.out.println(opt.get());
		return opt.get();
	}
	
	


}
