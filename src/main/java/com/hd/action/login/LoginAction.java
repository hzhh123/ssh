package com.hd.action.login;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hd.action.common.BaseAction;
import com.hd.entity.User;
import com.hd.service.UserService;
import com.hd.util.JsonUtil;

@Scope("prototype")
@Results({ @Result(name = "success", location = "/success.jsp"), @Result(name = "error", location = "/error.jsp") })
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
		User loginUser=userService.getUserByUsernameAndPassword(user);
		logger.info("登陆用户："+JsonUtil.toJson(loginUser));
		if(loginUser!=null){
			this.setMessage("{\"message\":\"success\"}");
		} else {
			this.setMessage("{\"message\":\"fail\"}");
		}
		return "ajax";
	}
}
