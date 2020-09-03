/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.surveypictureservice.exception;

/**
 *
 * @author Steven Raylianto K.
 */
public class MyResourceException extends RuntimeException {

    public MyResourceException(String error) {
        super(error);
    }
}
