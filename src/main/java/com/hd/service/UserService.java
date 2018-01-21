package com.hd.service;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.util.PageInfo;
import com.hd.util.TreeNode;

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
    User getUser(Long id);
    User getUserById(Long id);
    //删除
    void delete(Long id);
    User getUserByUsernameAndPassword(User user);
    
    //添加用户-角色
    void saveUserRole(String roleList,Long userid);
    //获取菜单
    List<TreeNode>getResourceByUserid(Long userid,Integer resourceType);
    
    PageInfo findDataGrid(Integer page,Integer limit,String name,String organizationId,String phone);
	void deleteBatch(String ids);
	//获取用户关联角色
	List<Role> getRoles(Long id);
	List<User> findOfProject();
	
	
}
