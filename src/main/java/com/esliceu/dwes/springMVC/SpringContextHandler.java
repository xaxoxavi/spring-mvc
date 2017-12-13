package com.esliceu.dwes.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by xavi on 4/12/17.
 */
@Component
public class SpringContextHandler {

    public static ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext appContext){
        context = appContext;
    }

}
