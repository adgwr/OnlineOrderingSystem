package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.Shoppingcart;

import java.util.List;

/**
 * 购物车Service
 *
 * @author Administrator
 * @version 1.0
 */
public interface CartService {

    /**
     * 返回菜品信息
     *
     * @param orderIds 订单id列表
     * @return 菜品信息列表
     */
    List<Lineitem> getLineitem(List<Integer> orderIds);

    /**
     * 通过id查找菜品
     *
     * @param foodId 菜品id
     * @return 菜品
     */
    Food getFoodByFoodId(Integer foodId);

    /**
     * 通过客户id查找订单id
     * @param cId 客户id
     * @return 订单id列表
     */
    List<Integer> getOrderIdByCId(String cId);

    /**
     * 返回购物车中的菜品信息
     *
     * @param cId 客户id
     * @return 购物车中的菜品信息
     */
    List<Shoppingcart> getShoppingcart(String cId);

    /**
     * 更新购物车
     *
     * @param newShoppingcart 新的购物车
     * @param oldShoppingcart 旧的购物车
     */
    void updateShoppingcart(Shoppingcart newShoppingcart, Shoppingcart oldShoppingcart);

    /**
     * 删除购物车中的菜品
     *
     * @param foodIds 菜品id列表
     * @param cId 客户id
     */
    void deleteShoppingcart(List<Integer> foodIds, String cId);

    /**
     * 添加购物车
     *
     * @param cId 客户id
     * @param foodId 菜品id
     */
    void addShoppingcart(String cId, int foodId);
}
