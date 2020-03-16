package com.qgerson.twitterservice.adapters;

import com.qgerson.twitterservice.ports.TwitterConnectionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class TwitterConnectionAdapter implements TwitterConnectionPort {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ConfigurationBuilder getInstance() {
        return new ConfigurationBuilder();
    }

    @Override
    public Collection<String> trendHashTag(Integer n) throws Exception {
        Twitter twitter = new TwitterFactory( getInstance().build() ).getInstance();
        Trends trends = twitter.getPlaceTrends( 1 );
        Collection<String> trending = new ArrayList<>();
        for (Trend trend: trends.getTrends()){
            if (trending.size() < (n < 10 ? 10: n) ){
                trending.add(trend.getName());
            }
        }
       return trending;
    }
}
