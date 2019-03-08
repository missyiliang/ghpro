package com.form;

/**
 * 办理通知列表
 * @author 33
 *
 */
public class TipsForm {

	private String nid;//主键ID
	private String title;//标题
	private String fileNum;//文号
	private String noticeUserName;//用户名称
	private String noticeDate;//办理日期
	private String noticeType;//办理类型 1代表退办 2代表办结
	private String noticeStatus;//办理只读类型 1代表未读 2代表已读
	private String userId;//当前用户ID
	private String content;//正文
	private String wfinstanceid;//流程实例ID
	private String workFlowId;//流程id
	
	
	
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public String getNoticeUserName() {
		return noticeUserName;
	}
	public void setNoticeUserName(String noticeUserName) {
		this.noticeUserName = noticeUserName;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWfinstanceid() {
		return wfinstanceid;
	}
	public void setWfinstanceid(String wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}
	public String getWorkFlowId() {
		return workFlowId;
	}
	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}
	
}
