package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.ConsumptionStatisticsService;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiYuHan
 * @title ConsumptionController
 * @description 用户消费统计控制层
 * @date 4/7/2019 下午11:57
 */
@Controller
public class ConsumptionController {

    @Autowired
    private ConsumptionStatisticsService statisticsService;

    @GetMapping(value = "statics")
    public ModelAndView getStatics() {
        ModelAndView modelAndView = new ModelAndView("customer/consumptionStatics");
        // consumptionStatics   editCustomer

        List<CustumerConsumption> consumptions = new ArrayList<>();
        CustumerConsumption c1 = new CustumerConsumption();
        c1.setFoodName("米饭");
        c1.setFoodNum(5);
        c1.setTotalPrice(10.0);
        consumptions.add(c1);
        c1 = new CustumerConsumption();
        c1.setFoodName("紫菜蛋汤");
        c1.setFoodNum(5);
        c1.setTotalPrice(20.0);
        consumptions.add(c1);
        c1 = new CustumerConsumption();
        c1.setFoodName("干锅");
        c1.setFoodNum(5);
        c1.setTotalPrice(80.0);
        consumptions.add(c1);
        c1 = new CustumerConsumption();
        c1.setFoodName("红烧肉");
        c1.setFoodNum(5);
        c1.setTotalPrice(100.0);
        consumptions.add(c1);

//        System.out.println(consumptions.size());

//                statisticsService.getCustumerConsumptionThisMonth();

        modelAndView.addObject("consumptions", consumptions);

        return modelAndView;
    }

    @PostMapping(value = "statics")
    public ModelAndView postStatics() {
        ModelAndView modelAndView = new ModelAndView("customer/consumptionStatics");
        // consumptionStatistics   editCustomer


        return modelAndView;
    }
}
