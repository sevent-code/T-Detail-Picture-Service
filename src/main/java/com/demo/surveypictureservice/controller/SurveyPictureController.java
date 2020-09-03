/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.controller;


import com.demo.surveypictureservice.dto.ApiResponse;
import com.demo.surveypictureservice.dto.ReqestCreateSurveyPicture;
import com.demo.surveypictureservice.dto.RequestId;
import com.demo.surveypictureservice.dto.ResponseListSurveyPicture;
import com.demo.surveypictureservice.model.SurveyPicture;
import com.demo.surveypictureservice.service.SurveyPictureServiceImpl;
import com.demo.surveypictureservice.utility.MyUtil;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Steven Raylianto K.
 */
@RestController
@RequestMapping("/survey-picture")
public class SurveyPictureController {

    @Autowired
    private SurveyPictureServiceImpl surveyPictureServiceImpl;

    @GetMapping("/find-pictures-by-surveyor-id")
    @ApiOperation(value = "Find list survey pictures by surveyor id", response = ApiResponse.class)
    public ApiResponse findSurveyPicturesBySurveyorId(@RequestParam("value") Long value, HttpServletRequest http) throws Exception {
        System.out.println("Request From " + http.getRemoteAddr() + " on " + http.getServletPath());
        
        List<SurveyPicture> surveyPictures = surveyPictureServiceImpl.findSurveysBySurveyId(value);
        ResponseListSurveyPicture wrapperSurveyPictures = new ResponseListSurveyPicture(surveyPictures);
        return MyUtil.buildResponseWrapper("Fetch successfull", wrapperSurveyPictures);

    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new survey picture", response = ApiResponse.class)
    public ApiResponse createSurveyor(@RequestBody ReqestCreateSurveyPicture requestData, HttpServletRequest http) throws Exception {
        System.out.println("Request From " + http.getRemoteAddr() + " on " + http.getServletPath());
        System.out.println("Data -> " + requestData.toString());

        SurveyPicture suveryPicture = surveyPictureServiceImpl.createSurveyPicture(requestData);
        return MyUtil.buildResponseWrapper("Surveyor created successfull", suveryPicture);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete survey picture data", response = ApiResponse.class)
    public ApiResponse deleteSurveyor(@RequestBody RequestId data, HttpServletRequest http) throws Exception {
        System.out.println("Request From " + http.getRemoteAddr() + " on " + http.getServletPath());
        surveyPictureServiceImpl.deleteSurveyPicture(data.getId());
        return MyUtil.buildResponseWrapper("Success", null);
    }
}
