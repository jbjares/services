package com.inbracompany.hpd.callcenter.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.inbracompany.hpd.callcenter.model.impl.ContextModel;
import com.inbracompany.hpd.callcenter.persistence.data.repository.IContextRepository;

@EnableAspectJAutoProxy
@Service
public class ContextAction {
	
	@Autowired IContextRepository contextRepository;
	
	//TrackMessageOrg(name = "trackMessageOrg")
	public ContextModel saveContext(ContextModel contextModel) throws NoSuchAlgorithmException, IOException {
		return contextRepository.save(contextModel);
	}

}
