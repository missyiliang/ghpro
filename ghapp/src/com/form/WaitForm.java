package com.form;

/**
 * 待办列表
 * @author 33
 *
 */
public class WaitForm {
	
	private String appid;//申请ID

	private String title;//标题
	
	private String applyTime;//申请时间
	
	private String centerName;//中心名称
	
	private String workFlowId;//流程类型
	
	private String instanceId;//流程实例ID
	
	private Integer status;//狀態
	
	private Integer isSecond;//是否是第二弊遍流程
	
	private String proType;//项目类型
	
	private Integer isCancel;//是否取消
	
	private Integer readStatus;
	

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsSecond() {
		return isSecond;
	}

	public void setIsSecond(Integer isSecond) {
		this.isSecond = isSecond;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public Integer getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}

	public Integer getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

}
