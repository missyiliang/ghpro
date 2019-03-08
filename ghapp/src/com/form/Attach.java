package com.form;

/**
 * 附件
 * @author admin
 *
 */
public class Attach {
	private String aid;
	private String appId;//经费申请ID
	private String attName;//附件原始名称
	private String upName;//上传人
	private String upTime;//上传时间
	private String url;//地址
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAttName() {
		return attName;
	}
	public void setAttName(String attName) {
		this.attName = attName;
	}
	public String getUpName() {
		return upName;
	}
	public void setUpName(String upName) {
		this.upName = upName;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Attach() {
		// TODO Auto-generated constructor stub
	}
}
