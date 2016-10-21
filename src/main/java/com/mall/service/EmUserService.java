package com.mall.service;

import com.mall.model.EmUser;

public interface EmUserService {
	
	int add(EmUser vo);
	
	EmUser get(Integer id);
	
	EmUser selectForLogin(String accout, String pwd);
}
