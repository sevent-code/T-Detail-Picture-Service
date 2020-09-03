/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.model;


import com.demo.surveypictureservice.enums.StatusSurvey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.hibernate.annotations.Type;

/**
 *
 * @author Steven Raylianto K.
 */
@Entity
@Table(name = "survey")
public class Survey implements Serializable {

    private Long id;
    private String description;
    private String profileAddress;
    private StatusSurvey statusLoan;
    private LocalDateTime createDateTime;
    private LocalDateTime modifyDateTime;
    private Surveyor surveyor;

    public Survey() {
    }

    public Survey(String description, String profileAddress, StatusSurvey statusLoan, Surveyor surveyor) {
        this.description = description;
        this.profileAddress = profileAddress;
        this.statusLoan = statusLoan;
        this.surveyor = surveyor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "survey_seq")
    @SequenceGenerator(name = "survey_seq", sequenceName = "survey_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    @Type(type = "text")
    public String getDescription() {
        return description;
    }

    @Column(name = "profile_address")
    public String getProfileAddress() {
        return profileAddress;
    }

    @Column(name = "status_loan")
    @Enumerated(EnumType.ORDINAL)
    public StatusSurvey getStatusLoan() {
        return statusLoan;
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
    @JoinColumn(name = "surveyor", referencedColumnName = "id")
    public Surveyor getSurveyor() {
        return surveyor;
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

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public void setSurveyor(Surveyor surveyor) {
        this.surveyor = surveyor;
    }

    public void setStatusLoan(StatusSurvey statusLoan) {
        this.statusLoan = statusLoan;
    }

    public void setModifyDateTime(LocalDateTime modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    @Override
    public String toString() {
        return "Survey{" + "id=" + id + ", description=" + description + ", profileAddress=" + profileAddress + ", statusLoan=" + statusLoan + ", createDateTime=" + createDateTime + ", modifyDateTime=" + modifyDateTime + ", surveyor=" + surveyor + '}';
    }

}
