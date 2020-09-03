/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.exception;


import com.demo.surveypictureservice.dto.ApiException;
import com.demo.surveypictureservice.utility.MyUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

/**
 *
 * @author Steven Raylianto K.
 */
public class CustomResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        HttpStatus status = clientHttpResponse.getStatusCode();
        return status.is4xxClientError() || status.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
                String httpBodyResponse = reader.lines().collect(Collectors.joining(""));
                System.out.println("Error -> " + httpBodyResponse);

                ObjectMapper objectMapper = MyUtil.getObjectMapper();
                ApiException apiException = objectMapper.readValue(httpBodyResponse, ApiException.class);
                throw new MyRestTemplateException(apiException.getTimestamp(), apiException.getStatus(), apiException.getMessage());
            }
        }
    }

}
