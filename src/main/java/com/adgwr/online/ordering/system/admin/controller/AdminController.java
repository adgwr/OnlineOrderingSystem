package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * 主页跳转，当浏览器发送请求时，经过此方法跳转到“pcHomepage”页面
     *
     * @return
     */
    @RequestMapping(value = {"", "pcHomepage"}, method = RequestMethod.GET)
    public String pcHomepage() {
        return "pcHomepage";
    }

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
//            model.addAttribute("message", "登录成功");
            return "pcHomepage";
        }

        //用户登录
        if (customer != null) {
            model.addAttribute("customer", customer);
            try {
                session.setAttribute("customer", customer);
//                redirectAttributes.addFlashAttribute("message", "登录成功");
                //返回pcHomepage页面
                return "redirect:/pcHomepage";
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
}
