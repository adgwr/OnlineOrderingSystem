package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Administrator
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 注册功能
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }


    /**
     * 用户注册功能
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(
            String CustomerID,
            String email,
            String password,
            Model model,
            RedirectAttributes redirectAttributes) {
        boolean flag = customerService.register(CustomerID, email, password);
        if (flag) {
            redirectAttributes.addFlashAttribute("message", "注册成功");
            return "redirect:/register";
        } else {
            model.addAttribute("message", "用户名已存在");
            return "register";
        }
    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("customer");
        return "redirect:/pcHomepage";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "customer/index";
    }
}
