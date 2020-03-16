package com.qgerson.twitterservice.ports;

import com.qgerson.twitterservice.domain.Tweet;

import java.util.Collection;

public interface TweetRepositoryPort {

    void setIsValid( Integer id) throws Exception;

    Tweet findById( Integer id );

    Collection<Tweet> findByUser(String user );

    Collection<Tweet> findByLocation( String location );

    Collection<Tweet> findByLanguage( String languageId );

    Collection<Tweet> findValid();

    Collection<Tweet> findAll();

    void remove( Integer id );

    void getRepositoryConnection();
}
