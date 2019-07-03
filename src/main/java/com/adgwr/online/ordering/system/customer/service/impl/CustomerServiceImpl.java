package com.adgwr.online.ordering.system.customer.service.impl;

import com.adgwr.online.ordering.system.customer.service.CustomerService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Administrator
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void register() {

    }

    @Override
    public Customer login(String username, String password) {
        Example example=new Example(Customer.class);
        example.createCriteria().andEqualTo("cId",username);
        Customer customer = customerMapper.selectOneByExample(example);
        if(customer!=null){
            //MD5加密
            password= DigestUtils.md5DigestAsHex(password.getBytes());
            if(password.equals(customer.getcPassword())){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void logout() {

    }
}
