package com.form;

/**
 * 取消活动申请
 * @author admin
 *
 */
public class CancelApply {
	
	private String cid;
	private String title;//名称
	private String appId;//申请经费id
	private Integer applyStatus;//取消活动申请状态
	private String deptName;//所属单位
	private String applyName;//申请人
	private String cancelWhy;//取消原因
	private String createTime;//创建时间
	private String createCode;//创建人编号
	private String wfinstanceId;//流程id
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public Integer getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getCancelWhy() {
		return cancelWhy;
	}
	public void setCancelWhy(String cancelWhy) {
		this.cancelWhy = cancelWhy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateCode() {
		return createCode;
	}
	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}
	public String getWfinstanceId() {
		return wfinstanceId;
	}
	public void setWfinstanceId(String wfinstanceId) {
		this.wfinstanceId = wfinstanceId;
	}
	
	public CancelApply() {
		// TODO Auto-generated constructor stub
	}
}
