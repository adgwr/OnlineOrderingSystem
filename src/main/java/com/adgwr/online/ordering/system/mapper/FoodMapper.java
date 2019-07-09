package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.Food;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface FoodMapper extends MyMapper<Food> {
    List<Food> foodSearchByName(String foodName);
}