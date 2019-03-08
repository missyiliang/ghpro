package com.form;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动预算
 * @author 33
 *
 */
public class OutlayInfo {
	
	private String 	oid;
	private String wfinstanceid;//流程实例ID
	private String totalCode;//台工会总字
	private String channelCode;//中心（频道）工会字
	private String centerName;//所属中心
	private String phone;//联系座机电话
	private String applyDate;//申请日期
	private Integer joinNum;//受众人数
	private String proType;//所属项目
	private String askName;//请示名称
	private String askLoc;//请示内容
	private String payBudgetName;//支出预算名称
	private String cashNum;//x项使用现金
	private String cashSum;//共计X元
	private String bank_num;//X项银行电子汇款方式
	private String checkNum;//X项支票结算
	private String outlayType;//经费类别
	private String payType;//支付方式
	private Date createTime;//创建时间
	private String createCode;//创建人编号
	private String createName;//创建人姓名
	private String ghStartTime;//活动开始时间
	private String ghEndTime;//活动结束时间
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getWfinstanceid() {
		return wfinstanceid;
	}
	public void setWfinstanceid(String wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}
	public String getTotalCode() {
		return totalCode;
	}
	public void setTotalCode(String totalCode) {
		this.totalCode = totalCode;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getJoinNum() {
		return joinNum;
	}
	public void setJoinNum(Integer joinNum) {
		this.joinNum = joinNum;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getAskName() {
		return askName;
	}
	public void setAskName(String askName) {
		this.askName = askName;
	}
	public String getAskLoc() {
		return askLoc;
	}
	public void setAskLoc(String askLoc) {
		this.askLoc = askLoc;
	}
	public String getPayBudgetName() {
		return payBudgetName;
	}
	public void setPayBudgetName(String payBudgetName) {
		this.payBudgetName = payBudgetName;
	}
	public String getCashNum() {
		return cashNum;
	}
	public void setCashNum(String cashNum) {
		this.cashNum = cashNum;
	}
	public String getCashSum() {
		return cashSum;
	}
	public void setCashSum(String cashSum) {
		this.cashSum = cashSum;
	}
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	public String getOutlayType() {
		return outlayType;
	}
	public void setOutlayType(String outlayType) {
		this.outlayType = outlayType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateCode() {
		return createCode;
	}
	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getGhStartTime() {
		return ghStartTime;
	}
	public void setGhStartTime(String ghStartTime) {
		this.ghStartTime = ghStartTime;
	}
	public String getGhEndTime() {
		return ghEndTime;
	}
	public void setGhEndTime(String ghEndTime) {
		this.ghEndTime = ghEndTime;
	}
	
	public OutlayInfo() {
		// TODO Auto-generated constructor stub
	}
	
}
