package com.hd.action.icon;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hd.action.common.BaseAction;
import com.hd.service.IconService;
import com.hd.util.JsonUtil;
import com.hd.util.Page;
import com.hd.util.PageInfo;

/**
*@author hzhh123
*@time 2018年1月18日下午1:27:48 
**/
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class IconAction extends BaseAction{
	@Autowired
	private IconService iconService;
	
	public String page() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Integer limit=Integer.parseInt(request.getParameter("limit"));
		Integer page=Integer.parseInt(request.getParameter("curr"));
		String sourcetype=request.getParameter("sourcetype");
		PageInfo info=iconService.findDataGrid(page,limit,sourcetype);
		 Page p=new Page(page,limit);
	     p.setList(info.getData());
	     p.setCount(info.getCount());
		this.setMessage(JsonUtil.toJson(p));
		return "ajax";
	}
}
