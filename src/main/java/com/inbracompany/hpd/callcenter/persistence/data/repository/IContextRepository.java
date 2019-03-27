package com.inbracompany.hpd.callcenter.persistence.data.repository;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inbracompany.hpd.callcenter.model.impl.ContextModel;

@EnableAspectJAutoProxy
@Repository
public interface IContextRepository extends CrudRepository<ContextModel, String> {}
