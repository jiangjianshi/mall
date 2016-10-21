package com.mall.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.mapper.EmUserMapper;
import com.mall.model.EmUser;
import com.mall.service.EmUserService;

@Service("emUserService")
class EmUserServiceImpl implements EmUserService {

	@Resource
	EmUserMapper emUserMapper;

	@Override
	public int add(EmUser vo) {
		return emUserMapper.insert(vo);
	}

	@Override
	public EmUser get(Integer id) {
		return emUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public EmUser selectForLogin(String accout, String pwd) {
		return emUserMapper.selectForLogin(accout, pwd);
	}

}
