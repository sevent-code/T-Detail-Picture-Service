/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.model;

import com.demo.surveypictureservice.enums.StatusSurveyor;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "surveyor")
public class Surveyor implements Serializable {

    private Long id;
    private String name;
    private String msisdn;
    private String password;
    private String address;
    private String email;
    private StatusSurveyor statusSurveyor;
    private LocalDateTime createDateTime;
    private LocalDateTime modifyDateTime;

    public Surveyor() {
    }

    public Surveyor(String name, String msisdn, String address, String email) {
        this.name = name;
        this.msisdn = msisdn;
        this.address = address;
        this.email = email;
    }
    
    public Surveyor(String name, String msisdn, String address, String email, StatusSurveyor statusSurveyor) {
        this.name = name;
        this.msisdn = msisdn;
        this.address = address;
        this.email = email;
        this.statusSurveyor = statusSurveyor;
    }

    public Surveyor(String name, String msisdn, String password, String address, String email, StatusSurveyor statusSurveyor) {
        this.name = name;
        this.msisdn = msisdn;
        this.password = password;
        this.address = address;
        this.email = email;
        this.statusSurveyor = statusSurveyor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "surveyor_seq")
    @SequenceGenerator(name = "surveyor_seq", sequenceName = "surveyor_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name", length = 100)
    public String getName() {
        return name;
    }

    @Column(name = "msisdn", unique = true, length = 20)
    public String getMsisdn() {
        return msisdn;
    }

    @Column(name = "password", length = 20)
    public String getPassword() {
        return password;
    }

    @Column(name = "address")
    @Type(type = "text")
    public String getAddress() {
        return address;
    }

    @Column(name = "email", unique = true, length = 100)
    public String getEmail() {
        return email;
    }

    @Column(name = "status_surveyor")
    @Enumerated(EnumType.ORDINAL)
    public StatusSurveyor getStatusSurveyor() {
        return statusSurveyor;
    }

    @Column(name = "create_date_time", columnDefinition = "TIMESTAMP")
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @Column(name = "modify_date_time", columnDefinition = "TIMESTAMP")
    public LocalDateTime getModifyDateTime() {
        return modifyDateTime;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatusSurveyor(StatusSurveyor statusSurveyor) {
        this.statusSurveyor = statusSurveyor;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public void setModifyDateTime(LocalDateTime modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    @Override
    public String toString() {
        return "Surveyor{" + "name=" + name + ", msisdn=" + msisdn + ", address=" + address + '}';
    }

}
