package com.inbracompany.hpd.callcenter.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@EnableMongoRepositories(value= {"com.inbracompany.hpd.callcenter.persistence.data.repository"})
@PropertySource("file:src/main/resources/hpdcallcenterconfig.properties")
@PropertySource("file:src/main/resources/log4j.properties")
@Configuration(value ="file:src/main/resources/application.yml")
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class AppConfig extends AbstractMongoConfiguration {
	
	  @Autowired
	  private Environment env;

	  @Override
	  protected String getDatabaseName() {
	    return env.getProperty("mongo.database");
	  }
	  
	  @Override
	  protected String getMappingBasePackage() {
	    return "com.inbracompany.hpd.callcenter.persistence.data.repository";
	  }

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(env.getProperty("mongo.host"), Integer.parseInt(env.getProperty("mongo.port")));
	}
	  
//	  @Bean
//	  @Override
//	  public CustomConversions customConversions() throws Exception {
//	    List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
//	    converterList.add(new org.springframework.data.mongodb.test.PersonReadConverter());
//	    converterList.add(new org.springframework.data.mongodb.test.PersonWriteConverter());
//	    return new CustomConversions(converterList);
//	  }
//
//	  @Bean
//	  public LoggingEventListener<MongoMappingEvent> mappingEventsListener() {
//	    return new LoggingEventListener<MongoMappingEvent>();
//	  }

}
