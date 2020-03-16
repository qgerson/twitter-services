package com.qgerson.twitterservice.ports;

import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Collection;

public interface TwitterConnectionPort {

    ConfigurationBuilder getInstance();

    Collection<String> trendHashTag( Integer n ) throws Exception;
}
