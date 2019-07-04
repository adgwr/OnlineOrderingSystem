package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.mapper.CustomerMapper;
import com.adgwr.online.ordering.system.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FoodMapper foodMapper;


    @Override
    @Transactional(readOnly = false)
    public boolean register(String username, String email, String password) {
        Example example = new Example(Customer.class);
        example.createCriteria().andEqualTo("cId", username);
        List<Customer> customers = customerMapper.selectByExample(example);
        //判断用户名是否存在
        if (customers.size() != 0) {
            return false;
        }
        //注册成功，向数据库插入数据
        else {
            Customer customer = new Customer(username, null, password, email);
            customerMapper.insert(customer);
            return true;
        }
    }

    @Override
    public Customer login(String username, String password) {

        Example example = new Example(Customer.class);
        example.createCriteria().andEqualTo("cId", username);
        Customer customer = customerMapper.selectOneByExample(example);
        if (customer != null) {
            //MD5加密
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (password.equals(customer.getcPassword())) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public List<Food> getFoods(String searchContent) {
        String keyword="%"+searchContent+"%";
        Example example=new Example(Food.class);
        example.createCriteria().orEqualTo("fdName",keyword).orEqualTo("fdSubname",keyword);

        List<Food> foods = foodMapper.selectByExample(example);
        return foods;
    }
}
