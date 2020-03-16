package com.qgerson.criteriaservice.domain.service;

import com.qgerson.criteriaservice.domain.repository.ReadingRepository;

public abstract class ReadingBaseService<TE,T> {
    private ReadingRepository<TE,T> repository;

    public ReadingBaseService(ReadingRepository<TE, T> repository) {
        this.repository = repository;
    }

}
