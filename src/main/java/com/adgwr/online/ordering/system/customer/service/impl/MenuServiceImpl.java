package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.MenuService;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getFoods(String searchContent) {
        searchContent="%"+searchContent+"%";
        Example example=new Example(Food.class);
        example.createCriteria().
                orLike("fdName",searchContent).
                orLike("fdSubname",searchContent);

        List<Food> foods = foodMapper.selectByExample(example);
        return foods;
    }
}
