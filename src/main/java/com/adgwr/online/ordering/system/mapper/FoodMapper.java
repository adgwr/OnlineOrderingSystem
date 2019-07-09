package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.Food;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.MyMapper;

public interface FoodMapper extends MyMapper<Food> {
}