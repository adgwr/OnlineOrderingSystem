package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.Food;
import com.github.pagehelper.PageHelper;
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
public class ShowCartController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "showCart",method = RequestMethod.GET)
    public String showCart(){
        return "showCart";
    }

    @RequestMapping(value = "GetFoods", method = RequestMethod.POST)
    public String getFoods(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            String searchContent,
            Model model) {
        PageHelper.startPage(pn, 8);
        PageHelper.orderBy("emp_id asc");
        List<Food> foods = customerService.getFoods(searchContent);
        model.addAttribute("foods", foods);
        return "menu";
    }
}
