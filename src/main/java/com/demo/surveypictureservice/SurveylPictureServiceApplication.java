package com.demo.surveypictureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SurveylPictureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveylPictureServiceApplication.class, args);
    }

}
