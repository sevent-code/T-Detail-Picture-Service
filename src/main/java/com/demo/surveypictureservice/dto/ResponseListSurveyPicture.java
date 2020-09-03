/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.dto;

import com.demo.surveypictureservice.model.SurveyPicture;
import java.util.List;

/**
 *
 * @author Steven Raylianto K.
 */
public class ResponseListSurveyPicture {

    private List<SurveyPicture> surveys;

    public ResponseListSurveyPicture() {
    }

    public ResponseListSurveyPicture(List<SurveyPicture> surveys) {
        this.surveys = surveys;
    }

    public List<SurveyPicture> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<SurveyPicture> surveys) {
        this.surveys = surveys;
    }

    @Override
    public String toString() {
        return "ResponseListSurveyPicture{" + "surveys=" + surveys + '}';
    }

}
