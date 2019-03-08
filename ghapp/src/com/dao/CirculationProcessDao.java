package com.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.form.CirculationProcess;
/**
 * 流转过程Dao
 * @author admin
 *
 */
public class CirculationProcessDao extends BaseDao{
	
	public List<CirculationProcess> getCirculationProcess(String instanceid){
		String sql = "select ins.workflow_id workflowId,"
				+ "wf.workitem_id  workitemId,"
				+ "ins.workflow_name workflowName,"
				+ "wf.node_index nodeIndex,"
				+ "wf.node_name nodeName,"
				+ "ins.instance_id instanceId,"
				+ "wf.current_node_handlers currentNodeHandlers,"
				+ "wf.user_name userName,wf.dept_name  deptName, "
				+ "wf.action_name actionName,wf.start_time startTime,"
				+ "nvl2(wf.end_time,wf.end_time,cast(to_date('2000/01/01', 'yyyy-mm-dd,hh24:mi:ss') as timestamp)) endTime,"
				+ "wf.status status,"
				+ "wf.ifReaded ifReaded,wf.current_node_index currentNodeIndex "
				+ "FROM odbg_workitem wf, odbg_instance ins "
				+ "where 1 = 1 and wf.instance_id = ins.instance_id ";
		
		//sql += " and wf.instance_id = '8aef00a4682ba206016836add5850003'";
		if(instanceid != null || instanceid != ""){
			sql += " and wf.instance_id = '"+instanceid+"'";
		}
		
		sql += " order by wf.end_time asc, wf.status";
		
		List<CirculationProcess> list = new ArrayList<CirculationProcess>();
		CirculationProcess ccp = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){

				ccp = new CirculationProcess();
				ccp.setInstanceId(res.getString("instanceId"));
				ccp.setWorkitemId(res.getInt("workitemId"));
				ccp.setWorkflowId(res.getInt("workflowId"));
				ccp.setWorkflowName(res.getString("workflowName"));
				ccp.setNodeIndex(res.getString("nodeIndex"));
				ccp.setNodeName(res.getString("nodeName"));
				ccp.setEndTime(format.format(res.getTimestamp("endTime")));
				ccp.setActionName(res.getString("actionName"));
				
				if(ccp.getEndTime().equals("2000-01-01 00:00:00")){
					ccp.setEndTime("");
				}
				//活动申请
				if(ccp.getWorkflowId()!= null && ccp.getWorkflowId() == 7 ){
					if(ccp.getNodeName().contains("工会-")){
						ccp.setNodeNameRemoveName(res.getString("nodeName").replace("工会-",""));
					}else{
						ccp.setNodeNameRemoveName(ccp.getNodeName());
					}
					if(ccp.getNodeNameRemoveName().contains("申请人")){
						ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName().replace("申请人", "中心工会主席"));
					}
					
					if(ccp.getActionName() != null){
						if(ccp.getActionName().equals("退办")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+"不通过");
						}else if(ccp.getNodeNameRemoveName().contains("经办人申请") &&ccp.getActionName().contains("中心工会主席") ){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("中心工会主席审批") && ccp.getActionName().contains("台工会财务")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审核");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务审核") && ccp.getActionName().contains("台工会主席")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("台工会主席审批") && ccp.getActionName().contains("返回经办人")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"填写预算、合同、汇款信息");
						}else if(ccp.getNodeNameRemoveName().contains("经办人办理") && ccp.getActionName().contains("中心工会主席")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务审核")&& ccp.getActionName().contains("台工会主席")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("台工会主席审批") && ccp.getActionName().contains("转发财务")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步台工会财务票据签字");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务签字") && ccp.getActionName().contains("转发出纳")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步台工会出纳签字");
						}else if(ccp.getNodeNameRemoveName().contains("台工会出纳签字") && ccp.getActionName().contains("转发财务")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步台工会财务办结");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务审核") && ccp.getActionName().contains("返回经办人")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+"不通过"+","+ccp.getActionName()+"修改");
						}else{
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName());
						}
					}else if(ccp.getActionName() == null && ccp.getNodeNameRemoveName().contains("经办人办理")){
						ccp.setNodeNameRemoveName("经办人填写预算、合同、汇款信息");
					}else if(ccp.getActionName() == null && ccp.getNodeNameRemoveName().contains("台工会财务签字")){
						ccp.setNodeNameRemoveName("台工会财务票据签字");
					}else if(ccp.getActionName() == null){
						ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName());
					}
					
					
				}
				//取消活动申请
				if(ccp.getWorkflowId()!= null && ccp.getWorkflowId() == 8 ){
					if(ccp.getNodeName().contains("取消活动-")){
						ccp.setNodeNameRemoveName(res.getString("nodeName").replace("取消活动-",""));
					}else{
						ccp.setNodeNameRemoveName(ccp.getNodeName());
					}
				}
				
				//爱心工程
				if(ccp.getWorkflowId()!= null && ccp.getWorkflowId() == 9 ){
					if(ccp.getNodeName().contains("爱心工程-")){
						ccp.setNodeNameRemoveName(res.getString("nodeName").replace("爱心工程-", ""));
					}else{
						ccp.setNodeNameRemoveName(ccp.getNodeName());
					}
					
					
					if(ccp.getActionName() != null){
						if(ccp.getActionName().equals("退办")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+"不通过");
						}else if(ccp.getNodeNameRemoveName().contains("爱心工程申请") &&ccp.getActionName().contains("中心工会主席") ){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("中心工会主席审批") && ccp.getActionName().contains("台工会财务")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审核");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务审核") && ccp.getActionName().contains("台工会主席")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("台工会主席审批") && ccp.getActionName().contains("返回经办人")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"填写预算、合同、汇款信息");
						}else if(ccp.getNodeNameRemoveName().contains("经办人办理") && ccp.getActionName().contains("中心工会主席")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务审核")&& ccp.getActionName().contains("台工会主席")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步"+ccp.getActionName()+"审批");
						}else if(ccp.getNodeNameRemoveName().contains("台工会主席审批") && ccp.getActionName().contains("转发财务")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步台工会财务票据签字");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务签字") && ccp.getActionName().contains("转发出纳")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步台工会出纳签字");
						}else if(ccp.getNodeNameRemoveName().contains("台工会出纳签字") && ccp.getActionName().contains("转发财务")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+","+"下一步台工会财务办结");
						}else if(ccp.getNodeNameRemoveName().contains("台工会财务审核") && ccp.getActionName().contains("返回经办人")){
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName()+"不通过"+","+ccp.getActionName()+"修改");
						}else{
							ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName());
						}
					}else if(ccp.getActionName() == null && ccp.getNodeNameRemoveName().contains("经办人办理")){
						ccp.setNodeNameRemoveName("经办人填写预算、合同、汇款信息");
					}else if(ccp.getActionName() == null && ccp.getNodeNameRemoveName().contains("台工会财务签字")){
						ccp.setNodeNameRemoveName("台工会财务票据签字");
					}else if(ccp.getActionName() == null){
						ccp.setNodeNameRemoveName(ccp.getNodeNameRemoveName());
					}
					
				}
				list.add(ccp);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		
		return list;
	}
}
