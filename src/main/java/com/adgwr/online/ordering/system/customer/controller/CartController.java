package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CartService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.dto.LineItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 购物车
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "showCart", method = RequestMethod.GET)
    public String showCart(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model) {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        String cId = customer.getcId();

        List<Integer> orderIds = cartService.getOrderIdByCId(cId);
        List<Lineitem> lineitems = cartService.getLineitem(orderIds);

        //封装传输对象
        List<LineItemDTO> lineItemList = new ArrayList<>();

        LineItemDTO lineItemDTO;
        for (Lineitem lineitem : lineitems) {
            lineItemDTO = new LineItemDTO();
            Integer foodId = lineitem.getFoodId();
            Food food = cartService.getFoodByFoodId(foodId);
            lineItemDTO.setFood(food);
            lineItemDTO.setLineitem(lineitem);
            lineItemList.add(lineItemDTO);
        }
        model.addAttribute("lineItemList", lineItemList);
        return "showCart";
    }

    @RequestMapping(value = "modifyShoppingCart", method = RequestMethod.GET)
    public String value(HttpServletRequest request, HttpServletResponse response,
                        String modifyType, Integer foodId, Model model) {

        Customer customer = (Customer) request.getSession().getAttribute("customer");
        String cId = customer.getcId();

        List<Integer> orderIds = cartService.getOrderIdByCId(cId);
        List<Lineitem> lineitems = cartService.getLineitem(orderIds);
        Lineitem newLineitem = new Lineitem();
        Lineitem oldLineitem=new Lineitem();
        for (Lineitem lineitem : lineitems) {
            if (foodId.equals(lineitem.getFoodId())) {
                newLineitem.setTotalPrice(lineitem.getTotalPrice());
                newLineitem.setAmount(lineitem.getAmount());
                newLineitem.setFoodId(lineitem.getFoodId());
                newLineitem.setOrderId(lineitem.getOrderId());

                oldLineitem.setTotalPrice(lineitem.getTotalPrice());
                oldLineitem.setAmount(lineitem.getAmount());
                oldLineitem.setFoodId(lineitem.getFoodId());
                oldLineitem.setOrderId(lineitem.getOrderId());
                break;
            }
        }

        Integer amount = newLineitem.getAmount();
        switch (modifyType) {
            case "add":
                amount = amount - 1;
                break;
            case "minus":
                amount = amount + 1;
                break;
        }

        Food food = cartService.getFoodByFoodId(foodId);
        BigDecimal fdPrice = food.getFdPrice();

        newLineitem.setAmount(amount);
        newLineitem.setTotalPrice(fdPrice.multiply(new BigDecimal(amount.toString())));
        cartService.updateLineitem(oldLineitem,newLineitem);
        return "showCart";
    }
}
