package com.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by liuquan on 2017/6/26.
 */
public class BaseController {
    //后续可以尝试使用AOP 增强来添加日志信息
    Log log = LogFactory.getLog(this.getClass());
}
