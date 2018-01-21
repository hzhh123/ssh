package com.hd.service;

import com.hd.entity.Type;

/**
*@author hzhh123
*@time 2018年1月16日上午9:43:25 
**/
public interface TypeService {
	void save(Type type);
	void delete(Integer id);
	Type  get(Integer id);
}
