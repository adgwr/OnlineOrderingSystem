package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Collections;
import com.adgwr.online.ordering.system.domain.Food;

import java.util.List;

public interface CollectionService {

    /**
     * 收藏菜品
     *
     * @param foodId
     * @param cId
     */
    void addFood(int foodId, String cId);

    /**
     * 取消收藏
     *
     * @param foodId
     * @param cId
     */
    void deleteFood(int foodId, String cId);

    /**
     * 返回客户收藏的所有菜品
     *
     * @param cId
     * @return
     */
    List<Collections> getMyCollection(String cId);
}
