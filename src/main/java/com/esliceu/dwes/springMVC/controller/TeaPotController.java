package com.esliceu.dwes.springMVC.controller;

import com.esliceu.dwes.springMVC.exception.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xavi on 15/12/17.
 */
@Controller
public class TeaPotController {

    @RequestMapping("/teapot")
    public String teaPotError() throws DataIntegrityViolationException {
        if (true) throw new DataIntegrityViolationException();
        return "pollo";
    }
}
