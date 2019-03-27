package com.inbracompany.hpd.callcenter.persistence.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inbracompany.hpd.callcenter.model.impl.ResourceModel;

@Repository
public interface IResourceModelRepository extends CrudRepository<ResourceModel, String> {}
