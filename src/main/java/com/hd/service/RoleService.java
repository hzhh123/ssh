package com.hd.service;

import java.util.List;

import com.hd.entity.Resource;
import com.hd.entity.Role;
import com.hd.util.PageInfo;
import com.hd.util.Tree;

/**
*@author hzhh123
*@time 2018年1月15日上午10:30:16 
**/
public interface RoleService {
	 void save(Role role);
	 void delete(Long id);
	 List<Role> findAllByStatus(Integer status);
	 PageInfo findDataGrid(Integer page,Integer limit);
	 Role get(Long id);
	void update(Role role);
	//分配权限
	void addOrEditPermission(Long roleId, String resourceIds);
	List<Resource>findResourceListByRoleId(Long roleId);
	List<Long>selectResourceIdListByRoleId(Long roleId);
	List<Tree> selectTreeByRoleId(Long roleId);
	 
}
