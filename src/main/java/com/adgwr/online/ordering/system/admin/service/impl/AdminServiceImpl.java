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
        /*Example example=new Example(AdminAccount.class);
        example.createCriteria().andEqualTo("adminId",adminId);*/
        //从数据查询
        //AdminAccount adminAccount = nAccountMapper.selectOneByExample(example);
        AdminAccount adminAccount = new AdminAccount();
        adminAccount.setAdminId(adminId);
        adminAccountMapper.deleteByPrimaryKey(adminAccount);
        return;
    }
}
