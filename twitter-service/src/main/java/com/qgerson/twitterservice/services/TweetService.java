package com.qgerson.twitterservice.services;

import com.qgerson.twitterservice.domain.Tweet;
import com.qgerson.twitterservice.ports.TweetRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TweetService {

    @Autowired
    private TweetRepositoryPort tweetRepositoryPort;

    public void setIsValid(Integer id) throws Exception{
       tweetRepositoryPort.setIsValid( id );
    }

    public Tweet findById( Integer id) {
        return tweetRepositoryPort.findById( id );
    }

    public Collection<Tweet> findByUser(String user ) {
        return tweetRepositoryPort.findByUser( user );
    }

    public Collection<Tweet> findByLocation( String location ){
        return tweetRepositoryPort.findByLocation( location );
    }

    public Collection<Tweet> findByLanguage( String languageId ){
        return tweetRepositoryPort.findByLanguage( languageId );
    }

    public Collection<Tweet> findValid(){
        return  tweetRepositoryPort.findValid();
    }

    public Collection<Tweet> findAll(){
        return  tweetRepositoryPort.findAll();
    }

    public void remove( Integer id ) {
        tweetRepositoryPort.remove( id );
    }

}
