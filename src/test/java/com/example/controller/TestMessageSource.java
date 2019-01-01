package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by liuquan on 2018/7/15.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@WebAppConfiguration
public class TestMessageSource {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void getMessage(){
//        Locale locale = new Locale("zh", "CN");
//        ResourceBundle rb = ResourceBundle.getBundle("i18n/msg",locale);
//        String msg = rb.getString("greeting.common");
        String msg = applicationContext.getMessage("greeting.common", null, Locale.CHINA);
        System.out.println(msg);
    }

}
