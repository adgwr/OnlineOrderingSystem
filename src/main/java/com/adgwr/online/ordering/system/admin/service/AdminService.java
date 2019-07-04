package com.adgwr.online.ordering.system.admin.service;

import com.adgwr.online.ordering.system.domain.AdminAccount;

/**
 * @author Administrator
 */
public interface AdminService {

    void register();

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    AdminAccount login(String username,String password);

    void logout();
}
