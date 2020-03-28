package com.qgerson.criteriaservice.domain.service;

import com.qgerson.criteriaservice.domain.model.entity.Criteria;
import com.qgerson.criteriaservice.domain.model.entity.Entity;

import java.util.Collection;

public interface CriteriaService {
    void add(Criteria criteria) throws Exception;

    void update(Criteria criteria) throws Exception;

    void delete(String id) throws Exception;

    Criteria get(String id) throws Exception;

    Collection<Criteria> getAll();
}
