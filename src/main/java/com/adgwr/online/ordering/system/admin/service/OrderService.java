package com.adgwr.online.ordering.system.admin.service;

import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.vo.OrderWithReceiver;

import java.util.List;

public interface OrderService {

    /**
     * 根据orderState来显示已支付的订单列表
     * @return
     */
    List<OrderWithReceiver> showPaidList();

    /**
     * 根据orderState来显示已接单的订单列表
     * @return
     */
    List<OrderWithReceiver> showReceivedList();

    /**
     * 根据orderState来显示配送中的订单列表
     * @return
     */
    List<OrderWithReceiver> showDeliveringList();

    /**
     * 根据orderState来显示已完成的订单列表
     * @return
     */
    List<OrderWithReceiver> showFinishedList();

    /**
     * 根据orderId接收订单
     * @param orderId
     */
    void receiveOrder(int orderId);

    /**
     * 根据orderId配送订单
     * @param orderId
     */
    void deliverOrder(int orderId);

    /**
     * 根据月份查询订单
     * @param month
     * @return
     */
    List<OrderWithReceiver> searchOrders(String year, String month, String day);
}
