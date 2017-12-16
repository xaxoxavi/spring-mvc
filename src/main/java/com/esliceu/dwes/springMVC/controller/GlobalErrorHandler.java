package com.esliceu.dwes.springMVC.controller;

import com.esliceu.dwes.springMVC.exception.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by xavi on 15/12/17.
 */
@ControllerAdvice
public class GlobalErrorHandler {

    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "because Oscar told me!")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void teaPotHandler(){

    }

}
