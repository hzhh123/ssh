package com.hd.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.dao.BaseDao;
import com.hd.entity.Project;
import com.hd.service.ProjectService;
import com.hd.util.PageInfo;

/**
*@author hzhh123
*@time 2018年1月16日上午9:29:43 
**/
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private BaseDao<Project,Long>projectDao;
	@Override
	public Project get(Long id) {
		// TODO Auto-generated method stub
		return projectDao.get(Project.class, id);
	}

	@Override
	public void save(Project project) {
		projectDao.save(project);
	}

	@Override
	public void delete(Long id) {
		projectDao.delete(Project.class,id);
	}

	@Override
	public PageInfo findDataGrid(Integer page, Integer limit, String name, String projectNo) {
		PageInfo info=new PageInfo(page,limit);
		List<Project>projects=new ArrayList<Project>();
		String hql="from Project where 1=1";
		if(name!=null&&!name.equals("")) {
			hql+=" and name like '%"+name+"%'";
		}
		if(projectNo!=null&&!projectNo.equals("")) {
			hql+=" and projectNo='"+projectNo+"'";
		}
		projects=projectDao.findPage(hql, page, limit);
		info.setData(projects);
		int count=projectDao.find(hql).size();
		info.setCount(count);
		return info;
	}

	@Override
	public List<Project> findObjectByParams(String name,String projectNo) {
		String hql="from Project where 1=1";
		if(name!=null&&!name.equals("")) {
			hql+=" and name='"+name+"'";
		}
		if(projectNo!=null&&!projectNo.equals("")) {
			hql+=" and projectNo='"+projectNo+"'";
		}
		return projectDao.find(hql);
	}

	@Override
	public void update(Project project) {
		projectDao.update(project);
		
	}

	@Override
	public List<Project> findAll() {
		String hql="from Project";
		return projectDao.find(hql);
	}

}
