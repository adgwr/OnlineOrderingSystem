package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminOrderService;
import com.adgwr.online.ordering.system.vo.OrderWithReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminOrderController {

    @Autowired
    private AdminOrderService adminOrderService;

    /**
     * 打开订单管理的页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "showOrderList", method = RequestMethod.GET)
    public String showOrderLists(Model model) {
        List<OrderWithReceiver> paidList = adminOrderService.showPaidList();
        List<OrderWithReceiver> receivedList = adminOrderService.showReceivedList();
        List<OrderWithReceiver> deliveringList = adminOrderService.showDeliveringList();
        List<OrderWithReceiver> finishedList = adminOrderService.showFinishedList();
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
        if(paidOrder == null){
            model.addAttribute("message", "您没有选中任何订单");
            return showOrderLists(model);
        }
        for (String s : paidOrder) {
            adminOrderService.receiveOrder(Integer.parseInt(s));
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
        if(receiveOrder == null){
            model.addAttribute("message", "您没有选中任何订单");
            return showOrderLists(model);
        }
        for (String s : receiveOrder) {
            adminOrderService.deliverOrder(Integer.parseInt(s));
        }
        return showOrderLists(model);
    }


    @RequestMapping(value = "searchOrders",method = RequestMethod.POST)
    public String searchOrders(String selYear,String selMonth,String selDay, Model model){
        List<OrderWithReceiver> searchList = adminOrderService.searchOrders(selYear,selMonth,selDay);
        List<OrderWithReceiver> paidList = adminOrderService.showPaidList();
        List<OrderWithReceiver> receivedList = adminOrderService.showReceivedList();
        List<OrderWithReceiver> deliveringList = adminOrderService.showDeliveringList();
        model.addAttribute("paidList", paidList);
        model.addAttribute("receivedList", receivedList);
        model.addAttribute("deliveringList", deliveringList);
        model.addAttribute("finishedList", searchList);
        return "admin/OrderManage";
    }
}
