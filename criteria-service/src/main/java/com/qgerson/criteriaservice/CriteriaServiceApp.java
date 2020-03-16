package com.qgerson.criteriaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CriteriaServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CriteriaServiceApp.class, args);
    }

}
