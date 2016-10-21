package com.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.model.TeamUser;

public interface TeamUserMapper {

	public List<TeamUser> listByPage();

	public TeamUser get(@Param("id") Long id);

}
