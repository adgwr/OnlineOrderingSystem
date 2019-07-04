package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CollectionService;

import com.adgwr.online.ordering.system.domain.Collections;
import com.adgwr.online.ordering.system.mapper.CollectionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional(readOnly = false)
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionsMapper collectionsMapper;

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

        collectionsMapper.delete(collections);
    }

    @Override
    public List<Collections> getMyCollection(String cId) {
        Example example=new Example(Collections.class);
        example.createCriteria().andEqualTo("cId",cId);
        List<Collections> myCollections = collectionsMapper.selectByExample(example);
        return myCollections;
    }
}
