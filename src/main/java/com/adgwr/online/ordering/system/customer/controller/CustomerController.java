package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
            return "redirect:/pcHomepage";
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

    @RequestMapping(value = "customerIndex",method = RequestMethod.GET)
    public String customerIndex(){
        return "customer/index";
    }

    @RequestMapping(value = "customerLeft",method = RequestMethod.GET)
    public String customerLeft(){
        return "customer/left";
    }

    @RequestMapping(value = "customerMain",method = RequestMethod.GET)
    public String customerMain(){
        return "customer/customerMain";
    }

    @RequestMapping(value = "customerModifyPassword",method = RequestMethod.GET)
    public String modifyPassword(){
        return "customer/modifyPassword";
    }

    @RequestMapping(value = "customerEdit",method = RequestMethod.GET)
    public String editCustomer(){
        return "customer/editCustomer";
    }

    @RequestMapping(value = "modifyPwdCustomer",method = RequestMethod.POST)
    public String modifyPwdCustomer(
            HttpServletRequest request,
            HttpServletResponse response,
            String oldPswd,String newPswd,String confirmPswd,RedirectAttributes redirectAttributes){
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if(!customer.getcPassword().equals(DigestUtils.md5DigestAsHex(oldPswd.getBytes()))){
            redirectAttributes.addFlashAttribute("message","原密码错误，请重新输入");
            return "customer/modifyPassword";
        }

        if(!newPswd.equals(confirmPswd)){
            redirectAttributes.addFlashAttribute("message","两次输入密码不相同，请重新输入");
            return "customer/modifyPassword";
        }
        boolean flag = customerService.updatePassword(customer, newPswd);
        if(flag){
            redirectAttributes.addFlashAttribute("message","修改成功，即将跳转主页面");
            return "customer/customerMain";
        }
        return null;
    }

    @RequestMapping(value = "editCustomer",method = RequestMethod.POST)
    public String editCustomer(
            HttpServletRequest request,
            HttpServletResponse response,
            String newTel,String newEmail,
            RedirectAttributes redirectAttributes){
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        boolean flag = customerService.editCustomer(customer, newTel, newEmail);
        if(flag){
            redirectAttributes.addFlashAttribute("message","修改成功,即将跳转个人信息页");
            return "customer/customerMain";
        }

        else{
            redirectAttributes.addFlashAttribute("message","修改失败");
            return "customer/editCustomer";
        }
    }
}
