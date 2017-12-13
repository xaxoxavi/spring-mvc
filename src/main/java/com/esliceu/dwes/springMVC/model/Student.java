package com.esliceu.dwes.springMVC.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by xavi on 1/12/17.
 */
@Component
@Scope("session")
public class Student {
    private Integer age;
    private String name;
    private Integer id;

    public Student(){}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
}
