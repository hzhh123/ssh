package com.hd.action.login;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.UserService;
import com.hd.util.JsonUtil;
import com.hd.util.TreeNode;

@Scope("prototype")
@Results({
@Result(name = "index", location = "/jsp/index.jsp")
})
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class LoginAction extends BaseAction {
	private final static Logger logger = LoggerFactory.getLogger(LoginAction.class);
	@Autowired
	private UserService userService;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User loginUser=userService.getUserByUsernameAndPassword(user);
		//保存角色
		List<Role>roleList=userService.getRoles(user.getId());
		loginUser.setRoleList(roleList);
		String roleIdList="";
		String roleNameList="";
		if(roleList.size()>0) {
			for(Role role:roleList) {
				roleIdList+=role.getId()+",";
				roleNameList+=role.getDescription()+",";
			}
			roleIdList=roleIdList.substring(0,roleIdList.length()-1);
			roleNameList=roleNameList.substring(0,roleNameList.length()-1);
			loginUser.setRoleIdList(roleIdList);
			loginUser.setRoleNameList(roleNameList);
		}
		logger.info("登陆用户："+JsonUtil.toJson(loginUser));
		if(loginUser!=null){
			session.setAttribute("user", loginUser);
			this.setMessage("{\"message\":\"success\"}");
		} else {
			this.setMessage("{\"message\":\"fail\"}");
		}
		return "ajax";
	}
	//获取菜单
	public String index() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User sessionUser=(User)session.getAttribute("user");
		List<TreeNode> nodes =userService.getResourceByUserid(sessionUser.getId(), 0);
		session.setAttribute("menus", nodes);
		return "index";
	}
	//退出
	public String logout() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("menus");
		this.setMessage("{\"success\":true}");
		return "ajax";
	}
}
