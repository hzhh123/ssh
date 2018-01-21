package com.hd.service;

import java.util.List;

import com.hd.entity.Organization;
import com.hd.util.PageInfo;
import com.hd.util.jstree.JsTreeNode;

/**
*@author hzhh123
*@time 2018年1月15日下午5:06:23 
**/
public interface OrganizationService {
	 void save(Organization organization);
	 void delete(Long id);
	 void deleteBatch(String ids);
	 void update(Organization organization);
	 List<JsTreeNode> selectJstree();
	 Organization get(Long id);
	 PageInfo findDataGrid(Integer page,Integer limit,String orgname,String id);
	 List<Organization>findAll();
}
