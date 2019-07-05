package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.ConsumptionStatisticsService;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
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

        // test
//        List<CustumerConsumption> consumptions = new ArrayList<>();
//        CustumerConsumption c1 = new CustumerConsumption();
//        c1.setFoodName("米饭");
//        c1.setFoodNum(5);
//        c1.setTotalPrice(50.0);
//        consumptions.add(c1);
//        c1 = new CustumerConsumption();
//        c1.setFoodName("紫菜蛋汤");
//        c1.setFoodNum(5);
//        c1.setTotalPrice(20.0);
//        consumptions.add(c1);
//        c1 = new CustumerConsumption();
//        c1.setFoodName("干锅");
//        c1.setFoodNum(5);
//        c1.setTotalPrice(80.0);
//        consumptions.add(c1);
//        c1 = new CustumerConsumption();
//        c1.setFoodName("红烧肉");
//        c1.setFoodNum(5);
//        c1.setTotalPrice(100.0);
//        consumptions.add(c1);

//        System.out.println(consumptions.size());

        List<CustumerConsumption> consumptions = statisticsService.getCustumerConsumptionToday();

        System.out.println(consumptions.size());
        modelAndView.addObject("consumptions", consumptions);

        return modelAndView;
    }

    @PostMapping(value = "statics")
    public ModelAndView postStatics(@RequestParam("selectScope") String selectScope) {
        System.out.print("post:" +selectScope);
        ModelAndView modelAndView = new ModelAndView("customer/consumptionStatics");
        // consumptionStatistics   editCustomer
        List<CustumerConsumption> consumptions = null;
        switch (selectScope) {
            case "today":
                consumptions = statisticsService.getCustumerConsumptionToday();
                break;
            case "week":
                consumptions = statisticsService.getCustumerConsumptionThisWeek();
                break;
            case "month":
                consumptions = statisticsService.getCustumerConsumptionThisMonth();
                break;
                default:
                    throw new IllegalArgumentException("日期范围错误！");
        }


        System.out.println(" num: " + consumptions.size());
        modelAndView.addObject("consumptions", consumptions);

        return modelAndView;
    }
}
