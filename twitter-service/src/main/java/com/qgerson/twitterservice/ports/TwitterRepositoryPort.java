package com.qgerson.twitterservice.ports;

import com.qgerson.twitterservice.domain.Tweet;
import org.springframework.data.repository.CrudRepository;

public interface TwitterRepositoryPort extends CrudRepository<Tweet, Integer> {

}
