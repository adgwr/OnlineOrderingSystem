package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    /**
     * 登录的具体控制
     *
     * @param request
     * @param response
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        RedirectAttributes redirectAttributes,
                        Model model) {

        AdminAccount adminAccount = adminService.login(username, password);
        Customer customer = customerService.login(username, password);
        //获取session
        HttpSession session = request.getSession();
        //管理员登录
        if (adminAccount != null) {
            session.setAttribute("adminAccount", adminAccount);
            model.addAttribute("message", "登录成功");
            index(model);
            return "admin/index";
        }

        //超级管理员登录
        if (adminAccount != null && adminAccount.getIssuper() == 1) {
            session.setAttribute("adminAccount", adminAccount);
            model.addAttribute("message", "登录成功");
            index(model);
            return "admin/index";
        }

        //用户登录
        if (customer != null) {
            model.addAttribute("customer", customer);
            try {
                session.setAttribute("customer", customer);
                //用model向页面传参
                model.addAttribute("message", "登录成功");
                //返回pcHomepage页面
                return "pcHomepage";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //登录失败
        else {
            //用RedirectAttributes对象重定向传参
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新输入");
            return "redirect:/pcHomepage";
        }
        return null;
    }

@RequestMapping(value = "index", method = RequestMethod.POST)
public String index(Model model){
        List<AdminAccount> adminAccountList = adminService.getAllAdmin();
        model.addAttribute("adminAccountList",adminAccountList);
        return "admin/adminMain";
}

    /**
     * s删除用户，并返回用户列表
     * @author: crj
     * @param id
     * @return
     * @date:2018年8月22日 上午9:27:49
     */
    @RequestMapping(value = "login/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id) {
        adminService.deleteAdmin(id);
        return "admin/adminMain";//重定向到list页面
    }
}
