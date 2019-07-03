package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.dto.BaseResult;
import com.adgwr.online.ordering.system.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 */
@Controller
public class DispatchController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = {"", "pcHomepage"})
    public String pcHomepage() {
        return "pcHomepage";
    }


    //    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Model model) {

        AdminAccount adminAccount = adminService.login(username, password);
        Customer customer = customerService.login(username, password);

        //管理员登录
        if (adminAccount != null) {

        }

        //用户登录
        if (customer != null) {
            BaseResult baseResult = BaseResult.ok();
            model.addAttribute("customer", customer);
            try {
                HttpSession session = request.getSession();
                session.setAttribute("customer",customer);
                return "pcHomepage";
//                return MapperUtils.obj2json(baseResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //登录失败
        else {
            model.addAttribute("message", "用户名或密码错误");
            return "pcHomepage";
        }
        return null;
    }
}
