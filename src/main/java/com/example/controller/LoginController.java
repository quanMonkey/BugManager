package com.example.controller;

import com.example.pojo.Employee;
import com.example.services.LoginServices;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuquan on 2017/6/25.
 */
@Controller
@RequestMapping("/LoginController")
public class LoginController extends BaseController{


    @Autowired
    private LoginServices loginServicesImpl;

    @ResponseBody
    @RequestMapping("/intoLogin")
    public Map<String, Object> intoLogin(){
        log.info("-------LoginController--------");
        Map<String,Object> userInfo = new HashMap<String,Object>();
        userInfo.put("name","liuquan");
        userInfo.put("age",10);
        return userInfo;
    }
}
