package com.adgwr.online.ordering.system.admin.service.impl;

import com.adgwr.online.ordering.system.admin.service.SalesService;
import com.adgwr.online.ordering.system.domain.Lineitem;
import com.adgwr.online.ordering.system.mapper.LineitemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author rch/dev
 */
@Service
@Transactional(readOnly = false)
public class SalesServiceImpl implements SalesService {

    @Autowired
    private LineitemMapper lineitemMapper;

    @Override
    public List<Lineitem> getLineItemByFoodId(int foodId) {
        return lineitemMapper.getLineItemByFoodId(foodId);
    }

    @Override
    public List<Lineitem> getAllLineItem() {
        return lineitemMapper.selectAll();
    }
}
