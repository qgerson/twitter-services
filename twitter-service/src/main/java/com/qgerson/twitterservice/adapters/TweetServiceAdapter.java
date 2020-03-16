package com.qgerson.twitterservice.adapters;

import com.qgerson.twitterservice.domain.Tweet;
import com.qgerson.twitterservice.ports.TweetRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Service
public class TweetServiceAdapter implements TweetRepositoryPort {

    private CriteriaBuilder criteriaBuilder;
    private Root<Tweet> tweet;
    private CriteriaQuery<Tweet> query;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void setIsValid(Integer id) throws Exception {
        Tweet tweet = entityManager.find(Tweet.class, id);
        if( tweet != null ) {
            tweet.setValid(true);
            entityManager.persist(tweet);
        }else {
            throw new Exception(String.format("There's no entity registered by iD-> %s", id));
        }
    }

    @Override
    public Tweet findById(Integer id) {
        getRepositoryConnection();
        return entityManager.find( Tweet.class, id  );
    }

    @Override
    public Collection<Tweet> findByUser(String user) {
        getRepositoryConnection();
        return  entityManager.createQuery( getEqualSelectionQuery("user",user) ).getResultList();
    }

    @Override
    public Collection<Tweet> findByLocation(String location) {
        getRepositoryConnection();
        return entityManager.createQuery( getLikeSelectionQuery("location",location) ).getResultList();
    }

    @Override
    public Collection<Tweet> findByLanguage(String languageId) {
        getRepositoryConnection();
        return entityManager.createQuery( getLikeSelectionQuery("languageId",languageId) ).getResultList();
    }

    @Override
    public Collection<Tweet> findValid() {
        getRepositoryConnection();
        return entityManager.createQuery( getEqualSelectionQuery("isValid",true) ).getResultList();
    }

    @Override
    public Collection<Tweet> findAll() {
        getRepositoryConnection();
        return entityManager.createQuery(query.select( tweet )).getResultList();
    }

    @Transactional
    @Override
    public void remove(Integer id) {
        entityManager.remove( id );
    }

    @Override
    public void getRepositoryConnection() {
        this.criteriaBuilder =  entityManager.getCriteriaBuilder();
        this.query = criteriaBuilder.createQuery(Tweet.class);
        this.tweet = query.from(Tweet.class);
    }

    private CriteriaQuery<Tweet> getLikeSelectionQuery(String key, Object value){
        return  query.select(tweet).where(criteriaBuilder.like( tweet.get( key ), "%"+value+"%" ) );
    }
    private CriteriaQuery<Tweet> getEqualSelectionQuery(String key, Object value){
        return  query.select(tweet).where(criteriaBuilder.equal( tweet.get( key ), value ) );
    }

}
