package com.qgerson.twitterservice.adapters;

import com.qgerson.twitterservice.domain.Tweet;
import com.qgerson.twitterservice.ports.TwitterConnectionPort;
import com.qgerson.twitterservice.ports.TwitterRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Collection;

@Service
public class TwitterListenerAdapter {

    @Autowired
    private TwitterConnectionPort twitterConnectionPort;

    public Collection<String> trendHashTag(Integer woeid) throws Exception{
        return  twitterConnectionPort.trendHashTag(woeid);
    }

    public ConfigurationBuilder getInstance(){
        return twitterConnectionPort.getInstance();
    }

}
