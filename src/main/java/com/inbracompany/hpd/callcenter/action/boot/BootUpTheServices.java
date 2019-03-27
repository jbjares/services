package com.inbracompany.hpd.callcenter.action.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.inbracompany.hpd.callcenter"})
@EntityScan("com.inbracompany.hpd.callcenter.model.impl")
@SpringBootApplication
public class BootUpTheServices extends SpringBootServletInitializer {
	

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(BootUpTheServices.class, args);
    }
}
