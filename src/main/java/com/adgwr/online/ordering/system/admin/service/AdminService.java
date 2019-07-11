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
    AdminAccount login(String username, String password);

    void logout();

    /**
     * 获取账户列表
     * @return
     */
    List<AdminAccount> getAllAdmin();

    /**
     * 获取账户列表
     * @return
     */
    List<AdminAccount> getAdminByIsSuper(Byte b);

    /**
     * 删除管理员账号
     * @param adminId
     */
    void deleteAdmin(String adminId);

    /**
     * 修改账户
     * @param adminId
     * @param adminPassword
     * @param adminTel
     */
    void editAdminAccount(String adminId, String adminPassword, String adminTel);

    /**
     * 根据管理员id查询账户
     * @param adminId
     * @return
     */
    AdminAccount getAdminById(String adminId);

    /**
     *
     * @param adminId
     * @param tel
     * @param password
     * @return
     */
    boolean register(String adminId, String tel, String password);

    /**
     * 更新管理员
     * @param adminAccount
     */
    void updateAdmin(AdminAccount adminAccount);

    /**
     * 根据用户名查找管理员账号
     * @param adminName
     * @return
     */
    List<AdminAccount> getAdminByName(String adminName);

}
