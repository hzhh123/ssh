package com.hd.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.dao.BaseDao;
import com.hd.entity.Organization;
import com.hd.entity.User;
import com.hd.service.OrganizationService;
import com.hd.util.PageInfo;
import com.hd.util.jstree.JsTreeNode;

/**
*@author hzhh123
*@time 2018年1月15日下午5:07:19 
**/
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private BaseDao<Organization,Long>organizationDao;
	@Autowired
	private BaseDao<User,Long>userDao;
	@Override
	public void save(Organization organization) {
		organizationDao.save(organization);
	}
	@Override
	public void delete(Long id) {
		//设置用户机构部门为空
		String hql="update User set organizationId=null where organizationId=?";
		userDao.execute(hql, id);
		organizationDao.delete(Organization.class, id);
	}
	@Override
	public List<JsTreeNode> selectJstree() {
		String hql="from Organization";
		List<Organization>organizations=organizationDao.find(hql);
		List<JsTreeNode>treeList=new ArrayList<JsTreeNode>();
		if(organizations!=null){
			for (Organization organization:organizations){
				JsTreeNode node=new JsTreeNode();
				node.setId(organization.getId().toString());
				node.setIcon("fa fa-sitemap blue");
				node.setParent(organization.getPid()==null?"#":organization.getPid().toString());
				node.setText(organization.getOrgname());
				treeList.add(node);
			}
		}
		return treeList;
	}
	@Override
	public Organization get(Long id) {
		return organizationDao.get(Organization.class, id);
	}
	@Override
	public void deleteBatch(String ids) {
		if(!ids.trim().equals("")) {
			List<Long>idList=new ArrayList<Long>();
			String[] ids_=ids.split(",");
			for(String id:ids_) {
				String hql="update User set organizationId=null where organizationId=?";
				userDao.execute(hql, Long.valueOf(id));
				idList.add(Long.valueOf(id));
			}
			organizationDao.deleteBatch2(Organization.class,idList);
		}
	}
	@Override
	public void update(Organization organization) {
		organizationDao.update(organization);
	}
	@Override
	public PageInfo findDataGrid(Integer page, Integer limit, String orgname,String id) {
		PageInfo info=new PageInfo(page,limit);
		List<Organization>organizations=new ArrayList<Organization>();
		String hql="from Organization where 1=1";
		if(orgname!=null&&!orgname.equals("")) {
			hql+=" and orgname like '%"+orgname+"%'";
		}
		if(id!=null&&!id.equals("")) {
			hql+=" and id="+Long.valueOf(id);
		}
		organizations=organizationDao.findPage(hql, page, limit);
		for(Organization organization:organizations) {
			if(organization.getPid()!=null) {
				Organization vo=get(organization.getPid());
				organization.setParentName(vo.getOrgname());
			}
		}
		info.setData(organizations);
		int count=organizationDao.find(hql).size();
		info.setCount(count);
		return info;
	}
	@Override
	public List<Organization> findAll() {
		String hql="from Organization";
		return organizationDao.find(hql);
	}

}
