package com.qgerson.criteriaservice.domain.model.entity;

public  abstract class BaseEntity<T,TE> extends Entity<T,TE> {

    private boolean isModified;

    public BaseEntity( T id, TE criteria){
        super.setId( id );
        super.setCriteria( criteria );
        this.isModified = false;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }
}
