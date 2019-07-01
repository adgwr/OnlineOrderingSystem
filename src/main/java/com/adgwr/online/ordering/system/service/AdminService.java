package com.adgwr.online.ordering.system.service;

import com.adgwr.online.ordering.system.domain.AdminAccount;

/**
 * @author Administrator
 */
public interface AdminService {

    void register();

    /**
     * 登录功能
     * @param adTel
     * @param plantPassword
     * @return
     */
    AdminAccount login(String adTel,String plantPassword);

    void logout();
}
