package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author LiYuHan
 * @title OrderController
 * @description
 * @date 4/7/2019 上午9:33
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 新建订单的controller
     * @param cId
     * @param rId
     * @param shipMethod
     * @param redirectAttributes
     * @return
     */
    @PostMapping(value = "/newOrder")
    @ResponseBody
    public String newOrder(@RequestParam("cId") String cId, @RequestParam("rId") Integer rId,
                           @RequestParam("shipMethod") String shipMethod,
                           RedirectAttributes redirectAttributes) {

        if (cId == null) {
            redirectAttributes.addFlashAttribute("message", "cId is null");
            return "redirect:/error";
        }
        if (rId == null){
            redirectAttributes.addFlashAttribute("message", "rId is null");
            return "redirect:/error";
        }

        orderService.newOrder(cId, rId, shipMethod);

        return "成功";
    }

    @PostMapping(value = "/cancelOrder")
    @ResponseBody
    public String cancelOrder(@RequestParam("orderId") String [] ids) {


        return null;
    }

    @RequestMapping(value = "/customer/Test", method = RequestMethod.GET)
    public String goTest() {
        return "customer/OrderTest";
    }

}
