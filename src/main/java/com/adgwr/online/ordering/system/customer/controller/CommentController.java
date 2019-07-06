package com.adgwr.online.ordering.system.customer.controller;


import com.adgwr.online.ordering.system.customer.service.CollectionService;
import com.adgwr.online.ordering.system.customer.service.CommentService;
import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.customer.service.OrderService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.vo.FoodComment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CollectionService collectionService;


    @RequestMapping(value = "prepareAssess", method = RequestMethod.POST)
    public String prepareComment(@RequestParam("orderId") Integer orderId, Model model) {
        List<Food> foods = commentService.getFoodList(orderId);
        model.addAttribute("foods", foods);
        model.addAttribute("orderId", orderId);
        return "assess";
    }

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    public String addComment(@RequestParam("comments") String comments,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        String[] split1 = comments.split("#");
        int orderId = Integer.valueOf(split1[0]);
        String[] split2 = (split1[1]).split("&");
        for(int i=0;i<split2.length;i++){
            String[] split3 = (split2[i]).split("@");
            int foodId = Integer.valueOf( split3[0] );
            String comment = split3[1];
            commentService.addComment(orderId, foodId, comment);
        }
        orderService.changeOrderState(orderId);
        return "redirect:/getOrder";
    }

    @RequestMapping(value = "foodDetail", method = RequestMethod.GET)
    public String getCommentsAndFoodDetail(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                           @RequestParam("foodId") Integer foodId,
                                           HttpServletRequest request,
                                           HttpServletResponse response,
                                           Model model) {
        // 获取评论信息
        List<FoodComment> commentsList = commentService.getFoodComment(foodId);
        int startPos = (pn - 1) * 8, endPos = startPos + 8 > commentsList.size() ? commentsList.size() : startPos + 8;
        List<FoodComment> currentpages = commentsList.subList(startPos, endPos);
        int totalPages = commentsList.size() / 8;
        if(totalPages * 8 < commentsList.size()) {
            totalPages++;
        }
        int startPage = (pn-1)/5*5+1;
        int endPage = Math.min(startPage+4,totalPages);
        model.addAttribute("currentPage",pn);
        model.addAttribute("hasStart",startPage != 1);
        model.addAttribute("hasEnd",endPage != totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("comments", currentpages);

        // 获取菜品详情
        Food food = customerService.getFoodById(foodId);
        model.addAttribute("food", food);
        // 获取该菜品是否被该客户收藏
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        model.addAttribute("isFavourite", collectionService.hasCollected(foodId, cId));

        return "commentsList";
    }

    @RequestMapping(value = "deleteComment", method = RequestMethod.POST)
    public String deleteComment(@RequestParam("orderId") Integer orderId, @RequestParam("foodId") Integer foodId) {
        commentService.deleteComment(orderId, foodId);
        return "getComments";
    }
}
