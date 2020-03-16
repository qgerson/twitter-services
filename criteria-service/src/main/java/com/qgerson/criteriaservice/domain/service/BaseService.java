package com.qgerson.criteriaservice.domain.service;

import com.qgerson.criteriaservice.domain.repository.CriteriaRepository;
import com.qgerson.criteriaservice.domain.repository.ReadingRepository;

import java.util.Collection;

public abstract class BaseService<TE,T> extends ReadingBaseService<TE,T> {
    private CriteriaRepository<TE,T> criteriaRepository;

    public BaseService(CriteriaRepository<TE, T> repository) {
        super(repository);
        this.criteriaRepository = repository;
    }

    public void add(TE entity) throws Exception{
        criteriaRepository.add( entity );
    }
    public Collection<TE> getAll(){
        return criteriaRepository.getAll();
    }
}
