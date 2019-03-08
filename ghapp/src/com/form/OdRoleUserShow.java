package com.form;

import java.sql.Timestamp;



/**
 * 根据不同的角色显示代办首页
 * @author admin
 *
 */
public class OdRoleUserShow  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer userRoleId;
	private Integer userId;
	private Integer roleId;
	private Timestamp createTime; //中间表的创建时间
	private String loginname;
	private String username;
	private String roleName;
	//是否管理员
    private Integer isAdminRole;
    
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getIsAdminRole() {
		return isAdminRole;
	}
	public void setIsAdminRole(Integer isAdminRole) {
		this.isAdminRole = isAdminRole;
	}
    
	public OdRoleUserShow() {
		// TODO Auto-generated constructor stub
	}

}
