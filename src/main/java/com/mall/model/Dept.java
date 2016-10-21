package com.mall.model;

import java.util.Date;

public class Dept {

	private Integer id;
	private String deptName;
	private Date createTime;
	private Date updteTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdteTime() {
		return updteTime;
	}

	public void setUpdteTime(Date updteTime) {
		this.updteTime = updteTime;
	}
}
