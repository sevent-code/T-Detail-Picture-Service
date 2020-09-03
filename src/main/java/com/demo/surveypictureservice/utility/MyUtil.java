/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.utility;


import com.demo.surveypictureservice.dto.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Steven Raylianto K.
 */
public class MyUtil {
    
    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

    public static ApiResponse buildResponseWrapper(String message, Object data) {
        return new ApiResponse(
                LocalDateTime.now(),
                HttpStatus.OK, 
                message, 
                data);
    }
}
