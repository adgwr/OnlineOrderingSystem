package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;

import java.util.List;

/**
 * @author Administrator
 */
public interface CustomerService{
    boolean register(String username,String password,String email);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    Customer login(String username, String password);

    boolean updatePassword(Customer customer,String password);

    boolean editCustomer(Customer customer,String tel,String email);

    List<Food> getFoods(String searchContent);

    List<Food> getAllFoods();

    List<Food> getFoodsByCategoty(int categoryId);

    List<Category> getAllCategorys();

    Food getFoodById(int foodId);
}
