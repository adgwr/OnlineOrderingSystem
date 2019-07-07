package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
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
     */
    @RequestMapping(value = "admin/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id, Model model) {
        adminService.deleteAdmin(id);
        index(model);
        return "redirect:/admin/index";//重定向到list页面
    }

    /**
     * 编辑管理员账户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "admin/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") String id, Model model){
        model.addAttribute("adminAccount",adminService.getAdminById(id));
        model.addAttribute("title","修改账户");
        model.addAttribute("adminId",id);
        return "admin/editAdmin";
    }

    @RequestMapping(value = "admin/editAdmin", method = RequestMethod.POST)
    public String edit(String adminId,
                       @RequestParam(value = "pwd") String pwd,
                       @RequestParam(value = "tel") String tel,
                       Model model){
        adminService.editAdminAccount(adminId,pwd,tel);
        List<AdminAccount> adminAccountList = adminService.getAllAdmin();
        model.addAttribute("adminAccountList",adminAccountList);
        return "admin/index";
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @RequestMapping(value = "createForm" , method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("admin",new AdminAccount());
        model.addAttribute("title", "注册新管理员");
        return "admin/registerAdmin";
    }

    /**
     * 注册新的管理员，并返回管理员列表
     * @param adminId
     * @param tel
     * @param password
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "registerAdmin", method = RequestMethod.POST)
    public String register(@RequestParam(value = "adminId")String adminId,
                           @RequestParam(value = "tel")String tel,
                           @RequestParam(value = "password")String password,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        boolean flag = adminService.register(adminId, tel, password);
        if (flag) {
//            redirectAttributes.addFlashAttribute("message","注册成功");
            //用model向页面传参
            model.addAttribute("message","注册成功");
            index(model);
            return "admin/index";//返回到索引页面
        }else{
            redirectAttributes.addFlashAttribute("message", "用户名已存在，请重新输入");
            return "admin/registerAdmin";//返回到注册页面
        }
    }

    @RequestMapping(value = "admin/modifyPassword", method = RequestMethod.GET)
    public String modifyPassword(HttpSession session, Model model) {
        Object obj = session.getAttribute("adminAccount");
        if(obj instanceof  AdminAccount) {
            AdminAccount adminAccount = (AdminAccount)obj;
            String id1 = adminAccount.getAdminId();
            model.addAttribute("adminAccount1", adminAccount);
        }
        return "admin/modifyPassword";
    }

    @RequestMapping(value = "ModifyPwdAdmin", method = RequestMethod.POST)
    public String modifyPswdAdmin(@RequestParam(value = "adminId") String adminId, String oldPswd, String newPswd, Model model) {
        AdminAccount adminAccount = adminService.getAdminById(adminId);
        if(adminAccount!=null){
            //MD5加密
            String oldpassword= DigestUtils.md5DigestAsHex(oldPswd.getBytes());
            //输入密码正确
            if(oldpassword.equals(adminAccount.getPassword())){
                String newpassword = DigestUtils.md5DigestAsHex(newPswd.getBytes());
                adminAccount.setPassword(newpassword);
                adminService.updateAdmin(adminAccount);
                model.addAttribute("error", "修改成功");
                index(model);
                return "admin/index";
            }else
                model.addAttribute("error", "密码错误");
        }else
            model.addAttribute("error", "登录已失效,请重新登录");
        return "redirect:/admin/modifyPassword";
    }

}
