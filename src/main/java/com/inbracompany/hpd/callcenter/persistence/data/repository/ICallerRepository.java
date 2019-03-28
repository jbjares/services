package com.inbracompany.hpd.callcenter.persistence.data.repository;

import java.util.List;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.inbracompany.hpd.callcenter.model.impl.CallerModel;

@EnableAspectJAutoProxy
@Repository
public interface ICallerRepository extends CrudRepository<CallerModel, String>, QueryByExampleExecutor<CallerModel>  {
	
	
	//@Query("{context:'?0'}")
	//@Query(value="{}", fields="{ 'context' : ?0}")
	//@Query("{ 'context' : { $regex: ?0 } }")
	@Query(value="{}", fields="{'context' : {$elemMatch: {'context':?0}}}")
	List<CallerModel> findCallerByContext(String context);
	
}