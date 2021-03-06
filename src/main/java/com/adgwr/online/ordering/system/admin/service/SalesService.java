package com.adgwr.online.ordering.system.admin.service;

import com.adgwr.online.ordering.system.domain.Lineitem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SalesService {

    /**
     * 根据食品ID查找
     * @param foodId
     * @return
     */
    List<Lineitem> getLineItemByFoodId(int foodId);

    /**
     * 根据订单ID查找
     * @param orderId
     * @return
     */
    List<Lineitem> getLineItemByOrderId(int orderId);

    /**
     * 获取所有项
     * @return
     */
    List<Lineitem> getAllLineItem();
}
