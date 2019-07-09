package com.adgwr.online.ordering.system.mapper;

import com.adgwr.online.ordering.system.domain.Customer;
import com.adgwr.online.ordering.system.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.MyMapper;

@CacheNamespace(implementation = RedisCache.class)
public interface CustomerMapper extends MyMapper<Customer> {
}