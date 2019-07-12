package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.ConsumptionStatisticsService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.vo.CustumerConsumption;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
            @RequestParam(value = "selectScope", defaultValue = "all") String selectScope,
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");

        ModelAndView modelAndView = new ModelAndView("customer/consumptionStatics");

        PageHelper.startPage(pn, 2);
        List<CustumerConsumption> consumptions = statisticsService.getConsumptionWithScope(customer.getcId(), selectScope);
        List<CustumerConsumption> consumptionsFroPie = statisticsService.getConsumptionWithScope(customer.getcId(), "all");
//        List<CustumerConsumption> consumptionsFroPie = statisticsService.getConsumptionWithScope();

        // 只显示两行
        //PageHelper.startPage(pn, 5);
//        List<CustumerConsumption> consumptions = statisticsService.getConsumptionWithScope(customer.getcId(), selectScope);
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
            modelAndView.addObject("totalPages", page.getPages());
        }
        modelAndView.addObject("consumptions", consumptions);
        modelAndView.addObject("consumptionsFroPie", consumptionsFroPie);
        //
        modelAndView.addObject("selectScope", selectScope);

        return modelAndView;
    }

    /**
     * ajax 异步get方法
     * @param pn 第几个页面
     * @return
     */
    @GetMapping(value = "staticsWithPage")
    @ResponseBody
    public List<CustumerConsumption> staticsWithPage(
            @RequestParam(value = "pn") Integer pn,
            @RequestParam(value = "selectScope", defaultValue = "all") String selectScope,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        PageHelper.startPage(pn, 2);
        List<CustumerConsumption> consumptions = statisticsService.getConsumptionWithScope(customer.getcId(), selectScope);

        return consumptions;
    }
}
