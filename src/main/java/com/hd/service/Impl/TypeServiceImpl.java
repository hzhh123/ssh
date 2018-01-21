package com.hd.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.dao.BaseDao;
import com.hd.entity.Type;
import com.hd.service.TypeService;

/**
*@author hzhh123
*@time 2018年1月16日上午9:44:30 
**/
@Service("typeService")
public class TypeServiceImpl implements TypeService{
	@Autowired
	private BaseDao<Type,Integer>typeDao;

	@Override
	public void save(Type type) {
		typeDao.save(type);
	}

	@Override
	public void delete(Integer id) {
		Type type=get(id);
		typeDao.delete(type);
	}

	@Override
	public Type get(Integer id) {
		return typeDao.get(Type.class,id);
	}

}
