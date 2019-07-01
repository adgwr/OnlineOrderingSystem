package com.adgwr.online.ordering.system.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Administrator
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}