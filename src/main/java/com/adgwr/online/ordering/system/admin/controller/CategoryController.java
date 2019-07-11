package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.CategoryService;
import com.adgwr.online.ordering.system.admin.service.FoodBelongService;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.FoodBelong;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author rch/dev
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodBelongService foodBelongService;

    @RequestMapping(value = "admin/CategoryDisplay", method = RequestMethod.GET)
    public String category(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 3);
        PageHelper.orderBy("category_id asc");

        List<Category> categoryList = categoryService.getAllCategory();

        PageInfo pageInfo = new PageInfo(categoryList, 3);

        model.addAttribute("categoryList", categoryList).addAttribute("pageInfo",pageInfo);
        return "admin/category/categoryDisplay";
    }

    @RequestMapping(value = "admin/category/categoryAdd", method = RequestMethod.GET)
    public String categoryAdd() {
        return "admin/category/categoryAdd";
    }

    @RequestMapping(value = "changeCategoryName", method = RequestMethod.GET)
    public String changeCategoryName(String id, String categoryName, Model model) {
        Category category = categoryService.getCategoryById(Integer.parseInt(id));
        String error;
        //判断菜品名称是否为空
        if(categoryName.equals("")) {
            error = "菜品类别名称不能为空";
            model.addAttribute("error",error);
            return category(1,model);
        }else {
            category.setCategoryName(categoryName);
            categoryService.updateCategory(category);
            return category(1,model);
        }
    }

    @RequestMapping(value = "deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(String id2, Model model) {
        String error;
        List<FoodBelong> foodBelongList = foodBelongService.getALL();
        for(FoodBelong foodBelong:foodBelongList) {
            if(id2.equals(foodBelong.getCategoryId().toString())) {
                error = "该菜品类别有相关菜品实例";
                model.addAttribute("error",error);
                return category(1,model);
            }
        }
        categoryService.deleteCategory(Integer.parseInt(id2));
        category(1,model);
        return "admin/category/categoryDisplay";
    }

    @RequestMapping(value = "addCategory", method = RequestMethod.GET)
    public String addCategory(String categoryName, Model model) {
        String error;
        //判断菜品名称是否为空
        if(categoryName.equals("")) {
            error = "菜品名称不能为空";
            model.addAttribute("error",error);
            return "admin/category/categoryAdd";
        }else {
            //判断菜品名称是否以及存在
            List<Category> categoryList = categoryService.getAllCategory();
            for(Category category:categoryList) {
                if(categoryName.equals(category.getCategoryName())) {
                    error = "此菜品名称已存在";
                    model.addAttribute("error",error);
                    return "admin/category/categoryAdd";
                }
            }
            categoryService.addCategory(categoryName);
            return category(1,model);
        }
    }
}
