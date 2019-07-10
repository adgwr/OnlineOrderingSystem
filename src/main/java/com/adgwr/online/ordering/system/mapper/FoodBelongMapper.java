package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.FoodBelong;
import tk.mybatis.MyMapper;

import java.util.List;

public interface FoodBelongMapper extends MyMapper<FoodBelong> {
    List<FoodBelong> selectFoodBelongByFoodId(int foodId);
}