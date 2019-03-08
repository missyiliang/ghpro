package com.form;

import java.math.BigDecimal;

/**
 * 汇款申请单
 * @author admin
 *
 */
public class RemitBill {
	
	private String rid;
	private String appId;//申请经费id
	private String remitCenterCode;//汇款人部门编号
	private String remitCenterName;//汇款人部门名称
	private String recevieName;//收款方名称
	private String remitCost;//汇款金额
	private String recevieBankName;//收款方开户行名称
	private String remitUse;//汇款用途
	private String recevieBankCard;//收款方账号
	private Integer remitPaperNum;//汇款附支票张数
	private String agentName;//经办人
	private String paperCard;//票据单号
	private String agentTel;//经办人联系电话
	private String remitBudgetNum;//支出预算编码
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getRemitCenterCode() {
		return remitCenterCode;
	}
	public void setRemitCenterCode(String remitCenterCode) {
		this.remitCenterCode = remitCenterCode;
	}
	public String getRemitCenterName() {
		return remitCenterName;
	}
	public void setRemitCenterName(String remitCenterName) {
		this.remitCenterName = remitCenterName;
	}
	public String getRecevieName() {
		return recevieName;
	}
	public void setRecevieName(String recevieName) {
		this.recevieName = recevieName;
	}
	public String getRemitCost() {
		return remitCost;
	}
	public void setRemitCost(String remitCost) {
		this.remitCost = remitCost;
	}
	public String getRecevieBankName() {
		return recevieBankName;
	}
	public void setRecevieBankName(String recevieBankName) {
		this.recevieBankName = recevieBankName;
	}
	public String getRemitUse() {
		return remitUse;
	}
	public void setRemitUse(String remitUse) {
		this.remitUse = remitUse;
	}
	public String getRecevieBankCard() {
		return recevieBankCard;
	}
	public void setRecevieBankCard(String recevieBankCard) {
		this.recevieBankCard = recevieBankCard;
	}
	public Integer getRemitPaperNum() {
		return remitPaperNum;
	}
	public void setRemitPaperNum(Integer remitPaperNum) {
		this.remitPaperNum = remitPaperNum;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getPaperCard() {
		return paperCard;
	}
	public void setPaperCard(String paperCard) {
		this.paperCard = paperCard;
	}
	public String getAgentTel() {
		return agentTel;
	}
	public void setAgentTel(String agentTel) {
		this.agentTel = agentTel;
	}
	public String getRemitBudgetNum() {
		return remitBudgetNum;
	}
	public void setRemitBudgetNum(String remitBudgetNum) {
		this.remitBudgetNum = remitBudgetNum;
	}
	
	
	public RemitBill() {
		// TODO Auto-generated constructor stub
	}
	
	
}
