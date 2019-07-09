package com.adgwr.online.ordering.system.admin.service;

import com.adgwr.online.ordering.system.domain.FoodBelong;

import java.util.List;

public interface FoodBelongService {

    /**
     * 添加食物和类别之家的关联
     * @param foodId
     * @param categoryId
     */
    void addFoodBelong(int foodId, int categoryId);

    /**
     * 删除food和category之间的关系
     * @param foodId
     */
    void deleteFoodBelong(int foodId);

    /**
     * 修改food和category之间的关系
     * @param foodId
     * @param categoryId
     */
    void updateFoodBelong(int foodId, int categoryId);

    /**
     * 根据foodId查找对应关系
     * @param foodId
     * @return
     */
    List<FoodBelong> getFoodBelong(int foodId);

    /**
     * 获取所有的FoodBelong记录
     * @return
     */
    List<FoodBelong> getALL();
}
