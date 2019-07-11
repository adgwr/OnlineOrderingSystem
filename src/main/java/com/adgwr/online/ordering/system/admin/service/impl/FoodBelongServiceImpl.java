package com.adgwr.online.ordering.system.admin.service.impl;

import com.adgwr.online.ordering.system.admin.service.FoodBelongService;
import com.adgwr.online.ordering.system.domain.FoodBelong;
import com.adgwr.online.ordering.system.mapper.FoodBelongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Tracy
 */
@Service
@Transactional(readOnly = false)
public class FoodBelongServiceImpl implements FoodBelongService {
    @Autowired
    private FoodBelongMapper foodBelongMapper;

    @Override
    public void addFoodBelong(int foodId, int categoryId){
        FoodBelong foodBelong = new FoodBelong();
        foodBelong.setFoodId(foodId);
        foodBelong.setCategoryId(categoryId);
        foodBelongMapper.insertSelective(foodBelong);
    }

    @Override
    public void deleteFoodBelong(int foodId){
        List<FoodBelong> deleteFoodBelongList = getFoodBelong(foodId);
        for(FoodBelong fd : deleteFoodBelongList) {
            foodBelongMapper.delete(fd);
        }
    }

    @Override
    public void updateFoodBelong(int foodId, int categoryId){
        deleteFoodBelong(foodId);
        FoodBelong foodBelong = new FoodBelong();
        foodBelong.setFoodId(foodId);
        foodBelong.setCategoryId(categoryId);
        foodBelongMapper.insertSelective(foodBelong);
    }

    @Override
    public List<FoodBelong> getFoodBelong(int foodId){
        return foodBelongMapper.selectFoodBelongByFoodId(foodId);
    }

    @Override
    public List<FoodBelong> getALL() {
        return foodBelongMapper.selectAll();
    }
}
