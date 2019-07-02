package com.onlineorderingsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * @author LiYuHan
 * @title ControllerTest
 * @description
 * @date 1/7/2019 下午3:59
 */

@Controller
public class ControllerTest {

    private String hello = "Hello Jsp";

    // value 多可访问个值
    @RequestMapping(value = {"/", "/index"})
    public String index(Map<String, Object> model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp
        model.put("time", new Date());
        model.put("message", this.hello);
        return "index";
    }
}
