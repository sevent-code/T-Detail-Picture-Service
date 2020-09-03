/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.repository;

import com.demo.surveypictureservice.model.SurveyPicture;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steven Raylianto K.
 */
@Repository
public interface SurveyPictureRepository extends CrudRepository<SurveyPicture, Long> {

    List<SurveyPicture> findBySurvey(Long id);
}
