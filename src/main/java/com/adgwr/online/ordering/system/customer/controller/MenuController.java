package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.customer.service.MenuService;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Food;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询菜品
     *
     * @return
     */
    @RequestMapping(value = "getFoods", method = RequestMethod.POST)
    public String getFoods(String searchContent,Model model) {
        List<Food> foods = menuService.getFoods(searchContent);
        model.addAttribute("foods", foods).addAttribute("categorySelected", null);
        return "menu";
    }

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String menu(
            @RequestParam(value = "categorySelected", defaultValue = "all") String categorySelected,
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model) {

        List<Category> categorys = menuService.getAllCategorys();
        List<Integer> categoryIds = new ArrayList<>();
        //查询所有菜品
        if ("all".equals(categorySelected)) {
            for (Category category : categorys) {
                categoryIds.add(category.getCategoryId());
            }
        }
        //查询指定菜品
        else {
            for (Category category : categorys) {
                if (category.getCategoryName().equals(categorySelected)) {
                    categoryIds.add(category.getCategoryId());
                    break;
                }
            }
        }

        if (categoryIds != null) {
            if (categoryIds.size() == 1) {
                List<Integer> foodBelong = menuService.getFoodBelong(categoryIds.get(0));
                PageHelper.startPage(pn, 4);
                PageHelper.orderBy("food_id asc");
                List<Food> foods = menuService.getAllFoods(foodBelong);
                PageInfo page = new PageInfo(foods, 5);
                model.addAttribute("foods", foods).addAttribute("pageInfo", page).
                        addAttribute("categorys", categorys).addAttribute("categorySelected", categorySelected);
                return "menu";
            }
            //显示全部菜品
            else {
                PageHelper.startPage(pn, 4);
                PageHelper.orderBy("food_id asc");
                List<Food> foods = menuService.getAllFoods();
                PageInfo page = new PageInfo(foods, 5);
                model.addAttribute("foods", foods).addAttribute("pageInfo", page).
                        addAttribute("categorys", categorys).addAttribute("categorySelected", null);
                return "menu";
            }
        }
        return null;
    }

}
