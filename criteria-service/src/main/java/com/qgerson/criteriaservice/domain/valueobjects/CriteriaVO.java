package com.qgerson.criteriaservice.domain.valueobjects;

public class CriteriaVO {

    private String id;
    private Object criteria;

    public CriteriaVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCriteria() {
        return criteria;
    }

    public void setCriteria(Object criteria) {
        this.criteria = criteria;
    }
}
