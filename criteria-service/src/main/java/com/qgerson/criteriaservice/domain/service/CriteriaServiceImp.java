package com.qgerson.criteriaservice.domain.service;

import com.qgerson.criteriaservice.domain.model.entity.Criteria;
import com.qgerson.criteriaservice.domain.model.entity.Entity;
import com.qgerson.criteriaservice.domain.repository.CriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("criteriaService")
public class CriteriaServiceImp extends BaseService<Criteria, String> implements CriteriaService {

    private CriteriaRepository<Criteria,String> criteriaRepository;

    @Autowired
    public CriteriaServiceImp( CriteriaRepository<Criteria, String> criteriaRepository) {
        super( criteriaRepository );
        this.criteriaRepository = criteriaRepository;
    }

    @Override
    public void add(Criteria entity) throws Exception {
        if( entity.getId() == null || "".equalsIgnoreCase( entity.getId() ) ){
            throw new Exception( "Criteria Id cannot be null or empty String");
        }

        super.add(entity);
    }

    @Override
    public void update(Criteria criteria) throws Exception {
        criteriaRepository.update( criteria );
    }

    @Override
    public void delete(String id) throws Exception {
        criteriaRepository.remove( id );
    }

    @Override
    public Criteria get(String id) throws Exception {
        return  criteriaRepository.get( id );
    }

    @Override
    public Collection<Criteria> getAll() {
        return super.getAll();
    }
}
