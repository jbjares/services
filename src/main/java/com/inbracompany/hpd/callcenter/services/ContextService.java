package com.inbracompany.hpd.callcenter.services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inbracompany.hpd.callcenter.action.ContextAction;
import com.inbracompany.hpd.callcenter.app.config.AppConfig;
import com.inbracompany.hpd.callcenter.model.impl.ContextModel;

@ContextConfiguration(classes = { AppConfig.class })
@ComponentScan(basePackageClasses = 
{
		com.inbracompany.hpd.callcenter.action.ContextAction.class,
		com.inbracompany.hpd.callcenter.services.ContextService.class,
		com.inbracompany.hpd.callcenter.model.impl.ContextModel.class,
		com.inbracompany.hpd.callcenter.persistence.data.repository.IContextRepository.class
})
@EnableAspectJAutoProxy
@RestController
@Service
public class ContextService {

	@Autowired ContextAction contextAction;

	
	@PostMapping(value = "/context")
	ContextModel newEmployee(@RequestBody ContextModel context) throws NoSuchAlgorithmException, IOException {
		return contextAction.saveContext(context);
	}
	
	
	//http://localhost:8080/hpd/Hello
    @RequestMapping(value = "/Hello")
    public String hello2() {
       return "Hello World from Tomcat";
    }
    
    //http://localhost:8080/hpd/hpd/Hi
    @RequestMapping(value = "/hpd/Hi")
    public String hello1() {
       return "Hi World from Tomcat";
    }

}
