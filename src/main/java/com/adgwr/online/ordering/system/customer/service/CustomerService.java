package com.adgwr.online.ordering.system.customer.service;

import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;

/**
 * @author Administrator
 */
public interface CustomerService {
    void register();

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    Customer login(String username, String password);

    void logout();
}
