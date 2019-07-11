package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.AdminOrderService;
import com.adgwr.online.ordering.system.vo.OrderWithReceiver;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminOrderController {

    @Autowired
    private AdminOrderService adminOrderService;

    /**
     * 打开订单管理页面
     * @param selectState 选择的订单状态
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(value = "showOrderList", method = RequestMethod.GET)
    public String showOrderLists(@RequestParam(value = "selectState", defaultValue = "toAccept") String selectState,
                                 @RequestParam(value = "pn", defaultValue = "1") Integer pn,

                                 Model model) {

        List<OrderWithReceiver> orders = null;
        PageHelper.startPage(pn, 8);
        PageHelper.orderBy("order_date DESC");
        switch (selectState){
            case "toAccept":
                orders = adminOrderService.showPaidList();
                break;
            case "toDeliver":
                orders = adminOrderService.showReceivedList();
                break;
            case "delivering":
                orders = adminOrderService.showDeliveringList();
                break;
            case "completed":
                orders = adminOrderService.showFinishedList();
                break;
                default:
                    break;
        }

        PageInfo pageInfo = new PageInfo(orders, 5);
        if (pageInfo.getPages() == 0) {
            model.addAttribute("hasOrders", false);
        } else {
            model.addAttribute("hasOrders", true);
            model.addAttribute("currentPage",pageInfo.getPageNum());
            int start = (pn-1)/5*5+1;
            int end = Math.min(start+4,pageInfo.getPages());
            model.addAttribute("hasStart",start != 1);
            model.addAttribute("hasEnd",end != pageInfo.getPages());
            model.addAttribute("startPage", start);
            model.addAttribute("endPage", end);
        }

        model.addAttribute("orders", orders);
        model.addAttribute("selectState", selectState);
        // 是不是查询某日期的
        model.addAttribute("searchDate", false);
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
            return showOrderLists("toAccept",1, model);
        }
        for (String s : paidOrder) {
            adminOrderService.receiveOrder(Integer.parseInt(s));
        }
        return showOrderLists("toAccept", 1, model);
    }

    /**
     * 将已接单的订单改为配送中状态
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "deliverOrder", method = RequestMethod.POST)
    public String deliverOrder(String[] receiveOrder, Model model) {
        if(receiveOrder == null){
            model.addAttribute("message", "您没有选中任何订单");
            return showOrderLists("toDeliver", 1, model);
        }
        for (String s : receiveOrder) {
            adminOrderService.deliverOrder(Integer.parseInt(s));
        }
        return showOrderLists("toDeliver", 1, model);
    }


    /**
     * 在一定时间范围内搜索已经完成的订单
     * @param selYear
     * @param selMonth
     * @param selDay
     * @param model
     * @return
     */
    @RequestMapping(value = "searchOrders",method = RequestMethod.POST)
    public String searchOrders(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
            String selYear,String selMonth,String selDay, Model model){
        List<OrderWithReceiver> orders = null;
        PageHelper.startPage(pn, 1);
        PageHelper.orderBy("order_date DESC");

        orders = adminOrderService.searchOrders(selYear,selMonth,selDay);

        PageInfo pageInfo = new PageInfo(orders, 5);
        if (pageInfo.getPages() == 0) {
            model.addAttribute("hasOrders", false);
        } else {
            model.addAttribute("hasOrders", true);
            model.addAttribute("currentPage",pageInfo.getPageNum());
            int start = (pn-1)/5*5+1;
            int end = Math.min(start+4,pageInfo.getPages());
            model.addAttribute("hasStart",start != 1);
            model.addAttribute("hasEnd",end != pageInfo.getPages());
            model.addAttribute("startPage", start);
            model.addAttribute("endPage", end);
            System.out.println("列表大小:" + orders.size());
            System.out.println("startPage: " + start + " endPage: " + end);
        }

        model.addAttribute("orders", orders);
        model.addAttribute("selectState", "completed");
        model.addAttribute("searchDate", true);
        return "admin/OrderManage";
    }
}
