package com.inbracompany.hpd.callcenter.persistence.data.repository;

import java.util.List;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.inbracompany.hpd.callcenter.model.impl.CallerModel;
import com.inbracompany.hpd.callcenter.model.impl.PatientModel;

@EnableAspectJAutoProxy
@Repository
public interface IPatientRepository extends CrudRepository<PatientModel, String>, QueryByExampleExecutor<PatientModel>  {
	
	
	//@Query("{context:'?0'}")
	//@Query(value="{}", fields="{ 'context' : ?0}")
	//@Query("{ 'context' : { $regex: ?0 } }")
	@Query(value="{}", fields="{'context' : {$elemMatch: {'context':?0}}}")
	List<PatientModel> findAllByContext(String context);
	
	//@Query("{context:'?0'}")
	//@Query(value="{}", fields="{ 'context' : ?0}")
	//@Query(value="{}", fields="{'nomeCompleto' : {$elemMatch: {'context':?0}}}")
	@Query("{ 'nomeCompleto' : { $regex: ?0 } }")
	List<PatientModel> findOneByNomeCompleto(String nomeCompleto);
	
	//@Query("{context:'?0'}")
	//@Query(value="{}", fields="{ 'context' : ?0}")
	@Query("{ 'dataNascimento' : { $regex: ?0 } }")
	List<PatientModel> findOneByDataNascimento(String dataNascimento);
	
	
	@Query("{ 'dataNascimento' : { $regex: ?0 }, 'nomeCompleto' : { $regex: ?1 }}")
	List<PatientModel> findOneByDataNascimentoNomeCompleto(String dataNascimento, String nomeCompleto);
	
}
