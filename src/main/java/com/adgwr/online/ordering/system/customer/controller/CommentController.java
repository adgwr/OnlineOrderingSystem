package com.adgwr.online.ordering.system.customer.controller;


import com.adgwr.online.ordering.system.customer.service.CommentService;
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

    @RequestMapping(value = "prepareAssess", method = RequestMethod.POST)
    public String prepareComment(@RequestParam("orderId") Integer orderId, Model model) {
        List<Food> foods = commentService.getFoodList(orderId);
        model.addAttribute("foods", foods);
        model.addAttribute("orderId", orderId);
        return "assess";
    }

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    public String addComment(@RequestParam("orderId") Integer orderId,
                             @RequestParam("foodId") Integer foodId,
                             @RequestParam("comment") String comment,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        commentService.addComment(orderId, foodId, comment);
        return "getComments";
    }

    @RequestMapping(value = "getComments", method = RequestMethod.GET)
    public String getComments(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                              @RequestParam("foodId") Integer foodId, Model model) {
        PageHelper.startPage(pn, 8);
        PageHelper.orderBy("food_id asc");
        List<FoodComment> commentsList = commentService.getFoodComment(foodId);
        PageInfo page = new PageInfo(commentsList, 5);

        model.addAttribute("comments", commentsList);
        return "commentsList";
    }

    @RequestMapping(value = "deleteComment", method = RequestMethod.POST)
    public String deleteComment(@RequestParam("orderId") Integer orderId, @RequestParam("foodId") Integer foodId) {
        commentService.deleteComment(orderId, foodId);
        return "getComments";
    }
}
