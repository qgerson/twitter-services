package com.qgerson.criteriaservice.controllers;

import com.qgerson.criteriaservice.domain.model.entity.Criteria;
import com.qgerson.criteriaservice.domain.model.entity.Entity;
import com.qgerson.criteriaservice.domain.service.CriteriaService;
import com.qgerson.criteriaservice.domain.valueobjects.CriteriaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/criterion")
public class CriteriaController extends BaseController<Entity> {

    protected Logger logger = Logger.getLogger(CriteriaController.class.getName());

    protected CriteriaService criteriaService;

    @Autowired

    public CriteriaController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{criteriaId}")
    public ResponseEntity<Entity> findById(@PathVariable("criteriaId") String id){
        logger.info( String.format("criteria-service findById was invoked %s by %s", criteriaService.getClass().getName(), id) );
        id = id.trim();
        Entity criteria;
        try{
            criteria = criteriaService.get( id );
        } catch (Exception e){
            logger.log(Level.SEVERE,"Exception was rise on findById call " , e);
            return internalServerError();
        }
        return responseEntity( criteria );
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public  ResponseEntity<Collection<Criteria>> getAllCriterion() {
        logger.info( String.format("criteria-service getAllCriterion was invoked %s  ", criteriaService.getClass().getName() ) );
        Collection<Criteria> criterion;
        try{
            criterion = criteriaService.getAll();
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Exception was rise on findById call " , e);
            return internalError();
        }
        return  responseCollection( criterion );
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Criteria> addCriterion(@RequestBody CriteriaVO criteriaVO) {
        logger.info(String.format("criteria-service addCriterion() invoked: %s for %s", criteriaService.getClass().getName(), criteriaVO.getId() ));
        try{
            criteriaService.add( new Criteria( criteriaVO.getId(), criteriaVO.getCriteria() ) );
        }catch (Exception e) {
            logger.log(Level.WARNING, "Exception was raise by calling addCriterion REST service {0}", e);
            return unprocessableEntity();
        }
        return responseCreated();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST )
    public  ResponseEntity<Criteria> updateCriteria(@RequestBody CriteriaVO criteriaVO ){
        logger.info(String.format("criteria-service updateCriteria() invoked: %s for %s", criteriaService.getClass().getName(), criteriaVO.getId() ));
        try{
            criteriaService.update(  new Criteria( criteriaVO.getId(), criteriaVO.getCriteria() ) );
        }catch (Exception e){
            logger.log(Level.WARNING, "Exception was raise by calling updateCriteria REST service {0}", e);
            return unprocessableEntity();
        }
        return responseCreated();
    }

    @RequestMapping(value = "/remove/{id}", method= RequestMethod.GET)
     public ResponseEntity<Entity> removeCriteria(@PathVariable("id") String id) {
        logger.info( String.format("criteria-service removeCriteria was invoked %s by %s", criteriaService.getClass().getName(), id) );

        id = id.trim().toLowerCase();

        if( id.equalsIgnoreCase( Criteria.CRITERIA_KEY.FOLLOWERS.getValue() ) || id.equalsIgnoreCase( Criteria.CRITERIA_KEY.LANGUAGE.getValue() ) || id.equalsIgnoreCase( Criteria.CRITERIA_KEY.HASHTAG.getValue() ) )  {
            logger.log(Level.WARNING,String.format("It's does not possible to remove this id->%s from criterion repository", id ));
            return  responseLocked();
        }

        try{
            criteriaService.delete( id );
        } catch (Exception e){
            logger.log(Level.SEVERE,"Exception was rise on findById call " , e);
            return internalServerError();
        }
        return responseOk();
    }
}
