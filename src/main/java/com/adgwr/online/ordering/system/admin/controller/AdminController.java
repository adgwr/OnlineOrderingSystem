package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
        if (adminAccount != null && adminAccount.getIssuper() == 0) {
            session.setAttribute("adminAccount", adminAccount);
            //model.addAttribute("message", "登录成功");
            index(1,model);
            return "admin/index";
        }

        //超级管理员登录
        if (adminAccount != null && adminAccount.getIssuper() == 1) {
            session.setAttribute("adminAccount", adminAccount);
           // model.addAttribute("message", "登录成功");
            index(1,model);
            return "admin/index1";
        }

        //用户登录
        if (customer != null) {
            model.addAttribute("customer", customer);
            try {
                session.setAttribute("customer", customer);
                //用model向页面传参
               // model.addAttribute("message", "登录成功");
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

    @RequestMapping(value = "admin/logout",method = RequestMethod.GET)
    public String adminLogout(HttpSession session) {
        session.removeAttribute("adminAccount");
        return "redirect:/pcHomepage";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Integer pn,Model model){
        Byte b = 0;
        PageHelper.startPage(pn, 4);
        List<AdminAccount> adminAccountList = adminService.getAdminByIsSuper(b);
        PageInfo page = new PageInfo(adminAccountList, 5);
        model.addAttribute("adminAccountList",adminAccountList).addAttribute("pageInfo",page);
        return "admin/adminMain";
    }

    @RequestMapping(value = "index11", method = RequestMethod.GET)
    public String index11(Model model){
        Byte b = 0;
        List<AdminAccount> adminAccountList = adminService.getAdminByIsSuper(b);
        model.addAttribute("adminAccountList",adminAccountList);
        return "admin/index1";
    }
    /**
     * 删除用户，并返回用户列表
     * @author: crj
     * @param id
     * @return
     */
    @RequestMapping(value = "delete{id}", method = RequestMethod.GET)
    public String deleteAdmin(@PathVariable("id") String id, Model model,
                              RedirectAttributes redirectAttributes) {
        adminService.deleteAdmin(id);
        model.addAttribute("message","删除成功！");
        index(1,model);
        return "admin/adminMain";
    }


    /**
     * 编辑管理员账户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") String id, Model model){
        model.addAttribute("adminAccount",adminService.getAdminById(id));
        model.addAttribute("title","修改账户");
        model.addAttribute("adminId",id);
        return "admin/editAdmin";
    }

    @RequestMapping(value = "editAdmin", method = RequestMethod.POST)
    public String edit(String adminId,
                       @RequestParam(value = "pwd") String pwd,
                       @RequestParam(value = "tel") String tel,
                       Model model){
        adminService.editAdminAccount(adminId,pwd,tel);
        model.addAttribute("message","修改成功！");
        index(1,model);
        return "admin/adminMain";
    }

    /**
     * 取消编辑，返回主页面
     * @param model
     * @return
     */
    @RequestMapping(value = "return", method = RequestMethod.GET)
    public String returnMain(Model model){
        index(1,model);
        return "admin/adminMain";
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
            model.addAttribute("message","注册成功!");
            index(1,model);
            return "admin/adminMain";//返回到索引页面
        }else{
            model.addAttribute("message", "用户名已存在，请重新输入");
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

    @RequestMapping(value = "modifyPassword1", method = RequestMethod.GET)
    public String modifyPassword1(HttpSession session, Model model) {
        modifyPassword(session, model);
        return "admin/modifyPassword1";
    }

    /**
     * 修改管理员密码
     * @param adminId
     * @param oldPswd
     * @param newPswd
     * @param model
     * @return
     */
    @RequestMapping(value = "ModifyPwdAdmin1", method = RequestMethod.POST)
    public String modifyPswdAdmin1(@RequestParam(value = "adminId") String adminId, String oldPswd, String newPswd, Model model) {
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
                index(1,model);
                return "admin/adminMain";
            }else
                model.addAttribute("error", "密码错误");
        }else
            model.addAttribute("error", "登录已失效,请重新登录");
        return "admin/modifyPassword";
    }

    /**
     * 修改管理员密码
     * @param adminId
     * @param oldPswd
     * @param newPswd
     * @param model
     * @return
     */
    @RequestMapping(value = "ModifyPwdAdmin", method = RequestMethod.POST)
    public String modifyPswdAdmin(@RequestParam(value = "adminId") String adminId, String oldPswd, String newPswd, Model model) {
        modifyPswdAdmin1(adminId, oldPswd, newPswd, model);
        if(modifyPswdAdmin1(adminId, oldPswd, newPswd, model).equals("admin/index1"))
            return "admin/index";
        else
            return "admin/modifyPassword";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(String searchKey, Model model,@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        if (searchKey == "") {
            AdminAccount searchAdmin = new AdminAccount();
            model.addAttribute("searchAdmin", searchAdmin);
            return "adminarchResult";
        }
        PageHelper.startPage(pn, 5);
        List<AdminAccount> searchAdmins = adminService.getAdminByName(searchKey);
        PageInfo page = new PageInfo(searchAdmins, 3);
        if(page.getPages() == 0) {
            model.addAttribute("hasFood", false);
        }
        else {
            model.addAttribute("hasFood", true);
            model.addAttribute("currentPage",page.getPageNum());
            int start = (pn-1)/5*5+1;
            int end = Math.min(start+4,page.getPages());
            model.addAttribute("hasStart",start != 1);
            model.addAttribute("hasEnd",end != page.getPages());
            model.addAttribute("startPage", start);
            model.addAttribute("endPage", end);
        }

        model.addAttribute("searchAdmins",searchAdmins);
        model.addAttribute("searchKey", searchKey);
        return "admin/searchResult";
    }

    @RequestMapping(value = "left1", method = RequestMethod.GET)
    public String pages1(Model model){
        index(1,model);
        return "admin/left1";
    }

    @RequestMapping(value = "adminMain", method = RequestMethod.GET)
    public String pages2(@RequestParam(value = "pn", defaultValue = "1") Integer pn,Model model){
        index(pn,model);
        return "admin/adminMain";
    }

    @RequestMapping(value = "left", method = RequestMethod.GET)
    public String pages3(Model model){
        index(1,model);
        return "admin/left";
    }

    /**
     * 普通管理员回到个人界面
     * @return
     */
    @GetMapping(value = "adminIndex0")
    public String adminIndex0() {
        return "admin/index";
    }

}
