package com.hd.action.resource;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hd.action.common.BaseAction;
import com.hd.entity.Resource;
import com.hd.service.ResourceService;
import com.hd.util.JsonUtil;

/**
*@author hzhh123
*@time 2018年1月17日下午9:59:42 
**/
@Scope("prototype")
@Results({ @Result(name = "add", location = "/jsp/resource/resourceAdd.jsp"),
		@Result(name = "edit", location = "/jsp/resource/resourceEdit.jsp"),
		@Result(name = "view", location = "/jsp/resource/resourceView.jsp") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class ResourceAction extends BaseAction {
	@Autowired
	private ResourceService resourceService;
	private Resource resource;
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public String addPage() {
		return "add";
	}

	// 添加用户
	public String add() {
		resourceService.save(resource);
		com.hd.util.Result result = new com.hd.util.Result();
		result.setMsg("添加成功！");
		this.setMessage(JsonUtil.toJson(result));
		return "ajax";
	}

	public String editPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		Resource r = resourceService.get(id);
		request.setAttribute("resource", r);
		return "edit";
	}

	public String viewPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		Resource r = resourceService.get(id);
		request.setAttribute("resource", r);
		return "view";
	}

	public String get() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		Resource r = resourceService.get(id);
		this.setMessage(JsonUtil.toJson(r));
		return "ajax";
	}
	// 更新
	public String update() {
		if (resource.getId() != null) {
			resourceService.update(resource);
		}
		this.setMessage("{\"success\":true}");
		return "ajax";
	}

	// 删除
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		resourceService.delete(id);
		return ajaxSuccess();
	}
	
	public String getTreeGrid() {
		String result=resourceService.getTreeGrid();
		this.setMessage(result);
		return "ajax";
	}
	
	public void jstree() throws IOException {
		 HttpServletResponse response=ServletActionContext.getResponse();
	     response.setCharacterEncoding("utf8");
	     response.setContentType("text/html;charset=UTF-8");  
	     PrintWriter out=response.getWriter();
	     out.println(JsonUtil.toJson(resourceService.selectJstree()));
	     out.close();
	}

}
