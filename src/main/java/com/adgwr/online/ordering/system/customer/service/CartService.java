package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.domain.Shoppingcart;

import java.util.List;

/**
 * @author Administrator
 */
public interface CartService {
    List<Lineitem> getLineitem(List<Integer> orderIds);

    Food getFoodByFoodId(Integer foodId);

    List<Integer> getOrderIdByCId(String cId);

    List<Shoppingcart> getShoppingcart(String cId);

    void updateShoppingcart(Shoppingcart newShoppingcart, Shoppingcart oldShoppingcart);

    void deleteShoppingcart(List<Integer> foodIds, String cId);

    void addShoppingcart(String cId, int foodId);
}
