package com.esliceu.dwes.springMVC.controller;

import com.esliceu.dwes.springMVC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xavi on 1/12/17.
 */
@Controller
@RequestMapping("/hello")
@Scope("session")
public class HelloController {

    @Autowired
    private Student student;

    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("student",student);
        return "pollo";
    }

    @RequestMapping(value = "/url", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }


    @RequestMapping("/session")
    public String testMestod(HttpServletRequest request){
        HttpSession session = request.getSession();

        return "testJsp";
    }

}
