package com.hd.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {

	// 保存
	Serializable save(T o);

	// 批量保存
	void save(Collection<T> o);

	// 删除
	void delete(T o);

	// 根据ID删除
	void delete(Class<T> clazz, PK id);

	// 批量删除
	void deleteBatch(Collection<T> o);

	// 批量删除
	void deleteBatch2(Class<T> clazz, Collection<PK> ids);

	// 更新
	void update(T o);

	// 保存或更新
	void saveOrUpdate(T o);

	// 带参查询一条记录
	T get(String hql, Object... params);

	// get方式查询
	T get(Class<T> clazz, PK id);

	// load方式查询
	T load(Class<T> clazz, PK id);

	// 查询
	List<T> find(String hql);

	// 带参查询
	List<T> find(String hql, Object... params);

	// 分页查询
	List<T> findPage(String hql, int page, int rows);

	// 带参分页查询
	List<T> findPageByObject(String hql, int page, int rows, Object... params);

	// 查询总记录数
	Long count(String hql);

	// 带参查询总记录数
	Long count(String hql, Object... params);

	// 执行更新、删除、修改等语句
	Object execute(String hql, Object... params);
	//使用原生sql查询
	List<T> findBySQL(Class<T>clazz,String sql,Object...params);
	
}
