package com.hd.action.role;

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
import com.hd.entity.Role;
import com.hd.service.RoleService;
import com.hd.util.JsonUtil;
import com.hd.util.PageInfo;
import com.hd.util.Tree;

/**
 * @author hzhh123
 * @time 2018年1月17日下午3:46:50
 **/
@Scope("prototype")
@Results({ @Result(name = "add", location = "/jsp/role/roleAdd.jsp"),
		@Result(name = "edit", location = "/jsp/role/roleEdit.jsp"),
		@Result(name = "view", location = "/jsp/role/roleView.jsp") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class RoleAction extends BaseAction {
	@Autowired
	private RoleService roleService;
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void dataGrid() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer limit = Integer.parseInt(request.getParameter("limit"));
		PageInfo info = roleService.findDataGrid(page, limit);
		System.out.println(page+","+limit);
		System.out.println(JsonUtil.toJson(info));
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(JsonUtil.toJson(info));
		out.close();
	}

	public String addPage() {
		return "add";
	}

	// 添加用户
	public String add() {
		roleService.save(role);
		com.hd.util.Result result = new com.hd.util.Result();
		result.setMsg("添加成功！");
		this.setMessage(JsonUtil.toJson(result));
		return "ajax";
	}

	public String editPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		Role r = roleService.get(id);
		request.setAttribute("role", r);
		return "edit";
	}

	public String viewPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		Role r = roleService.get(id);
		request.setAttribute("role", r);
		return "view";
	}

	// 更新
	public String update() {
		if (role.getId() != null) {
			roleService.update(role);
		}
		this.setMessage("{\"success\":true}");
		return "ajax";
	}

	// 删除
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		roleService.delete(id);
		return ajaxSuccess();
	}

	// 分配权限
	public String permissionAddOrEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long roleId = Long.valueOf(request.getParameter("roleId"));
		String resourceIds = request.getParameter("resourceIds");
		roleService.addOrEditPermission(roleId, resourceIds);
		return ajaxSuccess();
	}

	public void viewPermission() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Long roleId = Long.valueOf(request.getParameter("id"));
		List<Tree> treeList = roleService.selectTreeByRoleId(roleId);
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(JsonUtil.toJson(treeList));
		out.close();

	}
}
