package com.adgwr.online.ordering.system.admin.service;

import com.adgwr.online.ordering.system.domain.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 添加菜品类别
     * @param categoryId
     * @param categoryName
     */
    void addCategory(String categoryName);

    /**
     * 根据categoryId删除菜品类别
     * @param categoryId
     */
    void deleteCategory(int categoryId);

    /**
     * 更新菜品类别
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 根据categoryId查找菜品类别
     * @param categoryId
     * @return
     */
    Category getCategoryById(int categoryId);

    /**
     * 获取所有的类别
     * @return
     */
    List<Category> getAllCategory();
}
