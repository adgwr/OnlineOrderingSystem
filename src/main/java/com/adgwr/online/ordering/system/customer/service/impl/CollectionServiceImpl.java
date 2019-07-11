package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CollectionService;

import com.adgwr.online.ordering.system.domain.Collections;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.CollectionsMapper;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(readOnly = false)
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionsMapper collectionsMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public void addFood(int foodId, String cId) {
        Collections collections = new Collections();
        collections.setcId(cId);
        collections.setFoodId(foodId);

        collectionsMapper.insert(collections);
    }

    @Override
    public void deleteFood(int foodId, String cId) {
        Collections collections = new Collections();
        collections.setcId(cId);
        collections.setFoodId(foodId);

        collectionsMapper.deleteByPrimaryKey(collections);
    }

    @Override
    public List<Food> getMyCollection(String cId) {
        Example example=new Example(Collections.class);
        example.createCriteria().andEqualTo("cId",cId);
        List<Collections> cList = collectionsMapper.selectByExample(example);
        List<Food> myCollections = new ArrayList<>();
        for(Collections c : cList) {
            Food food = foodMapper.selectByPrimaryKey(c.getFoodId());
            myCollections.add(food);
        }
        return myCollections;
    }

    @Override
    public boolean hasCollected(int foodId, String cId) {
        Example example = new Example(Collections.class);
        example.createCriteria().andEqualTo("foodId", foodId).andEqualTo("cId", cId);
        List<Collections> collectionsList = collectionsMapper.selectByExample(example);
        return !collectionsList.isEmpty();
    }


}
