/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Steven Raylianto K.
 */
@Entity
@Table(name = "survey_picture")
public class SurveyPicture implements Serializable {

    private Long id;
    private String description;
    private String urlImage;
    private LocalDateTime createDateTime;
    private LocalDateTime modifyDateTime;
    private Survey survey;

    public SurveyPicture() {
    }

    public SurveyPicture(String description, String urlImage, Survey survey) {
        this.description = description;
        this.urlImage = urlImage;
        this.survey = survey;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "survey_picture_seq")
    @SequenceGenerator(name = "survey_picture_seq", sequenceName = "survey_picture_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "url_image")
    public String getUrlImage() {
        return urlImage;
    }

    @Column(name = "create_date_time", columnDefinition = "TIMESTAMP")
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @Column(name = "modify_date_time", columnDefinition = "TIMESTAMP")
    public LocalDateTime getModifyDateTime() {
        return modifyDateTime;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey", referencedColumnName = "id")
    public Survey getSurvey() {
        return survey;
    }

    @PrePersist
    public void onCreate() {
        this.createDateTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifyDateTime = LocalDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void setModifyDateTime(LocalDateTime modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    @Override
    public String toString() {
        return "SurveyPicture{" + "id=" + id + ", description=" + description + ", urlImage=" + urlImage + ", createDateTime=" + createDateTime + ", modifyDateTime=" + modifyDateTime + '}';
    }

}
