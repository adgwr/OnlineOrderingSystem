package com.adgwr.online.ordering.system.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 */
@Controller
public class OrderController {
    @RequestMapping(value = "DeleteShoppingCart",method = RequestMethod.POST)
    public String deleteShoppingCart(){

        return "showCart";
    }
}
