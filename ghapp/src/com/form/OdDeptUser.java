package com.form;

import java.sql.Timestamp;


/**
 * OdDeptUser entity. @author MyEclipse Persistence Tools
 */

public class OdDeptUser  {

	// Fields

	/**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = -22373914148306741L;
    private Integer deptUserId;
	private Integer deptId;
	private Integer userId;
	private Integer sortNum;


	// Constructors

	/** default constructor */
	public OdDeptUser() {
	}

	/** full constructor */
	public OdDeptUser(Integer deptId, Integer userId, Integer sortNum) {
		this.deptId = deptId;
		this.userId = userId;
		this.sortNum = sortNum;
	}

	// Property accessors

	public Integer getDeptUserId() {
		return this.deptUserId;
	}

	public void setDeptUserId(Integer deptUserId) {
		this.deptUserId = deptUserId;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	

}