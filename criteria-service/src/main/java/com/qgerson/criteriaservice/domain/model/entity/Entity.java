package com.qgerson.criteriaservice.domain.model.entity;

public abstract class Entity<T, TE> {
    public T id;
    public TE criteria;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Object getCriteria() {
        return criteria;
    }

    public void setCriteria(TE criteria) {
        this.criteria = criteria;
    }
}
