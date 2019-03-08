package com.form;
/**
 * 支出预算
 * @author admin
 *
 */

import java.math.BigDecimal;


public class PayBudget{

	private String pid;
	private String appId;//申请经费ID
	private String seqCode;//序号
	private String title;//项目
	private Integer num;//数量
	private String unit;//物品单位
	private String  price;//单价
	private String priceSum;//金额
	private String priceLines;//专项额度
	private String careerVipCast;//事业编会员会费
	private String cctvVipCast;//台聘会员会费
	private String settlementType;//结算方式
	private String direction;//去向
	
	
	private String totalPriceSum;//总金额
	private String totalPriceLines;//总专项额度
	private String totalCareerVipCast;//总事业编会员会费
	private String totalCctvVipCast;//总台聘会员会费
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getSeqCode() {
		return seqCode;
	}
	public void setSeqCode(String seqCode) {
		this.seqCode = seqCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPriceSum() {
		return priceSum;
	}
	public void setPriceSum(String priceSum) {
		this.priceSum = priceSum;
	}
	public String getPriceLines() {
		return priceLines;
	}
	public void setPriceLines(String priceLines) {
		this.priceLines = priceLines;
	}
	public String getCareerVipCast() {
		return careerVipCast;
	}
	public void setCareerVipCast(String careerVipCast) {
		this.careerVipCast = careerVipCast;
	}
	public String getCctvVipCast() {
		return cctvVipCast;
	}
	public void setCctvVipCast(String cctvVipCast) {
		this.cctvVipCast = cctvVipCast;
	}
	public String getSettlementType() {
		return settlementType;
	}
	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getTotalPriceSum() {
		return totalPriceSum;
	}
	public void setTotalPriceSum(String totalPriceSum) {
		this.totalPriceSum = totalPriceSum;
	}
	public String getTotalPriceLines() {
		return totalPriceLines;
	}
	public void setTotalPriceLines(String totalPriceLines) {
		this.totalPriceLines = totalPriceLines;
	}
	public String getTotalCareerVipCast() {
		return totalCareerVipCast;
	}
	public void setTotalCareerVipCast(String totalCareerVipCast) {
		this.totalCareerVipCast = totalCareerVipCast;
	}
	public String getTotalCctvVipCast() {
		return totalCctvVipCast;
	}
	public void setTotalCctvVipCast(String totalCctvVipCast) {
		this.totalCctvVipCast = totalCctvVipCast;
	}
	public PayBudget() {
		// TODO Auto-generated constructor stub
	}
	
	
}
