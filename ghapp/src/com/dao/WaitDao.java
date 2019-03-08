package com.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.form.WaitForm;

public class WaitDao extends BaseDao{

	public List<WaitForm> findWaitList(String pagenum,Long userid,String title,String workflowid){
		int pagesize = 10;
		int startsize = 1;
		int endsize = 10;
		int pagenu = new Integer(pagenum);
		if(pagenu >0){
			startsize = pagenu*pagesize;
			endsize = startsize+pagesize;
		}
		String sql ="select * from ("+
					"select * from ("+
					"select pto.WORKFLOW_ID, pto.WORKFLOW_NAME, pto.INSTANCE_ID,pto.create_time,  pto.WORKITEM_ID, " +
					"pto.TITLE, pto.FILE_NUM, pto.DEPT_NAME,pto.OID,pto.APPLICATION_TIME as APPLICATIONTIME,pto.APPLY_STATUS," +
					"pto.IS_SECOND,pto.PRO_TYPE,pto.READ_STATUS,"+
					" row_number() over(partition by pto.instance_id order by  pto.create_time desc) rn"+
					" from odbg_workitem_new pto where 1=1";
//		if(title != null && !"".equals(title)){
//			sql += " and pto.title like '%"+title+"%'";
//		}
		if(workflowid != null  && !"".equals(workflowid)){
			sql += " and pto.WORKFLOW_ID ='" + workflowid + "'";
		}
		sql += " and pto.status =40 and pto.ins_status =40 and pto.user_id =" + userid + " )"+
					" where rn=1 order by create_time desc )"+
					" where rownum <= "+endsize;
		List<WaitForm> wlist = new ArrayList<WaitForm>();			
		
		WaitForm pto = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			conn = super.getConn();
			System.out.println(sql);
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
//				public String appid;//申请ID
//				private String title;//标题
//				private String applyTime;//申请时间
//				private String centerName;//中心名称
//				private String workFlowId;//流程类型
//				private String instanceId;//流程实例ID
//				private Integer status;//狀態
				pto = new WaitForm();
				pto.setWorkFlowId(res.getString("WORKFLOW_ID"));
				pto.setAppid(res.getString("OID"));
				pto.setCenterName(res.getString("DEPT_NAME"));
				pto.setTitle(res.getString("TITLE"));
				pto.setInstanceId(res.getString("INSTANCE_ID"));
				pto.setStatus(res.getInt("APPLY_STATUS"));
				pto.setApplyTime(format.format(res.getTimestamp("APPLICATIONTIME")));
				pto.setIsSecond(res.getInt("IS_SECOND"));
				pto.setProType(res.getString("PRO_TYPE"));
				pto.setReadStatus(res.getInt("READ_STATUS"));
				
				if(pto.getWorkFlowId() != null && "7".equals(pto.getWorkFlowId())){
					if(pto.getStatus() <= 4 && (pto.getIsSecond() == null || pto.getIsSecond() != 1)){
						pto.setTitle("【请示信息】" + pto.getTitle());
					}else if(pto.getStatus() >= 4 && pto.getIsSecond() == 1){
						pto.setTitle("【活动预算】" + pto.getTitle());
					}
				}if(pto.getWorkFlowId() != null && "8".equals(pto.getWorkFlowId())){
					pto.setTitle("【取消活动】" + pto.getTitle());
				}
				if(pto.getWorkFlowId() != null && "9".equals(pto.getWorkFlowId())){
					pto.setTitle("【" + pto.getProType() + "】" + pto.getTitle());
				}
				if(pto.getStatus() != null && pto.getStatus() == -1){
					pto.setTitle("【退办结束】" + pto.getTitle());
				}
				wlist.add(pto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		return wlist;
	}
	
	
	public void editReadStatus(String instanceId){
		super.executeSQL("update odbg_workitem_new n set n.read_status=1 where n.INSTANCE_ID=?", new String[]{instanceId});
	}
	
	public int queryReadCount(String userid){
		String sql ="select count(1)"+
				" from odbg_workitem_new n where n.user_id =  " + userid +" and n.read_status=0 ";
		int c = 0;
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				c =  res.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		return c;
	}
}
