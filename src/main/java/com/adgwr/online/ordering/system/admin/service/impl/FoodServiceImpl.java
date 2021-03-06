package com.adgwr.online.ordering.system.admin.service.impl;

import com.adgwr.online.ordering.system.admin.service.FoodService;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


import java.math.BigDecimal;
import java.util.List;


/**
 * @Author wyun
 */
@Service
@Transactional(readOnly = false)
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public void addFood(String foodName, String subName, String foodImage, BigDecimal foodPrice, String foodDescription ){
            Food food1 = new Food();
            food1.setFdName(foodName);
            food1.setFdSubname(subName);
            food1.setFdImage(foodImage);
            food1.setFdPrice(foodPrice);
            food1.setFdDescription(foodDescription);
            foodMapper.insert(food1);

    }

    /**
     * 删除food只是将属性isshow设置为0， 不展示
     * @param foodId
     */
    @Override
    public void deleteFood(int foodId){
        Food f = new Food();
        f.setFoodId(foodId);
        byte b = 0;
        f.setIsshow(b);
        foodMapper.updateByPrimaryKeySelective(f);

//        foodMapper.deleteByPrimaryKey(foodId);
    }

    @Override
    public void updateFood(Food food){
        foodMapper.updateByPrimaryKey(food);
    }

    @Override
    public Food getFoodById(int foodId){
        Example example=new Example(Food.class);
        example.createCriteria().andEqualTo("foodId",foodId);
        //从数据查询
        Food food = foodMapper.selectOneByExample(example);
        return food;
    }

    @Override
    public List<Food> getAllFood(){
        Example example = new Example(Food.class);
        byte b = 1;
        example.createCriteria().andEqualTo("isshow", b);
        return foodMapper.selectByExample(example);
    }

    @Override
    public List<Food> getFoodByName(String foodName){
        foodName = "%" + foodName + "%";
        Example example = new Example(Food.class);
        example.createCriteria().orLike("fdName",foodName).orLike("fdSubname",foodName);
        List<Food> foods = foodMapper.selectByExample(example);
        return foods;
//        return foodMapper.foodSearchByName(foodName);
    }
}
