/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.service;

import com.demo.surveypictureservice.dto.ReqestCreateSurveyPicture;
import com.demo.surveypictureservice.model.SurveyPicture;
import java.util.List;

/**
 *
 * @author Steven Raylianto K.
 */

public interface SurveyPictureService {
    SurveyPicture createSurveyPicture(ReqestCreateSurveyPicture requestCreateSurveyPicture);
    void deleteSurveyPicture(Long id);
    List<SurveyPicture> findSurveysBySurveyId(Long surveyId);
    SurveyPicture updateSurveyPicture(Long id, SurveyPicture requestSurveyPicture);
    
    
}
