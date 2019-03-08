
package com.form;


/**
 * 
 * 角色用户信息
 *
 * @author wangsl
 * @date 2017年10月27日下午2:33:31
 */
public class OdRoleUserVo {
	
	private OdRoleUser roleUser = new OdRoleUser();
	
    private OdRoleUserShow roleUserShow = new OdRoleUserShow();

	public OdRoleUser getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(OdRoleUser roleUser) {
		this.roleUser = roleUser;
	}

	public OdRoleUserShow getRoleUserShow() {
		return roleUserShow;
	}

	public void setRoleUserShow(OdRoleUserShow roleUserShow) {
		this.roleUserShow = roleUserShow;
	}
    
    
	
}

