package com.adgwr.online.ordering.system.customer.controller;


import com.adgwr.online.ordering.system.customer.service.OrderService;
import com.adgwr.online.ordering.system.customer.service.ReceiverService;
import com.adgwr.online.ordering.system.domain.Customer;
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
import java.math.BigDecimal;
import java.util.List;


/**
 * 实现了结算的Controller
 *
 */
@Controller
public class BalanceController {

    @Autowired
    private ReceiverService receiverService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "prepareBalance", method = RequestMethod.POST)
    public String prepareBalance(@RequestParam("selectAllItems")Integer [] itemSelected,
                                 HttpServletRequest request,
                                 Model model) {
        String cId = ((Customer)request.getSession().getAttribute("customer")).getcId();
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
        return "balance";
    }



}
