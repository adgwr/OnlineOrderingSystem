package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.AdminAccount;
import tk.mybatis.MyMapper;

import java.util.List;

public interface AdminAccountMapper extends MyMapper<AdminAccount> {
    List<AdminAccount> selectAdminByIsSuper(Byte b);
}