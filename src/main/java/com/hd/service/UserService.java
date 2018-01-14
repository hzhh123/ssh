package com.hd.service;


import java.io.Serializable;
import java.util.Set;

import com.hd.entity.User;

/**
 * Created by Administrator on 2016/4/2.
 */
public interface UserService {
    //保存用户
    Serializable save(User user);
    void save(Set<User> users);
    //更新
    void update(User user);
    //通过id查询用户
    User getUser(Integer id);
    User getUserById(Integer id);
    //删除
    void delete(Integer id);
    User getUserByUsernameAndPassword(User user);
}
