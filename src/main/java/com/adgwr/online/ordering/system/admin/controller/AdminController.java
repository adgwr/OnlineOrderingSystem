package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 跳转登录页
     * @return
     */

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登录业务实现
     * @param adTel
     * @param plantPassword
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.POST)
    public String login(String adTel, String plantPassword, Model model) {
        AdminAccount adminAccount = adminService.login(adTel, plantPassword);
        if(adminAccount!=null){
            if(model!=null){
                return "index";
            }
        }
        return null;
    }
}
