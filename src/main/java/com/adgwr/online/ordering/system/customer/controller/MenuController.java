package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.CustomerMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
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
public class MenuController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String menu(
            @RequestParam(value = "categorySelected", defaultValue = "-1") Integer categorySelected,
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model) {
        List<Category> categorys = customerService.getAllCategorys();
//        if(categorySelected == -1) {
//            categorySelected = categorys.get(0).getCategoryId();
//        }
        PageHelper.startPage(pn, 8);
        PageHelper.orderBy("food_id asc");
        List<Food> foods;
        if(categorySelected == -1) {
            foods = customerService.getAllFoods();
        }
        else {
            foods = customerService.getFoodsByCategoty(categorySelected);
        }
        PageInfo page = new PageInfo(foods, 5);
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

        model.addAttribute("foods", foods).addAttribute("pageInfo", page).
                addAttribute("categorys", categorys).addAttribute("categorySelected", categorySelected);
        return "menu";
    }

//    @RequestMapping(value = "foodDetail", method = RequestMethod.GET)
//    public String getFoodDetail(
//            @RequestParam(value = "foodId", defaultValue = "-1") Integer foodId,
//            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
//            Model model) {
//
//        return "foodDetail";
//    }
}
