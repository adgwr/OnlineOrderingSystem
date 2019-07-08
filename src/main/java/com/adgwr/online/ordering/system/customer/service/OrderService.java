package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.vo.BalanceItem;
import com.adgwr.online.ordering.system.vo.OrderWithFoodAndReceiver;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LiYuHan
 * @title OrderService
 * @description
 * @date 3/7/2019 下午4:19
 */
public interface OrderService {


    /**
     *
     * @param cId
     * @param rId
     * @param method
     * @param balanceItems
     * @return
     */
    int newOrder(String cId, Integer rId, String method, List<BalanceItem> balanceItems);

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

    List<BalanceItem> getBalanceItems(String cId, Integer[] foodIds);

    MyOrder getOrderById(int orderId);

    BigDecimal getOrderPrice(int orderId);
}
