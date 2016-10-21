package com.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.model.Dept;

public interface DeptMapper {

	public List<Dept> listByPage();

	public Dept get(@Param("id") Long id);

	public int add(@Param("vo") Dept vo);

	public int update(@Param("vo") Dept vo);

	public int delete(@Param("id") Long id);
}
