package com.adgwr.online.ordering.system.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

    @RequestMapping(value = "foodList", method = RequestMethod.GET)
    public String showFoodList(){
        return "redirect:/admin/food/foodDisplay";
    }

}
