package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;

import java.util.List;

/**
 * @author Administrator
 */
public interface CartService {
    List<Lineitem> getLineitem(List<Integer> orderIds);

    Food getFoodByFoodId(Integer foodId);

    List<Integer> getOrderIdByCId(String cId);

    void updateLineitem(Lineitem lineitem,Lineitem newLineitem);
}
