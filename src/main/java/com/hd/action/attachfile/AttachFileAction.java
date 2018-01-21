package com.hd.action.attachfile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.hd.action.common.BaseAction;
import com.hd.entity.AttachFile;
import com.hd.service.AttachFileService;
import com.hd.util.JsonUtil;

/**
 * @author hzhh123
 * @time 2018年1月18日下午2:21:43
 **/
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class AttachFileAction extends BaseAction {
	@Autowired
	private AttachFileService attachFileService;
	private File[] file;
	private String[] fileFileName;
	private String[] fileContentType;

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public void upload1() throws IOException {
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		if (file != null) {
			File savedir = new File(realpath);
			if (!savedir.exists()) {
				savedir.mkdirs();
			}
			for (int i = 0; i < file.length; i++) {
				File savefile = new File(savedir, fileFileName[i]);
				FileUtils.copyFile(file[i], savefile);
				AttachFile attachfile=new AttachFile();
				attachfile.setCreateTime(new Date());
				attachfile.setName(fileFileName[i]);
				String type=fileFileName[i].substring(fileFileName[i].lastIndexOf('.'+1), fileFileName[i].length());
				attachfile.setType(type);
				attachfile.setUrl("/upload/"+fileFileName[i]);
				attachFileService.save(attachfile);
			}
		}
	}

	// 返回AttachFile的json数据
	public String upload2() throws IOException {
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		List<AttachFile>attachfiles=new ArrayList<AttachFile>();
		if (file != null) {
			File savedir = new File(realpath);
			if (!savedir.exists()) {
				savedir.mkdirs();
			}
			for (int i = 0; i < file.length; i++) {
				String type=fileFileName[i].substring(fileFileName[i].lastIndexOf('.'+1), fileFileName[i].length());
				String filePath=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+new Random().nextInt(1000)+"."+type;
				File savefile = new File(savedir, filePath);
				FileUtils.copyFile(file[i], savefile);
				AttachFile attachfile=new AttachFile();
				attachfile.setCreateTime(new Date());
				attachfile.setName(fileFileName[i]);
				attachfile.setType(type);
				attachfile.setUrl("/upload/"+filePath);
				attachFileService.save(attachfile);
				attachfiles.add(attachfile);
			}
		}
		this.setMessage(JsonUtil.toJson(attachfiles));
		return "ajax";
	}

}
