package com.esliceu.dwes.springMVC.controller;

import com.esliceu.dwes.springMVC.SpringContextHandler;
import com.esliceu.dwes.springMVC.model.ScopeTester;
import com.esliceu.dwes.springMVC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xavi on 1/12/17.
 */
@Controller
// @Scope("session")
public class StudentController {

    private Student student;


    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to Mallorca!");
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {

        return new ModelAndView("student", "student", student);
    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student,
                             ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());

        this.student.setName(student.getName());
        this.student.setAge(student.getAge());
        this.student.setId(student.getId());

        ScopeTester scopeTester = (ScopeTester) SpringContextHandler.context.getBean("scopeTester");
        scopeTester.setValue(student.getName());

        scopeTester = (ScopeTester) SpringContextHandler.context.getBean("scopeTester");

        return "result";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.HEAD)
    public String putStudent(@ModelAttribute("student") Student student,
                             ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge() * 2);
        model.addAttribute("id", student.getId());

        return "result";
    }
}
