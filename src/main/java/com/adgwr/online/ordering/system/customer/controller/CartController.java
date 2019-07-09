package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CartService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Shoppingcart;
import com.adgwr.online.ordering.system.dto.LineItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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

        List<Shoppingcart> shoppingcarts = cartService.getShoppingcart(cId);

        //封装传输对象
        List<LineItemDTO> lineItemList = new ArrayList<>();
        LineItemDTO lineItemDTO;

        for (Shoppingcart shoppingcart : shoppingcarts) {
            lineItemDTO = new LineItemDTO();
            Integer foodId = shoppingcart.getFoodId();
            Food food = cartService.getFoodByFoodId(foodId);
            lineItemDTO.setFood(food);
            lineItemDTO.setShoppingcart(shoppingcart);
            lineItemDTO.setTotalPrice(food.getFdPrice().multiply(new BigDecimal(shoppingcart.getAmount().toString())));
            lineItemList.add(lineItemDTO);
        }

        model.addAttribute("lineItemList", lineItemList);
        return "showCart";
    }

    @RequestMapping(value = "modifyShoppingCart", method = RequestMethod.GET)
    public String value(HttpServletRequest request, HttpServletResponse response,
                        String modifyType, Integer foodId, Model model, RedirectAttributes redirectAttributes) {

        Customer customer = (Customer) request.getSession().getAttribute("customer");
        String cId = customer.getcId();

        List<Shoppingcart> shoppingcarts = cartService.getShoppingcart(cId);
        Shoppingcart newShoppingcart=new Shoppingcart();
        Shoppingcart oldShoppingcart=new Shoppingcart();
        for (Shoppingcart shoppingcart : shoppingcarts) {
            if(foodId.equals(shoppingcart.getFoodId())){
                newShoppingcart.setAmount(shoppingcart.getAmount());
                newShoppingcart.setcId(shoppingcart.getcId());
                newShoppingcart.setFoodId(shoppingcart.getFoodId());

                oldShoppingcart.setAmount(shoppingcart.getAmount());
                oldShoppingcart.setcId(shoppingcart.getcId());
                oldShoppingcart.setFoodId(shoppingcart.getFoodId());
                break;
            }
        }

        Integer amount = newShoppingcart.getAmount();

        switch (modifyType) {
            case "add":
                amount = amount + 1;
                break;
            case "minus":
                if (amount > 1) {
                    amount = amount - 1;
                } else {
                    redirectAttributes.addFlashAttribute("message", "商品数量不能小于1");
                }
                break;
        }
        newShoppingcart.setAmount(amount);
        cartService.updateShoppingcart(newShoppingcart,oldShoppingcart);
        return "redirect:/showCart";
    }

    @RequestMapping(value = "deleteShoppingCart", method = RequestMethod.POST)
    public String deleteShoppingCart(
            HttpServletRequest request,
            HttpServletResponse response,
            String itemselected,
            RedirectAttributes redirectAttributes) {
        String[] item = itemselected.split(",");
        List<Integer> foodIds = new ArrayList<>();
        for (String s : item) {
            foodIds.add(Integer.parseInt(s));
        }
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        cartService.deleteShoppingcart(foodIds,customer.getcId());
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/showCart";
    }

}
