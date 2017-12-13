package com.esliceu.dwes.springMVC.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by xavi on 4/12/17.
 */
@Component
@Scope("session")
public class ScopeTester {

    private String value = "DEFAULT";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
