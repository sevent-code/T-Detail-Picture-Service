/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.enums;

/**
 *
 * @author Steven Raylianto K.
 */
public enum StatusSurvey {
    APPROVED(0), NEED_SURVEY(1), ON_PROGRESS(2);

    private int status;

    private StatusSurvey(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToString() {
        return name();
    }
}
