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
public enum StatusSurveyor {
    ACTIVE(0), DELETED(1), INACTIVE(2), OTP_VERIFICATION(3);

    private int status;

    private StatusSurveyor(int status) {
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
