package com.hd.action.project;

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
import com.hd.entity.Project;
import com.hd.entity.User;
import com.hd.service.ProjectService;
import com.hd.service.UserService;
import com.hd.util.JsonUtil;
import com.hd.util.PageInfo;

/**
 * @author hzhh123
 * @time 2018年1月17日上午10:14:24
 **/
@Scope("prototype")
@Results({ 
	@Result(name = "add", location = "/jsp/project/projectAdd.jsp"),
	@Result(name = "edit", location = "/jsp/project/projectEdit.jsp") ,
	@Result(name = "view", location = "/jsp/project/projectView.jsp") ,
	@Result(name = "manage", location = "/jsp/project/projectManage.jsp") ,
})
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class ProjectAction extends BaseAction {
	@Autowired
	private ProjectService projectService;
	private Project project;
	@Autowired
	private UserService userService;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void dataGrid() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer limit = Integer.parseInt(request.getParameter("limit"));
		String name = request.getParameter("name");
		String projectNo = request.getParameter("projectNo");
		PageInfo info = projectService.findDataGrid(page, limit, name, projectNo);
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(JsonUtil.toJson(info));
		out.close();
	}

	public String add() {
		boolean success = true;
		String msg = "";
		if (!project.getName().equals("")) {
			List<Project> projects = projectService.findObjectByParams(project.getName(), null);
			if (projects.size() > 0) {
				success = false;
				msg += "【项目名称已经被使用】";
			}
		}
		if (!project.getProjectNo().equals("")) {
			List<Project> projects = projectService.findObjectByParams(null, project.getProjectNo());
			if (projects.size() > 0) {
				success = false;
				msg += "【项目编号已经被使用】";
			}
		}
		if (success) {
			projectService.save(project);
		}
		this.setMessage("{\"success\":" + success + ",\"msg\":\"" + msg + "\"}");
		return "ajax";
	}

	public String validName() {
		boolean success = true;
		String msg = "";
		if (!project.getName().equals("")) {
			List<Project> projects = projectService.findObjectByParams(project.getName(), null);
			if (projects.size() > 0) {
				success = false;
				msg += "【项目名称已经被使用】";
			}
		}
		this.setMessage("{\"success\":" + success + ",\"msg\":\"" + msg + "\"}");
		return "ajax";
	}

	public String validProjectNo() {
		boolean success = true;
		String msg = "";
		if (!project.getProjectNo().equals("")) {
			List<Project> projects = projectService.findObjectByParams(null, project.getProjectNo());
			if (projects.size() > 0) {
				success = false;
				msg += "【项目编号已经被使用】";
			}
		}
		this.setMessage("{\"success\":" + success + ",\"msg\":\"" + msg + "\"}");
		return "ajax";
	}

	public String update() {
		boolean success = true;
		String msg = "";
		if (project.getId() != null) {
			Project pvo=projectService.get(project.getId());
			if (!project.getName().equals("")&&!pvo.getName().equals(project.getName())) {
				List<Project> projects = projectService.findObjectByParams(project.getName(), null);
				if (projects.size() > 0) {
					success = false;
					msg += "【项目名称已经被使用】";
					System.out.println("11111111");
				}
			}
			if (!project.getProjectNo().equals("")&&!pvo.getProjectNo().equals(project.getProjectNo())) {
				List<Project> projects = projectService.findObjectByParams(null, project.getProjectNo());
				if (projects.size() > 0) {
					success = false;
					msg += "【项目编号已经被使用】";
					System.out.println("22222");
				}
			}
			if (success) {
				projectService.update(project);
			}
		}
		this.setMessage("{\"success\":" + success + ",\"msg\":\"" + msg + "\"}");
		return "ajax";
	}

	// 删除
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Long id = Long.valueOf(request.getParameter("id"));
		projectService.delete(id);
		return ajaxSuccess();
	}
	
	public String editPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		Project project=projectService.get(id);
		request.setAttribute("project", project);
		return "edit";
	}
	public String viewPage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Long id=Long.valueOf(request.getParameter("id"));
		Project project=projectService.get(id);
		request.setAttribute("project", project);
		return "view";
	}
	
	public String managePage() {
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Project>projects=projectService.findAll();
		request.setAttribute("projectSize", projects.size());
		List<User>users=userService.findOfProject();
		request.setAttribute("userSize", users.size());
		return "manage";
	}
}
