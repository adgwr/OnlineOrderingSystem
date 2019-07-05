package com.adgwr.online.ordering.system.admin.service;

import com.adgwr.online.ordering.system.domain.AdminAccount;

import java.util.List;

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

    List<AdminAccount> getAllAdmin();

    /**
     * 删除管理员账号
     * @param adminId
     */
    void deleteAdmin(String adminId);
}
