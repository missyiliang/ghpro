package com.form;

import java.util.Date;

/**
 * 爱心工程详情
 * @author 33
 *
 */
public class LoveInfo {
	
	private String lid;
	private String instanceId;//流程id
	private String nodeName;//流转过程的任务名称
	private Date endTime;//流程结束时间
	private String askName;//请示名称
	private String totalCode;//台工会总字
	private String centerName;//中心名称
	private Date createTime ;//活动申请创建时间
	private String createName ;//创建人
	private String createCode ;//创建人的工作证号
	private String phone;//手机号
	private String employeeName;//职工姓名
	private String staffEstablishing;//人员编制
	private String employeeSex;//职工性别
	private String workNumber;//职工工作证号
	private String familyName;//家属姓名
	private String familySex ;//家属性别
	private String employeeRelation;//与职工本人关系
	private String consolationProject;//慰问项目
	private String applyAmountd;///申领金额大写
	private String applyAmountx;//申领金额小写
	
	private String applyDate;//申请日期
	private Integer workitemId;//
	private Integer workflowId;//用于判断是爱心工程还是活动申请或者是取消活动申请
	
	private Integer type;//用于判断爱心工程的类型
	private String title;//名称
	
	
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getAskName() {
		return askName;
	}
	public void setAskName(String askName) {
		this.askName = askName;
	}
	public String getTotalCode() {
		return totalCode;
	}
	public void setTotalCode(String totalCode) {
		this.totalCode = totalCode;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getCreateCode() {
		return createCode;
	}
	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getStaffEstablishing() {
		return staffEstablishing;
	}
	public void setStaffEstablishing(String staffEstablishing) {
		this.staffEstablishing = staffEstablishing;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public String getWorkNumber() {
		return workNumber;
	}
	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilySex() {
		return familySex;
	}
	public void setFamilySex(String familySex) {
		this.familySex = familySex;
	}
	public String getEmployeeRelation() {
		return employeeRelation;
	}
	public void setEmployeeRelation(String employeeRelation) {
		this.employeeRelation = employeeRelation;
	}
	public String getConsolationProject() {
		return consolationProject;
	}
	public void setConsolationProject(String consolationProject) {
		this.consolationProject = consolationProject;
	}
	public String getApplyAmountd() {
		return applyAmountd;
	}
	public void setApplyAmountd(String applyAmountd) {
		this.applyAmountd = applyAmountd;
	}
	public String getApplyAmountx() {
		return applyAmountx;
	}
	public void setApplyAmountx(String applyAmountx) {
		this.applyAmountx = applyAmountx;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	
	
	public Integer getWorkitemId() {
		return workitemId;
	}
	public void setWorkitemId(Integer workitemId) {
		this.workitemId = workitemId;
	}
	public Integer getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	
	public LoveInfo() {
		// TODO Auto-generated constructor stub
	}
	
}
