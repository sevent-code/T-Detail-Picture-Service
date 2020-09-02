package com.demo.detailpictureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DetailPictureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetailPictureServiceApplication.class, args);
	}

}
