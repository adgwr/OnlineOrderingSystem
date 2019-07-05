package com.adgwr.online.ordering.system.customer.controller;


import com.adgwr.online.ordering.system.customer.service.CommentService;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.vo.FoodComment;
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

    @RequestMapping(value = "prepareAccess", method = RequestMethod.POST)
    public String prepareComment(@RequestParam("orderId") int orderId, Model model) {
        List<Food> foods = commentService.getFoodList(orderId);
        model.addAttribute("foods", foods);
        model.addAttribute("orderId", orderId);
        return "access";
    }

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    public String addCommnet(@RequestParam("orderId") int orderId,
                             @RequestParam("foodId") int foodId,
                             @RequestParam("comment") String comment,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        HttpSession session = request.getSession();
        String cId = (String) session.getAttribute("username");
        commentService.addComment(orderId, foodId, comment);
        return "getComments";
    }

    @RequestMapping(value = "getComments", method = RequestMethod.POST)
    public String getComments(@RequestParam("foodId") int foodId, Model model) {
        List<FoodComment> commentsList = commentService.getFoodComment(foodId);
        model.addAttribute("comments", commentsList);
        return "commentsList";
    }

    @RequestMapping(value = "deleteComment", method = RequestMethod.POST)
    public String deleteComment(@RequestParam("orderId") int orderId, @RequestParam("foodId") int foodId) {
        commentService.deleteComment(orderId, foodId);
        return "getComments";
    }
}
