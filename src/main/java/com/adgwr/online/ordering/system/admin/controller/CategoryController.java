package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.CategoryService;
import com.adgwr.online.ordering.system.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author rch/dev
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "admin/CategoryDisplay", method = RequestMethod.GET)
    public String category(Model model) {
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "admin/category/categoryDisplay";
    }

    @RequestMapping(value = "admin/category/categoryAdd", method = RequestMethod.GET)
    public String categoryAdd() {
        return "admin/category/categoryAdd";
    }

    @RequestMapping(value = "changeCategoryName", method = RequestMethod.GET)
    public String changeCategoryName(String id, String categoryName, Model model) {
        Category category = categoryService.getCategoryById(Integer.parseInt(id));
        category.setCategoryName(categoryName);
        categoryService.updateCategory(category);
        return category(model);
    }

    @RequestMapping(value = "deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(String id2, Model model) {
        categoryService.deleteCategory(Integer.parseInt(id2));
        category(model);
        return "admin/category/categoryDisplay";
    }

    @RequestMapping(value = "addCategory", method = RequestMethod.GET)
    public String addCategory(String categoryName, Model model) {
        categoryService.addCategory(categoryName);
        return category(model);
    }
}
