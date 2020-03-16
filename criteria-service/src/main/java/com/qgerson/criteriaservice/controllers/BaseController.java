package com.qgerson.criteriaservice.controllers;

import com.qgerson.criteriaservice.domain.model.entity.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;

public class BaseController<TE> {

    public ResponseEntity< TE >  responseEntity( TE entity) {
        return entity != null
                ? new ResponseEntity<TE>(entity, HttpStatus.OK)
                : new ResponseEntity<TE>(HttpStatus.NO_CONTENT);
    }

    public  ResponseEntity<TE>  responseOk(){
        return  new ResponseEntity<TE>(HttpStatus.OK);
    }

    public ResponseEntity<TE> internalServerError() {
        return new ResponseEntity<TE>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Collection<Criteria>> responseCollection( Collection<Criteria> collection) {
        return collection.size() > 0
                ? new ResponseEntity<Collection<Criteria>>( collection, HttpStatus.OK)
                : new ResponseEntity<Collection<Criteria>>( HttpStatus.NO_CONTENT );
    }

    public ResponseEntity<Collection<Criteria>> internalError() {
        return new ResponseEntity<Collection<Criteria>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Criteria>  unprocessableEntity() {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity<Criteria> responseCreated() {
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<TE> responseLocked(){
        return new ResponseEntity<TE>(HttpStatus.LOCKED);
    }

}
