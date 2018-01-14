package com.hd.action.common;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("default")
public class BaseAction extends ActionSupport{
	 private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String ajaxSuccess() {
		this.setMessage("{\"message\":\"success\"}");
		return "ajax";
	} 
}
