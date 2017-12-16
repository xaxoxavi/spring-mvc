package com.esliceu.dwes.springMVC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by xavi on 15/12/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No hi és!")
public class NotFoundException extends RuntimeException{

}
