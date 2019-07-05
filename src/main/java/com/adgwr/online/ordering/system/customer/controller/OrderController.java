package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.OrderService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.vo.OrderWithFoodAndReceiver;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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


    @RequestMapping(value = "DeleteShoppingCart",method = RequestMethod.POST)
    public String deleteShoppingCart(){

        return "showCart";
    }


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

    @RequestMapping(value = "getOrder", method = RequestMethod.GET)
    public String getOrders(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                            HttpServletRequest request,
                            HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        List<OrderWithFoodAndReceiver> orders = orderService.getOrders(cId);
        int startPos = (pn - 1) * 8, endPos = startPos + 8 > orders.size() ? orders.size() : startPos + 8;
        List<OrderWithFoodAndReceiver> currentpages = orders.subList(startPos, endPos);
        int totalPages = orders.size() / 8;
        if(totalPages * 8 < orders.size()) {
            totalPages++;
        }
        int startPage = (pn-1)/5*5+1;
        int endPage = Math.min(startPage+4,totalPages);
        model.addAttribute("currentPage",pn);
        model.addAttribute("hasStart",startPage != 1);
        model.addAttribute("hasEnd",endPage != totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("orders", currentpages);
        return "orderList";
    }

    @RequestMapping(value = "cancelOrder", method = RequestMethod.POST)
    public String cancelOrder(@RequestParam("orderId") Integer orderId) {
        orderService.cancelOrder(orderId);
        return "getOrder";
    }

    @RequestMapping(value = "changeOrderState", method = RequestMethod.POST)
    public String changeOrderState(@RequestParam("orderId") Integer orderId) {
        orderService.changeOrderState(orderId);
        return "getOrder";
    }

    @RequestMapping(value = "/customer/Test", method = RequestMethod.GET)
    public String goTest() {
        return "customer/OrderTest";
    }

}
