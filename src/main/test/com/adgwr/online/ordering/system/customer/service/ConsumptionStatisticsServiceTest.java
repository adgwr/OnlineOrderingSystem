package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.OnlineOrderingSystemApplication;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author LiYuHan
 * @title ConsumptionStatisticsServiceTest
 * @description
 * @date 5/7/2019 下午4:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineOrderingSystemApplication.class)
public class ConsumptionStatisticsServiceTest {
    @Autowired
    private ConsumptionStatisticsService statisticsService;

    @Test
    public void T() {
        for (CustumerConsumption c : statisticsService.getCustumerConsumptionThisWeek()) {
            System.out.println(c.getFoodName());
            System.out.println(c.getFoodNum());
            System.out.println(c.getTotalPrice());
        }
    }

}