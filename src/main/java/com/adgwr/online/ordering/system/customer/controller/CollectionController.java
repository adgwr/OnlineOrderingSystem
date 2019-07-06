package com.adgwr.online.ordering.system.customer.controller;

import com.adgwr.online.ordering.system.customer.service.CollectionService;
import com.adgwr.online.ordering.system.domain.Customer;
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
    public void addCollection(@RequestParam("foodId")Integer foodId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        collectionService.addFood(foodId, cId);
    }

    @RequestMapping(value = "deleteCollection", method = RequestMethod.POST)
    public String deleteCollection(@RequestParam("foodId")Integer foodId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        collectionService.deleteFood(foodId, cId);
        return "getCollections";
    }

    @RequestMapping(value = "getCollections", method = RequestMethod.GET)
    public String getCollections(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 Model model) {
        HttpSession session = request.getSession();
        String cId = ((Customer)session.getAttribute("customer")).getcId();
        List<Food> myCollections = collectionService.getMyCollection(cId);
        // 每一页的菜品数量
        final int ITEM_PER_PAGE = 8;
        int startPos = (pn - 1) * ITEM_PER_PAGE, endPos = startPos + ITEM_PER_PAGE > myCollections.size() ? myCollections.size() : startPos + ITEM_PER_PAGE;
        List<Food> currentpages = myCollections.subList(startPos, endPos);
        int totalPages = myCollections.size() / ITEM_PER_PAGE;
        if(totalPages * ITEM_PER_PAGE < myCollections.size()) {
            totalPages++;
        }
        int startPage = (pn-1)/5*5+1;
        int endPage = Math.min(startPage+4,totalPages);
        model.addAttribute("hasStart",startPage != 1);
        model.addAttribute("hasEnd",endPage != totalPages);
        model.addAttribute("currentPage",pn);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        model.addAttribute("foods", currentpages);

        return "collectionList";
    }
}
