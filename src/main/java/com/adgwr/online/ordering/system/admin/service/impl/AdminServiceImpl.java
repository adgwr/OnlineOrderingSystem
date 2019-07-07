package com.adgwr.online.ordering.system.admin.service.impl;

import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.mapper.AdminAccountMapper;
import com.adgwr.online.ordering.system.admin.service.AdminService;
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
@Transactional(readOnly = false)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminAccountMapper adminAccountMapper;

    @Override
    public void register() {

    }

    @Override
    public AdminAccount login(String username, String password) {
        Example example=new Example(AdminAccount.class);
        example.createCriteria().andEqualTo("adminId",username);
        //从数据查询
        AdminAccount adminAccount = adminAccountMapper.selectOneByExample(example);
        if(adminAccount!=null){
            //MD5加密
            password= DigestUtils.md5DigestAsHex(password.getBytes());
            if(password.equals(adminAccount.getPassword())){
                return adminAccount;
            }
        }
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public List<AdminAccount> getAllAdmin() {
        return adminAccountMapper.selectAll();
    }

    @Override
    public void deleteAdmin(String adminId){
        Example example=new Example(AdminAccount.class);
        example.createCriteria().andEqualTo("adminId",adminId);
        //从数据查询
        AdminAccount adminAccount = adminAccountMapper.selectOneByExample(example);
        //删除
        adminAccountMapper.delete(adminAccount);
        return;
    }

    @Override
    public void editAdminAccount(String adminId, String adminPassword, String adminTel){

        Example example=new Example(AdminAccount.class);
        example.createCriteria().andEqualTo("adminId",adminId);
        //从数据查询
        AdminAccount adminAccount = adminAccountMapper.selectOneByExample(example);
        if(adminPassword != null)adminAccount.setPassword(DigestUtils.md5DigestAsHex(adminPassword.getBytes()));
        if(adminTel != null)adminAccount.setAdTel(adminTel);
        adminAccountMapper.updateByPrimaryKey(adminAccount);
    }

    @Override
    public AdminAccount getAdminById(String adminId){
        Example example=new Example(AdminAccount.class);
        example.createCriteria().andEqualTo("adminId",adminId);
        //从数据查询
        AdminAccount adminAccount = adminAccountMapper.selectOneByExample(example);
        return adminAccount;
    }

    /**
     * 注册新管理员账号
     * @param adminId
     * @param tel
     * @param password
     */
    @Override
    @Transactional(readOnly = false)
    public boolean register(String adminId, String tel, String password) {
        Example example = new Example(AdminAccount.class);
        example.createCriteria().andEqualTo("adminId", adminId);
        AdminAccount adminAccount = adminAccountMapper.selectOneByExample(example);
        //判断用户名是否存在
        if (adminAccount != null) {
            return false;
        }
        //注册成功，向数据库插入数据
        else {
            AdminAccount adminAccount1 = new AdminAccount();
            adminAccount1.setAdminId(adminId);
            adminAccount1.setAdTel(tel);
            //密码MD5加密再存入数据库
            password= DigestUtils.md5DigestAsHex(password.getBytes());
            adminAccount1.setPassword(password);
            //新注册的账号不是超级管理员
            byte s = 0;
            adminAccount1.setIssuper(s);
            adminAccountMapper.insert(adminAccount1);
            return true;
        }
    }

    @Override
    public void updateAdmin( AdminAccount adminAccount) {
        adminAccountMapper.updateByPrimaryKey(adminAccount);
    }

}
