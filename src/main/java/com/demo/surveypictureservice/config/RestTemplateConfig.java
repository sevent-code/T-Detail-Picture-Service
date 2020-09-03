/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.config;


import com.demo.surveypictureservice.exception.CustomResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author Steven Raylianto K.
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    RestTemplate restTemplateWithErrorHandler() {
        return new RestTemplateBuilder()
                .errorHandler(new CustomResponseErrorHandler())
                .build();
    }
}
