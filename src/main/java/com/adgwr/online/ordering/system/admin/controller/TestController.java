package com.adgwr.online.ordering.system.admin.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 测试jsp的类
 * 已被废弃
 * @author Administrator
 */
@Deprecated
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
