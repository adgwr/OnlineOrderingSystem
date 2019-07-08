package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.MenuService;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.FoodBelong;
import com.adgwr.online.ordering.system.mapper.CategoryMapper;
import com.adgwr.online.ordering.system.mapper.FoodBelongMapper;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private FoodBelongMapper foodBelongMapper;

    @Override
    public List<Food> getFoods(String searchContent) {
        searchContent="%"+searchContent+"%";
        Example example=new Example(Food.class);
        example.createCriteria().
                orLike("fdName",searchContent).
                orLike("fdSubname",searchContent);

        List<Food> foods = foodMapper.selectByExample(example);
        return foods;
    }

    @Override
    public List<Food> getAllFoods(List<Integer> foodIds){
        Example example1=new Example(Food.class);
        Example.Criteria criteria = example1.createCriteria();
        for (Integer foodId : foodIds) {
            criteria.orEqualTo("foodId",foodId);
        }
        return foodMapper.selectByExample(example1);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodMapper.selectAll();
    }

    @Override
    public List<Category> getAllCategorys() {
        return categoryMapper.selectAll();
    }

    @Override
    public List<Integer> getFoodBelong(Integer categoryId) {
        Example example=new Example(FoodBelong.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        List<FoodBelong> foodBelongs = foodBelongMapper.selectByExample(example);
        List<Integer> foodIds=new ArrayList<>();
        for (FoodBelong foodBelong : foodBelongs) {
            foodIds.add(foodBelong.getFoodId());
        }
        return foodIds;
    }
}
