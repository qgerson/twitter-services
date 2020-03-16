package com.qgerson.twitterservice.domain;

public class Criteria {
    private String id;
    private Object criteria;

    public Criteria() {
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
