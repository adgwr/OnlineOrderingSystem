package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.Lineitem;
import tk.mybatis.MyMapper;

import java.util.List;

public interface LineitemMapper extends MyMapper<Lineitem> {
    List<Lineitem> getLineItemByFoodId(int foodId);
}