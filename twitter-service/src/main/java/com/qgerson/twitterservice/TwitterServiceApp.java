package com.qgerson.twitterservice;

import com.qgerson.twitterservice.adapters.TwitterConnectionAdapter;
import com.qgerson.twitterservice.domain.Criteria;
import com.qgerson.twitterservice.domain.Tweet;
import com.qgerson.twitterservice.ports.TwitterRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import twitter4j.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
public class TwitterServiceApp implements CommandLineRunner {
    private Logger logger = Logger.getLogger(TwitterServiceApp.class);

    @Autowired
    private TwitterRepositoryPort port;


    Collection<Criteria> criterion;

    public static void main(String[] args) {
        SpringApplication.run( TwitterServiceApp.class, args);
    }

    private Collection<String> listLanguage = new ArrayList<>();
    private Long followers;

    private Boolean isValidLanguage( String language ) {
        return  listLanguage.contains( language );
    }


   @FeignClient("criteria-service")
    public interface CriteriaService {
        @GetMapping(value = "/v1/criterion/list")
        Collection<Criteria>getAllCriterion();
    }
    @Component
    class FeignCriterion implements CommandLineRunner {

        @Autowired
        private  CriteriaService criteriaService;

        @Override
        public void run(String... strings) throws Exception {
            criterion = criteriaService.getAllCriterion();
            if( criterion.size() > 0 ) {
                criterion.forEach((k) ->{
                    if( k.getId().equalsIgnoreCase("followers") )  followers = Long.parseLong( k.getCriteria().toString() );
                    if( k.getId().equalsIgnoreCase("languages")) {
                        String[] list = k.getCriteria().toString().replaceAll("[\\[\\]]","").stripTrailing().split(",");
                        for (String s : list) listLanguage.add(s.strip());
                    }
                });
            } else {
                throw new Exception("NO entity Allowed!");
            }
        }
    }


    @Override
    public void run(String... args) throws Exception {
        TwitterStream twitterStream = new TwitterStreamFactory( new TwitterConnectionAdapter().getInstance().build() ).getInstance().addListener(new StatusListener() {
            @Override
            public void onStatus(Status status) {
                String location = null;
                if( status.getUser().getFollowersCount() >= followers &&  isValidLanguage( status.getLang() ) ){
                    if( status.getGeoLocation() != null) {
                        location = status.getGeoLocation().getLatitude() + "," + status.getGeoLocation().getLongitude();
                    }
                    logger.info(String.format("language->%s", status.getLang() ) );
                    logger.info(String.format("user->%s", status.getUser().getScreenName() ) );
                    logger.info(String.format("location->%s", location ) );
                    logger.info(String.format("Followers->%s", status.getUser().getFollowersCount() ) );
                    logger.info(String.format("Tweet->%s \n\n", status.getText() ) );
                    Tweet tweet  = new Tweet(
                            status.getUser().getScreenName(),
                            status.getText(),
                            location,
                            status.getLang(),
                            false
                    );
                    port.save( tweet );
                }
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int i) {

            }

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }

            @Override
            public void onException(Exception e) {

            }
        }).sample();

    }

}
