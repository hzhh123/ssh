package com.hd.action.organization;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.hd.entity.Organization;
import com.hd.service.OrganizationService;
import com.hd.util.JsonUtil;
import com.hd.util.PageInfo;

/**
*@author hzhh123
*@time 2018年1月15日下午5:17:06 
**/
@Scope("prototype")
@Results({ 
	@Result(name = "add", location = "/jsp/org/organizationAdd.jsp"),
	@Result(name = "edit", location = "/jsp/org/organizationEdit.jsp") ,
	@Result(name = "view", location = "/jsp/org/organizationView.jsp") 
})
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class OrganizationAction extends BaseAction{
	@Autowired
	private OrganizationService organizationService;
	private Organization organization;
	
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public void jstree() throws IOException {
		 HttpServletResponse response=ServletActionContext.getResponse();
	     response.setCharacterEncoding("utf8");
	     response.setContentType("text/html;charset=UTF-8");  
	     PrintWriter out=response.getWriter();
	     out.println(JsonUtil.toJson(organizationService.selectJstree()));
	     out.close();
	}
	
	public void dataGrid() throws IOException {
		 HttpServletRequest request=ServletActionContext.getRequest();
		 HttpServletResponse response=ServletActionContext.getResponse();
		 Integer page=Integer.parseInt(request.getParameter("page"));
		 Integer limit=Integer.parseInt(request.getParameter("limit"));
		 String orgname=request.getParameter("name");
		 String id=request.getParameter("id");
	     PageInfo info=organizationService.findDataGrid(page, limit, orgname,id);
	     response.setCharacterEncoding("utf8");
	     response.setContentType("text/html;charset=UTF-8");  
	     PrintWriter out=response.getWriter();
	     out.print(JsonUtil.toJson(info));
	     out.close();
	}
	
	public String addPage() {
		return "add";
	}
	
	//添加用户
	public String add() {
		organizationService.save(organization);
		com.hd.util.Result result=new com.hd.util.Result();
		result.setMsg("添加成功！");
		this.setMessage(JsonUtil.toJson(result));
		return "ajax";
	}
	
	public String editPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		Organization org=organizationService.get(id);
		if(org.getPid()!=null) {
			Organization vo=organizationService.get(org.getPid());
			org.setParentName(vo.getOrgname());
		}
		request.setAttribute("organization", org);
		return "edit";
	}
	public String viewPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		Organization org=organizationService.get(id);
		if(org.getPid()!=null) {
			Organization vo=organizationService.get(org.getPid());
			org.setParentName(vo.getOrgname());
		}
		request.setAttribute("organization", org);
		return "view";
	}
	
	//更新
	public String update() {
		if(organization.getId()!=null) {
			organizationService.update(organization);
		}
		this.setMessage("{\"success\":true}");
		return "ajax";
	}
	//删除
	public String delete() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		organizationService.delete(id);
		return ajaxSuccess();
	}
	//批量删除
	public String deleteBatch() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String ids=request.getParameter("ids");
		organizationService.deleteBatch(ids);
		return ajaxSuccess();
	}
}
