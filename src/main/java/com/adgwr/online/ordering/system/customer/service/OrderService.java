package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.vo.BalanceItem;
import com.adgwr.online.ordering.system.vo.OrderWithFoodAndReceiver;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单Service
 *
 * @author LiYuHan
 * @title OrderService
 * @description
 * @date 3/7/2019 下午4:19
 */
public interface OrderService {


    /**
     * 新建订单
     *
     * @param cId 客户id
     * @param rId 收货人id
     * @param method 配送方式
     * @param balanceItems 订单菜品
     * @return 新生成的id
     */
    int newOrder(String cId, Integer rId, String method, List<BalanceItem> balanceItems);

    /**
     * 改变订单状态
     *
     * @param orderId 订单id
     */
    void changeOrderState(int orderId);

    /**
     * 取消订单
     *
     * @param orderId 订单id
     */
    void cancelOrder(int orderId);

    /**
     * 返回客户的所有订单
     *
     * @param cId 客户id
     */
    List<OrderWithFoodAndReceiver> getOrders(String cId);

    /**
     * 返回结算的菜品信息
     *
     * @param cId 客户id
     * @param foodIds 菜品id列表
     * @return 菜品信息列表
     */
    List<BalanceItem> getBalanceItems(String cId, Integer[] foodIds);

    /**
     * 通过id查找订单
     *
     * @param orderId 订单id
     * @return 订单
     */
    MyOrder getOrderById(int orderId);

    /**
     * 返回订单的总价格
     *
     * @param orderId 订单id
     * @return price
     */
    BigDecimal getOrderPrice(int orderId);
}
