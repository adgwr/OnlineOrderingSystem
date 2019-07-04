package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class CustomerDispatchController {

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

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String menu(
            @RequestParam(value = "categorySelected", defaultValue = "主菜") String categorySelected,
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model) {

        List<Category> categorys = customerService.getAllCategorys();
        categorySelected = categorys.get(0).getCategoryName();
        PageHelper.startPage(pn, 8);
        PageHelper.orderBy("food_id asc");
        List<Food> foods = customerService.getAllFoods();
        PageInfo page = new PageInfo(foods, 5);
        model.addAttribute("foods", foods).addAttribute("pageInfo", page).
                addAttribute("categorys", categorys).addAttribute("categorySelected", categorySelected);
        return "menu";
    }

    @RequestMapping(value = "showCart",method = RequestMethod.GET)
    public String showCart(){
        return "showCart";
    }
}