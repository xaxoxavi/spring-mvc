package com.esliceu.dwes.springMVC.interceptor;

import com.esliceu.dwes.springMVC.controller.HelloController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xavi on 13/12/17.
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {


    private final String TIME = "time";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        long now = System.currentTimeMillis();
        request.setAttribute(TIME, now);
        System.out.println("PRE-HANDLE " +  System.currentTimeMillis() + " ms");
        return true;

    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

        long now = System.currentTimeMillis();

        HelloController helloController = null;

        if (handler instanceof HandlerMethod){

            helloController = (HelloController)((HandlerMethod) handler).getBean();
        }



        Long time = (Long) request.getAttribute(TIME);

        long finalTime = (now - time);

        System.out.println("Ha tardat " + finalTime  + " ms.");

        modelAndView.addObject(TIME,finalTime );

        modelAndView.setViewName("pollo2");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }
}
