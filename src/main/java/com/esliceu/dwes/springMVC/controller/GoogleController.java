package com.esliceu.dwes.springMVC.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by xavi on 20/12/17.
 */
@Controller
public class GoogleController {

    @RequestMapping(value = "/google/image",method = RequestMethod.GET)
    public ModelAndView getImage() throws IOException {

        ModelAndView modelAndView = new ModelAndView();

        HttpClient httpClient = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet("https://www.google.es");

        HttpResponse response = null;

        try {
            response = httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        httpClient.getConnectionManager().shutdown();

        return modelAndView;
    }
}
