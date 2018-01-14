package com.hd.service.Impl;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.dao.BaseDao;
import com.hd.entity.User;
import com.hd.service.UserService;

/**
 * Created by Administrator on 2016/4/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private BaseDao<User,Integer> baseDao;
    //保存用户
    public Serializable save(User user) {
        return baseDao.save(user);
    }

    public User getUser(Integer id) {
        String hql="select u from User u where u.id=?";
        return baseDao.get(hql,id);
    }

    public User getUserById(Integer id){
        return baseDao.get(User.class,id);
    }

    public void delete(Integer id) {
        baseDao.delete(User.class,id);
    }
    
    @Override
	public void save(Set<User> users) {
		// TODO Auto-generated method stub
		 baseDao.save(users);
	}

	@Override
	public void update(User user) {
		baseDao.update(user);
	}

	@Override
	public User getUserByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String hql="from User where username=? and password=?";
		return baseDao.get(hql, user.getUsername(),user.getPassword());
	}
}
