package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;

import java.util.List;

/**
 * @author Administrator
 */
public interface CustomerService {
    boolean register(String username,String password,String email);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    Customer login(String username, String password);

    void logout();

    List<Food> getFoods(String searchContent);

    List<Food> getAllFoods();

    List<Category> getAllCategorys();
}
