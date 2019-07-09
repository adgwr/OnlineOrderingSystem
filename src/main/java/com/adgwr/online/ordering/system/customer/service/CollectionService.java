package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Collections;
import com.adgwr.online.ordering.system.domain.Food;

import java.util.List;

/**
 * 收藏菜品Service
 *
 * @author lyc
 * @version 1.0
 */
public interface CollectionService {

    /**
     * 收藏菜品
     *
     * @param foodId 菜品id
     * @param cId 客户id
     */
    void addFood(int foodId, String cId);

    /**
     * 取消收藏
     *
     * @param foodId 菜品id
     * @param cId 客户id
     */
    void deleteFood(int foodId, String cId);

    /**
     * 返回客户收藏的所有菜品
     *
     * @param cId 客户id
     * @return 菜品列表
     */
    List<Food> getMyCollection(String cId);

    /**
     * 判断客户是否收藏了某一菜品
     *
     * @param foodId  菜品id
     * @param cId 客户id
     * @return boolean
     */
    boolean hasCollected(int foodId, String cId);
}
