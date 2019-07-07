package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Administrator
 */
@Controller
public class AdminDispatchController {

    /**
     * 主页跳转，当浏览器发送请求时，经过此方法跳转到“pcHomepage”页面
     *
     * @return
     */
    @RequestMapping(value = {"","pcHomepage"}, method = RequestMethod.GET)
    public String pcHomepage() {
        return "pcHomepage";
    }


}
