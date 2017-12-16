package com.esliceu.dwes.springMVC.controller;

import com.esliceu.dwes.springMVC.exception.DataAccessException;
import com.esliceu.dwes.springMVC.exception.DataIntegrityViolationException;
import com.esliceu.dwes.springMVC.exception.NotFoundException;
import com.esliceu.dwes.springMVC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by xavi on 1/12/17.
 */
@Controller
@RequestMapping("/hello")
@Scope("session")
public class HelloController {

    @Autowired
    private Student student;

    @ResponseStatus(value= HttpStatus.CONFLICT,
            reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(Exception ex) throws Exception {
        // Nothing to doResponseStatus
    }

    @ExceptionHandler({SQLException.class,DataAccessException.class})
    public String databaseError() {
        return "databaseError";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("student",student);
        if (true) throw new NotFoundException();
        return "pollo";
    }

    @RequestMapping(value = "/url", method = RequestMethod.GET)
    public String printHello(ModelMap model) throws Exception {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        if (true) throw new DataIntegrityViolationException();
        return "hello";
    }

    @RequestMapping("/sqlError")
    public void databaseException() throws SQLException {
        throw new SQLException();
    }

    @RequestMapping("/exError")
    public void exception() throws Exception {
        throw new Exception("pocoyo!");
    }


    @RequestMapping("/session")
    public String testMestod(HttpServletRequest request){
        HttpSession session = request.getSession();

        return "testJsp";
    }

}
