package com.hd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hd.util.JsonUtil;

/**
*@author hzhh123
*@time 2018年1月16日上午9:26:33 
**/
@Entity
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="projectno")
	private String projectNo;
	private String name;
	private String companyId;
	private String constructionUnits;//建设单位
	private String designUtils;//设计单位
	private String totalUtils;//总包单位
	private String supervisingUnit;//监理单位
	private String explorationUnit;//勘察单位
	private String address;//工程地址
	private String days;//合同工期
	private String scale;//建筑规模
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getConstructionUnits() {
		return constructionUnits;
	}
	public void setConstructionUnits(String constructionUnits) {
		this.constructionUnits = constructionUnits;
	}
	public String getDesignUtils() {
		return designUtils;
	}
	public void setDesignUtils(String designUtils) {
		this.designUtils = designUtils;
	}
	public String getTotalUtils() {
		return totalUtils;
	}
	public void setTotalUtils(String totalUtils) {
		this.totalUtils = totalUtils;
	}
	public String getSupervisingUnit() {
		return supervisingUnit;
	}
	public void setSupervisingUnit(String supervisingUnit) {
		this.supervisingUnit = supervisingUnit;
	}
	public String getExplorationUnit() {
		return explorationUnit;
	}
	public void setExplorationUnit(String explorationUnit) {
		this.explorationUnit = explorationUnit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
	
}
