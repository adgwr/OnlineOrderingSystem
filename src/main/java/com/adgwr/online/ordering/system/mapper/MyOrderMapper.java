package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.MyOrder;
import tk.mybatis.MyMapper;

import java.util.List;

public interface MyOrderMapper extends MyMapper<MyOrder> {
    List<MyOrder> selectByState(String orderState);
}