package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CollectionService;
import com.adgwr.online.ordering.system.domain.Food;
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
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @RequestMapping(value = "addCollection", method = RequestMethod.POST)
    public void addCollection(@RequestParam("foodId")int foodId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String cId = (String) session.getAttribute("username");
        collectionService.addFood(foodId, cId);
    }

    @RequestMapping(value = "deleteCollection", method = RequestMethod.POST)
    public String deleteCollection(@RequestParam("foodId")int foodId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String cId = (String) session.getAttribute("username");
        collectionService.deleteFood(foodId, cId);
        return "getCollections";
    }

    @RequestMapping(value = "getCollections", method = RequestMethod.POST)
    public String getCollections(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        String cId = (String) session.getAttribute("username");
        List<Food> myCollections = collectionService.getMyCollection(cId);
        model.addAttribute("myCollections", myCollections);

        return "collectionList";
    }
}
