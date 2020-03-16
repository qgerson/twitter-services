package com.qgerson.twitterservice.adapters;

import com.qgerson.twitterservice.domain.Tweet;
import com.qgerson.twitterservice.ports.TweetControllerPort;
import com.qgerson.twitterservice.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/v1/tweets/")
public class TweetControllerAdapter implements TweetControllerPort {

    @Autowired
    private TweetService  tweetService;

    @Autowired
    private TwitterConnectionAdapter adapter;

    @Override
    public void setIsValid(@PathVariable Integer id) throws Exception {
        tweetService.setIsValid( id );
    }

    @Override
    public Tweet findById(@PathVariable Integer id) {
        return  tweetService.findById( id );
    }

    @Override
    public Collection<Tweet> findByUser(@PathVariable String user) {
        return tweetService.findByUser( user );
    }

    @Override
    public Collection<Tweet> findByLocation( @PathVariable String location) {
        return tweetService.findByLocation( location );
    }

    @Override
    public Collection<Tweet> findByLanguage(@PathVariable String languageId) {
        return tweetService.findByLanguage( languageId );
    }

    @Override
    public Collection<Tweet> findValid() {
        return tweetService.findValid();
    }

    @Override
    public Collection<Tweet> findAll() {
        return tweetService.findAll();
    }

    @Override
    public void remove(@PathVariable Integer id) {
        tweetService.remove( id );
    }

    @Override
    public Collection<String> findTrends(@PathVariable Integer n) throws Exception {
        return  adapter.trendHashTag( n );
    }
}
