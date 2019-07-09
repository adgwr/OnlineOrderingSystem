package com.adgwr.online.ordering.system.test;

import com.adgwr.online.ordering.system.OnlineOrderingSystemApplication;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.MyOrder;
import com.adgwr.online.ordering.system.mapper.AdminAccountMapper;
import com.adgwr.online.ordering.system.admin.service.AdminService;
import com.adgwr.online.ordering.system.mapper.MyOrderMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Administrator
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineOrderingSystemApplication.class)
//@Rollback
//@Transactional
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminAccountMapper adminAccountMapper;

    @Autowired
    private MyOrderMapper myOrderMapper;
    @Test
    public void test(){
        MyOrder m =new MyOrder();
        m.setOrderDate((new Date()).toString());
        orderMapper.insert(m);
//        int i = orderMapper.insertUseGeneratedKeys(m);
        Integer orderId = m.getOrderId();
        System.out.println(orderId);
    }

    @Test
    public void testLogin(){
        AdminAccount adminAccount=adminService.login("18000000000","123456");
        System.out.println(adminAccount.getAdminId());
        System.out.println(adminAccount.getAdTel());
        System.out.println(adminAccount.getPassword());
        Assert.assertNotNull(adminAccount);
    }

    @Autowired
    private MyOrderMapper orderMapper;

//    @Transactional(readOnly = false)

}
