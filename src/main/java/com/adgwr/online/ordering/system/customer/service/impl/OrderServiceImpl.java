package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Transactional(readOnly = false)
    @Override
    public int deleteShoppingCart() {
        return 0;
    }
}
