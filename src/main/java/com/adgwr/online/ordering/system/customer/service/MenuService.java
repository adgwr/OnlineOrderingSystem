package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Food;

import java.util.List;

/**
 * @author Administrator
 */
public interface MenuService {

    List<Food> getFoods(String searchContent);

    List<Food> getAllFoods(List<Integer> foodIds);

    List<Food> getAllFoods();

    List<Category> getAllCategorys();

    List<Integer> getFoodBelong(Integer categoryId);
}
