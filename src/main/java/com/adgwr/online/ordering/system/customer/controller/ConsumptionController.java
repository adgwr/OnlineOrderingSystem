package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.ConsumptionStatisticsService;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     * 按一定范围查询消费情况
     * @param pn 查询的页面
     * @param selectScope 查询范围
     * @return
     */
    @GetMapping(value = "statics")
    public ModelAndView getStatics(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "selectScope", defaultValue = "all") String selectScope
    ){
        ModelAndView modelAndView = new ModelAndView("customer/consumptionStatics");

        List<CustumerConsumption> consumptionsFroPie = statisticsService.getConsumptionWithScope("abc", "all");

        // 只显示两行
        PageHelper.startPage(pn, 2);
        List<CustumerConsumption> consumptions = statisticsService.getConsumptionWithScope("abc", selectScope);
        PageInfo page = new PageInfo(consumptions, 5);
        if(page.getPages() == 0) {
            modelAndView.addObject("hasCon", false);
        }
        else {
            modelAndView.addObject("hasCon", true);
            modelAndView.addObject("currentPage",page.getPageNum());
            int start = (pn-1)/5*5+1;
            int end = Math.min(start+4,page.getPages());
            modelAndView.addObject("hasStart",start != 1);
            modelAndView.addObject("hasEnd",end != page.getPages());
            modelAndView.addObject("startPage", start);
            modelAndView.addObject("endPage", end);
        }
        modelAndView.addObject("consumptions", consumptions);
        modelAndView.addObject("consumptionsFroPie", consumptionsFroPie);

        return modelAndView;
    }

    /*@PostMapping(value = "statics")
    public ModelAndView postStatics(@RequestParam("selectScope") String selectScope) {
        System.out.print("post:" +selectScope);
        ModelAndView modelAndView = new ModelAndView("customer/consumptionStatics");
        // consumptionStatistics   editCustomer
        List<CustumerConsumption> consumptions = null;


//        consumptions = statisticsService.getConsumptionWithScopr(selectScope);

        System.out.println(" num: " + consumptions.size());
        modelAndView.addObject("consumptions", consumptions);
        modelAndView.addObject("selectScope", selectScope);

        return modelAndView;
    }*/

    /**
     * ajax 异步get方法
     * @param pn 第几个页面
     * @return
     */
    @GetMapping(value = "staticsWithPage")
    @ResponseBody
    public List<CustumerConsumption> staticsWithPage(
            @RequestParam(value = "pn") Integer pn,
            @RequestParam(value = "selectScope", defaultValue = "all") String selectScope
    ) {
        PageHelper.startPage(pn, 2);
        List<CustumerConsumption> consumptions = statisticsService.getConsumptionWithScope("abc", selectScope);

        return consumptions;
    }
}
