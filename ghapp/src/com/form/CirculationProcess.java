package com.form;


/**
 * 用于显示流转过程的实体类
 * @author admin
 *
 */
public class CirculationProcess {
	
	private String instanceId;//流程id
	private Integer workitemId;//
	private Integer workflowId;//用于判断是爱心工程还是活动申请或者是取消活动申请
	private String workflowName;//
	private String nodeIndex;//流程的编码
	private String nodeName;//显示的流程名字
	private String endTime;//流程的结束时间
	private String actionName;//显示执行操作
	
	private String nodeNameRemoveName ;//去除掉-之后的名字
	

	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
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
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getNodeIndex() {
		return nodeIndex;
	}
	public void setNodeIndex(String nodeIndex) {
		this.nodeIndex = nodeIndex;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getNodeNameRemoveName() {
		return nodeNameRemoveName;
	}
	public void setNodeNameRemoveName(String nodeNameRemoveName) {
		this.nodeNameRemoveName = nodeNameRemoveName;
	}
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public CirculationProcess() {
		// TODO Auto-generated constructor stub
	}
}
