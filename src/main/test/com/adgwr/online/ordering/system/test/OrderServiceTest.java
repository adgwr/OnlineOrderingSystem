package com.adgwr.online.ordering.system.test;

import com.adgwr.online.ordering.system.OnlineOrderingSystemApplication;
import com.adgwr.online.ordering.system.customer.service.OrderService;
import com.adgwr.online.ordering.system.utils.ShipMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineOrderingSystemApplication.class)

public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testNewOrder() {
        orderService.newOrder("abc",1, ShipMethod.DELIVERY.getDec());
    }

    @Test
    public void testChangeOrderState() {
        orderService.changeOrderState(8);
    }

    @Test
    public void testCancelOrder() {
        orderService.cancelOrder(8);
    }
}
