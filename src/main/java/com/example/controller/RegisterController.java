package com.example.controller;

import com.example.pojo.AccountInfo;
import com.example.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuquan on 2017/7/11.
 */
@Controller
@RequestMapping("/RegisterController")
public class RegisterController extends BaseController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/intoRegister")
    public String intoRegister(){
        return "/register";
    }


    @RequestMapping("/registerAccount")
    public ModelAndView registerAccount(AccountInfo accountInfo){
        registerService.createAccount(accountInfo);
        ModelAndView mdv = new ModelAndView();
        mdv.setViewName("/index.jsp");
        return mdv;
    }
}
