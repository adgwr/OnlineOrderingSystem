package com.adgwr.online.ordering.system.admin.service.impl;

import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.mapper.AdminAccountMapper;
import com.adgwr.online.ordering.system.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminAccountMapper adminAccountMapper;

    @Override
    public void register() {

    }

    @Override
    public AdminAccount login(String adTel, String plantPassword) {

        Example example=new Example(AdminAccount.class);
        example.createCriteria().andEqualTo("adTel",adTel);

        AdminAccount adminAccount = adminAccountMapper.selectOneByExample(example);
        if(adminAccount!=null){
            String password= DigestUtils.md5DigestAsHex(plantPassword.getBytes());
            if(password.equals(adminAccount.getPassword())){
                return adminAccount;
            }
        }

        return null;
    }

    @Override
    public void logout() {

    }
}
