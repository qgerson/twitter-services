package com.qgerson.criteriaservice.domain.repository;

import com.qgerson.criteriaservice.domain.model.entity.Criteria;
import com.qgerson.criteriaservice.domain.model.entity.Language;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("criteriaRepository")
public class OnMemoryCriteriaRepository implements CriteriaRepository<Criteria, String> {

    private Map<String,Criteria > entities;

    public OnMemoryCriteriaRepository() {
        entities =  new HashMap<>();
        Criteria criteriaFollowers = new Criteria("followers", 1500L);
        entities.put( criteriaFollowers.getId(), criteriaFollowers );
        List<String> languageList = Arrays.asList("it","es","fr");
        Criteria criteriaLanguages = new Criteria( "languages", languageList );
        entities.put( criteriaLanguages.getId(), criteriaLanguages );
    }

    @Override
    public void add(Criteria entity) throws Exception {
        if( !entities.containsKey( entity.getId() ) ) {
            entities.put(entity.getId(), entity);
        }else {
            throw new Exception(
                    String.format( "There is already one criterion with this Id-> %s assigned", entity.getId() )
            );
        }
    }

    @Override
    public void remove(String id) {
        entities.remove( id );
    }

    @Override
    public void update(Criteria entity) {
        entity.setModified( true );
        if( entities.containsKey( entity.getId() ) ){
            entities.put( entity.getId(), entity );
        }
    }

    @Override
    public boolean contains(String id) {
        return false;
    }

    @Override
    public Criteria get(String id) {
        return entities.get( id );
    }

    @Override
    public Collection<Criteria> getAll() {
        return entities.values();
    }
}
