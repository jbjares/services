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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inbracompany.hpd.callcenter.action.CallcenterAction;
import com.inbracompany.hpd.callcenter.model.impl.CallerModel;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;

@Configuration(value= "AppConfig.class")
@ComponentScan(basePackageClasses = 
{
		com.inbracompany.hpd.callcenter.action.CallcenterAction.class,
		com.inbracompany.hpd.callcenter.services.CallcenterService.class,
		com.inbracompany.hpd.callcenter.model.impl.ContextModel.class,
		com.inbracompany.hpd.callcenter.persistence.data.repository.IContextRepository.class
})
@EnableAspectJAutoProxy
@RestController
@Service
public class CallcenterService {

	@Autowired CallcenterAction callcenterAction;
	

	//http://localhost:8080/hpd/context
	@PostMapping(value = "/addContext")
	ContextModel saveContext(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.saveContext(context);
	}
	


	//http://localhost:8080/hpd/caller
	@PostMapping(value = "/addCaller")
	CallerModel saveCaller(@RequestBody CallerModel caller) throws NoSuchAlgorithmException, IOException {
		return callcenterAction.saveCaller(caller);
	}
	
	
	@GetMapping(value = "/viewCaller")
	CallerModel saveCaller(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException, Exception {
		return callcenterAction.getCaller(context);
	}
	
	
	
	//http://localhost:8080/hpd/ping
    @RequestMapping(value = "/ping")
    public String hello2() {
       return "UP";
    }
    

}
