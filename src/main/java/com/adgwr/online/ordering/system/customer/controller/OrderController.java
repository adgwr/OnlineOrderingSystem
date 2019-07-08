package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.OrderService;
import com.adgwr.online.ordering.system.customer.service.ReceiverService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Receiver;
import com.adgwr.online.ordering.system.mapper.ReceiverMapper;
import com.adgwr.online.ordering.system.vo.BalanceItem;
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
import java.math.BigDecimal;
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

    @Autowired
    private ReceiverService receiverService;

    @RequestMapping(value = "DeleteShoppingCart",method = RequestMethod.POST)
    public String deleteShoppingCart(){

        return "showCart";
    }


    /**
     * 新建订单
     *
     * @param rId
     * @param shipMethodFlag
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "newOrder", method = RequestMethod.POST)
    public String newOrder(@RequestParam("receiverId") Integer rId,
                           @RequestParam("Checkout[shipment_id]") Integer shipMethodFlag,
                           HttpServletRequest request,
                           Model model) {
        String shipMethod;
        if(shipMethodFlag == 0) {
            shipMethod = "商家配送";
        }
        else if(shipMethodFlag == 1) {
            shipMethod = "到店自取";
        }
        else throw new IllegalArgumentException("配送方式非法！");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String cId = customer.getcId();
        List<BalanceItem> balanceItems = (List<BalanceItem>) session.getAttribute("balanceItems");
        int orderId = orderService.newOrder(cId, rId, shipMethod, balanceItems);

        BigDecimal totalPrice = (BigDecimal) session.getAttribute("orderPrice");
        model.addAttribute("orderId", orderId);
        model.addAttribute("totalPrice", totalPrice);
        Receiver receiver = receiverService.getReceiverById(rId);
        model.addAttribute("receiver", receiver);

        return "payOrder";
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
        if(totalPages == 0) {
            model.addAttribute("hasOrder", false);
        }
        else {
            model.addAttribute("hasOrder", true);
            int startPage = (pn-1)/5*5+1;
            int endPage = Math.min(startPage+4,totalPages);
            model.addAttribute("currentPage",pn);
            model.addAttribute("hasStart",startPage != 1);
            model.addAttribute("hasEnd",endPage != totalPages);
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
        }
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
