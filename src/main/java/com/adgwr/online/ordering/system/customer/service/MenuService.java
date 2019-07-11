package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.Food;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
public interface MenuService {

    List<Food> getFoods(String searchContent);
}
