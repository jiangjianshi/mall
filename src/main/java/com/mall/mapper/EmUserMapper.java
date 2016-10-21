package com.mall.mapper;

import org.apache.ibatis.annotations.Param;

import com.mall.model.EmUser;

public interface EmUserMapper {

	int deleteByPrimaryKey(@Param(value = "id") Integer id);

	int insert(EmUser emUser);

	EmUser selectByPrimaryKey(Integer id);

	EmUser selectForLogin(@Param(value = "account") String account, @Param(value = "pwd") String pwd);

	int updateByPrimaryKey(EmUser emUser);

}
