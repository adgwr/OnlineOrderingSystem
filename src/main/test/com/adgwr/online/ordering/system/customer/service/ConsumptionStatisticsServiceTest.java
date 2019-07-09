package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.OnlineOrderingSystemApplication;
import com.adgwr.online.ordering.system.mapper.CustomerMapper;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void T() {
        /*for (CustumerConsumption c : statisticsService.getCustumerConsumptionThisWeek()) {
            System.out.println(c.getFoodName());
            System.out.println(c.getFoodNum());
            System.out.println(c.getTotalPrice());
        }*/

        List<CustumerConsumption> consumptions = customerMapper.getConsumptions("abc");
        System.out.println(consumptions.size());
        for (CustumerConsumption c : consumptions) {
            System.out.println(c.getFoodName());
            System.out.println(c.getFoodNum());
            System.out.println(c.getTotalPrice());
        }
    }

    /**
     * 范围查询mapper测试
     */
    @Test
    public void T2() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        List<CustumerConsumption> consumptions = customerMapper.getConsumptionsWithScope("abc", "2019-07-03 18:00:00"
                , "2019-07-05 18:00:00");
        System.out.println(consumptions.size());
        for (CustumerConsumption c : consumptions) {
            System.out.println(c.getFoodName());
            System.out.println(c.getFoodNum());
            System.out.println(c.getTotalPrice());
        }
    }

    /**
     * 范围查询service测试
     */
    @Test
    public void T3() {
        List<CustumerConsumption> consumptions = statisticsService.getConsumptionWithScope("abc", "month");
        System.out.println(consumptions.size());
//        for (CustumerConsumption c : consumptions) {
//            System.out.println(c.getFoodName());
//            System.out.println(c.getFoodNum());
//            System.out.println(c.getTotalPrice());
//        }
    }

}