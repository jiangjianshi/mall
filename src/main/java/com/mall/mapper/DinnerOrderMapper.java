package com.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.model.DinnerOrder;

public interface DinnerOrderMapper {

	public List<DinnerOrder> listByPage();

	public DinnerOrder get(@Param("id") Long id);

	public int add(@Param("vo") DinnerOrder vo);

	public int update(@Param("vo") DinnerOrder vo);

	public int delete(@Param("id") Long id);
}
