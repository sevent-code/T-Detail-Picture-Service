/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.dto;

/**
 *
 * @author Steven Raylianto K.
 */
public class RequestId {

    private Long id;

    public RequestId() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RequestDeleteSurveyor{" + "id=" + id + '}';
    }

}
