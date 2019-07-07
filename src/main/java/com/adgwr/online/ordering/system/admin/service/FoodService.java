package com.adgwr.online.ordering.system.admin.service;

import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public interface FoodService {


    /**
     * 增加菜品
     * @param foodName
     * @param subName
     * @param foodImage
     * @param foodPrice
     * @param foodDescription
     */
    void addFood(String foodName, String subName, String foodImage, BigDecimal foodPrice, String foodDescription);

    /**
     * 删除菜品
     * @param foodId
     */
    void deleteFood(int foodId);

    /**
     * 修改菜品
     * @param foodName
     * @param subName
     * @param foodImage
     * @param foodPrice
     * @param foodDescription
     */
    void updateFood(Food food);


    /**
     * 浏览菜品
     * @param foodId
     */
    Food getFoodById(int foodId);

    /**
     * 获取所有的食物
     * @return
     */
    List<Food> getAllFood();
}
