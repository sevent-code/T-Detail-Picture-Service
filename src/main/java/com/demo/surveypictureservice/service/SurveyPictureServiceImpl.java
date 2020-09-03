package com.demo.surveypictureservice.service;

import com.demo.surveypictureservice.dto.ReqestCreateSurveyPicture;
import com.demo.surveypictureservice.exception.MyResourceException;
import com.demo.surveypictureservice.model.Survey;
import com.demo.surveypictureservice.model.SurveyPicture;
import com.demo.surveypictureservice.repository.SurveyPictureRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Steven Raylianto K.
 */

@Service
public class SurveyPictureServiceImpl implements SurveyPictureService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SurveyPictureRepository surveyPictureRepository;

    @Override
    public SurveyPicture createSurveyPicture(ReqestCreateSurveyPicture requestCreateSurveyPicture) {
        Survey survey = restTemplate.getForObject("http://survey-service/survey/find-survey-by-surveyor-id?value=" + requestCreateSurveyPicture.getSurveyId(), Survey.class);
        SurveyPicture surveyPicture = new SurveyPicture(requestCreateSurveyPicture.getDescription(), requestCreateSurveyPicture.getUrlImage(), survey);
        return surveyPictureRepository.save(surveyPicture);
    }

    @Override
    public void deleteSurveyPicture(Long id) {
        Optional<SurveyPicture> optSurveyPicture = surveyPictureRepository.findById(id);
        SurveyPicture surveyPicture = optSurveyPicture.get();
        surveyPictureRepository.delete(surveyPicture);
    }

    @Override
    public List<SurveyPicture> findSurveysBySurveyId(Long surveyId) {
         return surveyPictureRepository.findBySurvey(surveyId);
    }

    @Override
    public SurveyPicture updateSurveyPicture(Long id, SurveyPicture requestSurveyPicture) {
        return surveyPictureRepository.findById(id).map(surveyPicture -> {
            surveyPicture.setDescription(requestSurveyPicture.getDescription());
            surveyPicture.setUrlImage(requestSurveyPicture.getUrlImage());
            return surveyPictureRepository.save(surveyPicture);
        }).orElseThrow(() -> new MyResourceException("Error when update survey with id " + id));
    }
    
}
