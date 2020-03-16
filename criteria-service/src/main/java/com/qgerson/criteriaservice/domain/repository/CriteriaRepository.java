package com.qgerson.criteriaservice.domain.repository;

public interface CriteriaRepository<TE,T> extends ReadingRepository<TE,T> {
    void add(TE entity) throws Exception;

    void remove( T id);

    void update( TE entity );

}
