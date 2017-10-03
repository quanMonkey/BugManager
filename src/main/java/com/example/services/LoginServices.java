package com.example.services;

import org.springframework.stereotype.Service;

/**
 * Created by liuquan on 2017/6/26.
 */
@Service
public interface LoginServices {
    public String validateUserLogin(String account,String pwd);
}
