package com.hd.dao.Impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hd.dao.BaseDao;

/**
 * Created by Administrator on 2016/4/1.
 */
@Repository("baseDao")
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
	@Autowired
	private SessionFactory sessionFactory;

	

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// 保存
	public Serializable save(T o) {
		return getCurrentSession().save(o);
	}

	// 批量保存
	@Override
	public void save(Collection<T> o) {
		Iterator<T> it = o.iterator();
		while (it.hasNext()) {
			getCurrentSession().save(it.next());
		}
	}

	// 删除
	public void delete(T o) {
		getCurrentSession().delete(o);
	}

	// 通过ID删除一条记录
	@Override
	public void delete(Class<T> clazz, PK id) {
		T o = get(clazz, id);
		getCurrentSession().delete(o);
	}

	// 批量删除
	@Override
	public void deleteBatch(Collection<T> o) {
		Iterator<T> it = o.iterator();
		while (it.hasNext()) {
			delete(it.next());
		}
	}

	// 通过id批量删除
	@Override
	public void deleteBatch2(Class<T> clazz, Collection<PK> ids) {
		Iterator<PK> it = ids.iterator();
		while (it.hasNext()) {
			T o = get(clazz, it.next());
			delete(o);
		}
	}

	// 更新
	public void update(T o) {
		getCurrentSession().update(o);
	}

	// 更新或保存
	public void saveOrUpdate(T o) {
		getCurrentSession().saveOrUpdate(o);
	}

	// get方法查询
	public T get(Class<T> clazz, PK id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	// load方法查询
	public T load(Class<T> clazz, PK id) {
		return (T) getCurrentSession().load(clazz, id);
	}

	// 带参查询一条数据
	public T get(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	// 查询
	public List<T> find(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return q.list();
	}

	// 带参查询
	public List<T> find(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return q.list();
	}

	// 查询所有记录数
	public Long count(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return (long) q.list().size();
	}

	// 带参查询所有记录数
	public Long count(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return (long) q.list().size();
	}

	// 分页,page：当前页，rows:分页大小
	public List<T> find(String hql, int page, int rows) {
		Query q = getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	// 带参分页，page：当前页，rows:分页大小
	public List<T> find(String hql, int page, int rows, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	// 执行更新、删除、修改等语句
	@Override
	public Object execute(String hql, Object... params) {
		Query q = getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return q.executeUpdate();
	}

	@Override
	public List<T> findBySQL(Class<T>clazz,String sql, Object... params) {
		SQLQuery sq=getCurrentSession().createSQLQuery(sql);
		for (int i = 0; i < params.length; i++) {
			sq.setParameter(i, params[i]);
		}
		 sq.addEntity(clazz);
		 List<T>list=sq.list();
		 return list;
	}

}
