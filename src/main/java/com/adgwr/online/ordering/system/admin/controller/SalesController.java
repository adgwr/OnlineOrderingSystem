package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.FoodService;
import com.adgwr.online.ordering.system.admin.service.SalesService;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.vo.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rch/dev
 */
@Controller
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private FoodService foodService;

    /**
     * 转向salesView.html界面，并传递saleList
     * @param model
     * @return
     */
    @RequestMapping(value = "admin/salesView", method = RequestMethod.GET)
    public String salesView(Model model) {
        List<Food> foodList = foodService.getAllFood();
        List<Sale> saleList = new ArrayList<Sale>();
        //获取saleList
        for(Food food:foodList) {
            Sale sale = new Sale();
            sale.setFoodId(food.getFoodId());
            sale.setFoodName(food.getFdName());
            List<Lineitem> lineitemList = salesService.getLineItemByFoodId(food.getFoodId());
            int amount = 0;
            for(Lineitem lineitem:lineitemList) {
                amount += lineitem.getAmount();
            }
            sale.setAmount(amount);
            saleList.add(sale);
        }
        model.addAttribute("saleList",saleList);
        model.addAttribute("viewMethod", "今日");
        return "admin/salesView";
    }

}
