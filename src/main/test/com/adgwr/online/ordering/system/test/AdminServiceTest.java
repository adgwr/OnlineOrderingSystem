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
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.URL;
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
        MyOrder myOrder=new MyOrder();
        myOrder.setOrderDate((new Date()).toString());
        myOrderMapper.insert(myOrder);
    }

    @Test
    public void testLogin(){
        AdminAccount adminAccount=adminService.login("18000000000","123456");
        System.out.println(adminAccount.getAdminId());
        System.out.println(adminAccount.getAdTel());
        System.out.println(adminAccount.getPassword());
        Assert.assertNotNull(adminAccount);
    }

    @Test
    public void te() {
        try {
            URL path = ResourceUtils.getURL("src\\main\\resources\\static\\foodImage");
            System.out.println(path.getPath());
//            System.out.println(path.getFile().isEmpty());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
