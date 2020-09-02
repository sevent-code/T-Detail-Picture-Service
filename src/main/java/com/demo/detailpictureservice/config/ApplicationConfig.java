/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.detailpictureservice.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Steven Raylianto K.
 */

@Configuration
@EnableSwagger2
public class ApplicationConfig {
    
    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo"))
                .build()
                .apiInfo(apiDetails());
    }
    
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Detail Picture API",
                "API Detail Picture for T application",
                "1.0",
                "Use it wisely",
                new springfox.documentation.service.Contact("Steven Raylianto", "https://www.linkedin.com/in/steven-raylianto-752951116/", "StevenRaylianto.Kertajadi@mitrais.com"),
                "API License",
                "https://www.linkedin.com/in/steven-raylianto-752951116/",
                Collections.emptyList());
    }
}
