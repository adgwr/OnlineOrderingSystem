package com.adgwr.online.ordering.system.customer.controller;


import com.adgwr.online.ordering.system.customer.service.OrderService;
import com.adgwr.online.ordering.system.customer.service.ReceiverService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.domain.Receiver;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import com.adgwr.online.ordering.system.vo.BalanceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;


/**
 * 实现了结算的Controller
 *
 * @author lyc
 * @version 1.0
 */
@Controller
public class BalanceController {

    @Autowired
    private ReceiverService receiverService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "prepareBalance", method = RequestMethod.POST)
    public String prepareBalance(@RequestParam("itemselected")Integer [] itemSelected,
                                 HttpServletRequest request,
                                 Model model) {
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        List<Receiver> receiverList = receiverService.getReceivers(cId);
        model.addAttribute("receivers", receiverList);
        List<BalanceItem> balanceItems = orderService.getBalanceItems(cId, itemSelected);
        BigDecimal totalPrice = new BigDecimal("0");
        for(BalanceItem balanceItem : balanceItems) {
            totalPrice = totalPrice.add(balanceItem.getTotalPrice());
        }
        totalPrice.setScale(2);
        model.addAttribute("orderPrice", totalPrice);
        model.addAttribute("balanceItems", balanceItems);
        session.setAttribute("orderPrice", totalPrice);
        session.setAttribute("balanceItems", balanceItems);
        return "balance";
    }

    @RequestMapping(value = "returnToBalance", method = RequestMethod.GET)
    public String returnToBalance(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        List<Receiver> receiverList = receiverService.getReceivers(cId);
        model.addAttribute("receivers", receiverList);
        BigDecimal totalPrice = (BigDecimal) session.getAttribute("orderPrice");
        List<BalanceItem> balanceItems = (List<BalanceItem>) session.getAttribute("balanceItems");
        model.addAttribute("orderPrice", totalPrice);
        model.addAttribute("balanceItems", balanceItems);
        return "balance";
    }

    @RequestMapping(value = "paySuccessfully", method = RequestMethod.POST)
    public String paySuccessfully(@RequestParam("orderId")Integer orderId,
                                  @RequestParam("orderPrice")BigDecimal orderPrice,
                                  HttpServletRequest request,
                                  Model model) {
        orderService.changeOrderState(orderId);
        HttpSession session = request.getSession();
        model.addAttribute("totalPrice", orderPrice);
        model.addAttribute("orderId", orderId);
        session.removeAttribute("orderPrice");
        session.removeAttribute("balanceItems");
        return "paySuccessfully";
    }

    @RequestMapping(value = "payOrder", method = RequestMethod.POST)
    public String payOrder(@RequestParam("orderId")Integer orderId,
//                           HttpServletRequest request,
                           Model model) {
//        HttpSession session = request.getSession();
//        String cId = ((Customer)session.getAttribute("customer")).getcId();
        MyOrder myOrder= orderService.getOrderById(orderId);
        Receiver receiver = receiverService.getReceiverById(myOrder.getrId());
        BigDecimal totalPrice = orderService.getOrderPrice(orderId);
        model.addAttribute("orderId", orderId);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("receiver", receiver);
        return "payOrder";
    }
}
