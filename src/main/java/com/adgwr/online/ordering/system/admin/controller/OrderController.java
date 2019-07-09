package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.OrderService;
import com.adgwr.online.ordering.system.vo.OrderWithReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 打开订单管理的页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "showOrderList", method = RequestMethod.GET)
    public String showOrderLists(Model model) {
        List<OrderWithReceiver> paidList = orderService.showPaidList();
        List<OrderWithReceiver> receivedList = orderService.showReceivedList();
        List<OrderWithReceiver> deliveringList = orderService.showDeliveringList();
        List<OrderWithReceiver> finishedList = orderService.showFinishedList();
        model.addAttribute("paidList", paidList);
        model.addAttribute("receivedList", receivedList);
        model.addAttribute("deliveringList", deliveringList);
        model.addAttribute("finishedList", finishedList);
        return "admin/OrderManage";
    }

    /**
     * 将已付款的订单改为已接单状态
     *
     * @param paidOrder
     * @param model
     * @return
     */
    @RequestMapping(value = "receiveOrder", method = RequestMethod.POST)
    public String receiveOrder(String[] paidOrder, Model model) {
        for (String s : paidOrder) {
            orderService.receiveOrder(Integer.parseInt(s));
        }
        return showOrderLists(model);
    }

    /**
     * 将已接单的订单改为配送中状态
     *
     * @param receiveOrder
     * @param model
     * @return
     */
    @RequestMapping(value = "deliverOrder", method = RequestMethod.POST)
    public String deliverOrder(String[] receiveOrder, Model model) {
        for (String s : receiveOrder) {
            orderService.deliverOrder(Integer.parseInt(s));
        }
        return showOrderLists(model);
    }

    @RequestMapping(value = "searchOrders",method = RequestMethod.POST)
    public String searchOrders(String selYear,String selMonth,String selDay, Model model){
        List<OrderWithReceiver> searchList = orderService.searchOrders(selYear,selMonth,selDay);
        List<OrderWithReceiver> paidList = orderService.showPaidList();
        List<OrderWithReceiver> receivedList = orderService.showReceivedList();
        List<OrderWithReceiver> deliveringList = orderService.showDeliveringList();
        model.addAttribute("paidList", paidList);
        model.addAttribute("receivedList", receivedList);
        model.addAttribute("deliveringList", deliveringList);
        model.addAttribute("finishedList", searchList);
        return "admin/OrderManage";
    }
}
