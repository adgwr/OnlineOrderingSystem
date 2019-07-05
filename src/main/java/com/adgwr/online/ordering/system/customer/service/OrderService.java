package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.utils.ShipMethod;
import com.adgwr.online.ordering.system.vo.OrderWithFoodAndReceiver;

import java.util.List;

/**
 * @author LiYuHan
 * @title OrderService
 * @description
 * @date 3/7/2019 下午4:19
 */
public interface OrderService {

    /**
     * 新生成一个订单
     * @param cid 用户id
     * @param rid 收货人id
     * @param method 配送方式
     */
    void newOrder(String cid, Integer rid, String method);

    /**
     * 改变订单状态
     *
     * @param orderId
     */
    void changeOrderState(int orderId);

    /**
     * 取消订单
     *
     * @param orderId
     */
    void cancelOrder(int orderId);

    /**
     * 返回客户的所有订单
     *
     * @param cId
     */
    List<OrderWithFoodAndReceiver> getOrders(String cId);

    int deleteShoppingCart();

}
