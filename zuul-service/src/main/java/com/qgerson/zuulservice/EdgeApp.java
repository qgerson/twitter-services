package com.qgerson.zuulservice;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class EdgeApp {
    public static void main(String[] args) {
        SpringApplication.run(EdgeApp.class, args);
    }
}
