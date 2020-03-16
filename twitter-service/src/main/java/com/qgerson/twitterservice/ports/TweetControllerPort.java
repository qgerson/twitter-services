package com.qgerson.twitterservice.ports;

import com.qgerson.twitterservice.domain.Tweet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

public interface TweetControllerPort {
    @GetMapping(value = "set-valid/{id}")
    void setIsValid(@PathVariable("id") Integer id) throws Exception;

    @GetMapping(value = "find-by-id/{id}")
    Tweet findById(@PathVariable("id") Integer id);

    @GetMapping(value = "find-by-user/{user}")
    Collection<Tweet> findByUser(@PathVariable("user") String user);

    @GetMapping(value = "find-by-location/{location}")
    Collection<Tweet> findByLocation(@PathVariable("location") String location);

    @GetMapping(value = "find-by-language/{languageId}")
    Collection<Tweet> findByLanguage(@PathVariable("languageId") String languageId);

    @GetMapping(value = "find-valid")
    Collection<Tweet> findValid();

    @GetMapping(value = "find-all")
    Collection<Tweet> findAll();

    @GetMapping(value = "remove/{id}")
    void remove(@PathVariable("id") Integer id);

    @GetMapping(value= "trends/{n}")
    Collection<String> findTrends(@PathVariable("n") Integer n) throws Exception;
}
