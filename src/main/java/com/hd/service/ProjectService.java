package com.hd.service;

import java.util.List;

import com.hd.entity.Project;
import com.hd.util.PageInfo;

/**
*@author hzhh123
*@time 2018年1月16日上午9:28:48 
**/
public interface ProjectService {
	Project get(Long id);
	void save(Project project);
	void delete(Long id);
	PageInfo findDataGrid(Integer page, Integer limit, String name, String projectNo);
	List<Project> findObjectByParams(String name,String projectNo);
	void update(Project project);
	List<Project> findAll();
}
