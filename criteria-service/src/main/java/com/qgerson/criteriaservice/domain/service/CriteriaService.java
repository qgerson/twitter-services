package com.qgerson.criteriaservice.domain.service;

import com.qgerson.criteriaservice.domain.model.entity.Criteria;
import com.qgerson.criteriaservice.domain.model.entity.Entity;

import java.util.Collection;

public interface CriteriaService {
    public void add(Criteria criteria) throws Exception;

    public void update(Criteria criteria) throws Exception;

    public void delete(String id) throws Exception;

    public Criteria get(String id) throws Exception;

    public Collection<Criteria> getAll();
}
