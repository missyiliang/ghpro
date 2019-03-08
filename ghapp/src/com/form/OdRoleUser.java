package com.form;

import java.sql.Timestamp;


/**
 * OdRoleUser entity. @author MyEclipse Persistence Tools
 */

public class OdRoleUser   {

	// Fields

	private Integer userRoleId;
	private Integer userId;
	private Integer roleId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public OdRoleUser() {
	}

	/** full constructor */
	public OdRoleUser(Integer userId, Integer roleId, Timestamp createTime) {
		this.userId = userId;
		this.roleId = roleId;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}