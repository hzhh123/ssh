package com.hd.action.user;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hd.action.common.BaseAction;
import com.hd.entity.Organization;
import com.hd.entity.Project;
import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.OrganizationService;
import com.hd.service.ProjectService;
import com.hd.service.RoleService;
import com.hd.service.UserService;
import com.hd.util.JsonUtil;
import com.hd.util.PageInfo;

@Scope("prototype")
@Results({ @Result(name = "add", location = "/jsp/user/userAdd.jsp"), 
	@Result(name = "edit", location = "/jsp/user/userEdit.jsp"),
	@Result(name = "view", location = "/jsp/user/userView.jsp") 
})
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class UserAction extends BaseAction {
	private final static Logger logger = LoggerFactory.getLogger(UserAction.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private ProjectService projectService;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public void dataGrid() throws IOException {
		 HttpServletRequest request=ServletActionContext.getRequest();
		 HttpServletResponse response=ServletActionContext.getResponse();
		 System.out.println("page:"+request.getParameter("page"));
		 Integer page=Integer.parseInt(request.getParameter("page"));
		 String name=request.getParameter("name");
		 String phone=request.getParameter("phone");
		 String organizationId=request.getParameter("organizationId");
		 Integer limit=Integer.parseInt(request.getParameter("limit"));
	     PageInfo info=userService.findDataGrid(page, limit, name,organizationId,phone);
	     response.setCharacterEncoding("utf8");
	     response.setContentType("text/html;charset=UTF-8");  
	     PrintWriter out=response.getWriter();
	     out.print(JsonUtil.toJson(info));
	     out.close();
	}
	
	public String addPage() {
		List<Role>roles=roleService.findAllByStatus(1);
		 HttpServletRequest request=ServletActionContext.getRequest();
		 request.setAttribute("roles", roles);
		return "add";
	}
	
	//添加用户
	public String add() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String roleId=request.getParameter("roleIds");
		userService.save(user);
		//保存用户-角色
		if(!roleId.equals("")) {
		 userService.saveUserRole(roleId, user.getId());
		}
		com.hd.util.Result result=new com.hd.util.Result();
		result.setMsg("添加成功！");
		this.setMessage(JsonUtil.toJson(result));
		return "ajax";
	}
	
	public String editPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		User user=userService.getUser(id);
		if(user.getOrganizationId()!=null) {
			Organization organization=organizationService.get(user.getOrganizationId());
			request.setAttribute("org", organization);
		}
		if(user.getPjId()!=null) {
			Project project=projectService.get(user.getPjId());
			request.setAttribute("project", project);
		}
		//设置直接上级
		if(user.getLeader()!=null) {
			User leaderUser=userService.getUser(user.getLeader());
			user.setLeaderName(leaderUser.getName());
		}
		//设置角色
		List<Role>checkRoles=userService.getRoles(id);
		if(checkRoles.size()>0) {
			request.setAttribute("checkRoles", checkRoles);
		}
		//查询所有有效角色
		List<Role>roles=roleService.findAllByStatus(1);
		request.setAttribute("roles", roles);
		request.setAttribute("user", user);
		
		return "edit";
	}
	public String viewPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		User user=userService.getUser(id);
		if(user.getOrganizationId()!=null) {
			Organization organization=organizationService.get(user.getOrganizationId());
			request.setAttribute("org", organization);
		}
		if(user.getPjId()!=null) {
			Project project=projectService.get(user.getPjId());
			request.setAttribute("project", project);
		}
		//设置直接上级
		if(user.getLeader()!=null) {
			User leaderUser=userService.getUser(user.getLeader());
			user.setLeaderName(leaderUser.getName());
		}
		//设置角色
		List<Role>roles=userService.getRoles(id);
		if(roles.size()>0) {
			request.setAttribute("roles", roles);
		}
		request.setAttribute("user", user);
		
		return "view";
	}
	
	//更新
	public String update() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String roleId=request.getParameter("roleIds");
		if(user.getId()!=null) {
			userService.update(user);
		}
		//保存用户-角色
		if(!roleId.equals("")) {
			userService.saveUserRole(roleId, user.getId());
		}
		this.setMessage("{\"success\":true}");
		return "ajax";
	}
	//删除
	public String delete() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		userService.delete(id);
		return ajaxSuccess();
	}
	//批量删除
	public String deleteBatch() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String ids=request.getParameter("ids");
		userService.deleteBatch(ids);
		return ajaxSuccess();
	}
	
	
}
