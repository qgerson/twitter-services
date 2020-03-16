package com.qgerson.criteriaservice.domain.repository;

import com.qgerson.criteriaservice.domain.model.entity.Entity;

import java.util.Collection;

public interface ReadingRepository<TE, T> {

    boolean contains(T id);

    TE get( T id );

    Collection<TE> getAll();
}
