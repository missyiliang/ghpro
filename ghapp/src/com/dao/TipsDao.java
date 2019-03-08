package com.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.form.TipsForm;

public class TipsDao extends BaseDao{

	public List<TipsForm> findList(Long userid, String pagenum){
		String sql ="select * from ( select"+
					" n.NID,n.TITLE,n.PROCESSID,n.INSTANCEID,n.NOTICEUSERID,n.NOTICEUSERNAME,n.OTICEUSERID,"+
					" n.NOTICEDATE,n.NOTICETYPE,n.USERID,n.CONTENT,n.NOTICEUSERNAME as AB,n.FILENUM "+
					" from odbg_notice n where 1=1 and n.userid =  " + userid +
					" order by  n.noticedate desc ) ";
		List<TipsForm> wlist = new ArrayList<TipsForm>();			
		
		TipsForm pto = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String protype = null;
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				pto = new TipsForm();
				pto.setWorkFlowId(res.getString("PROCESSID"));//流程id
				pto.setWfinstanceid(res.getString("INSTANCEID"));
				pto.setNid(res.getString("NID"));
				protype = res.getString("NOTICETYPE");
				if(protype.equals("1")){
					pto.setTitle("【请示信息】"+res.getString("TITLE")+res.getString("FILENUM"));
				}else if(protype.equals("2")){
					pto.setTitle("【请示信息】"+res.getString("TITLE")+res.getString("FILENUM"));
				}else if(protype.equals("3")){
					pto.setTitle("【活动预算】"+res.getString("TITLE")+res.getString("FILENUM"));
				}else if(protype.equals("4")){
					pto.setTitle("【活动预算】"+res.getString("TITLE")+res.getString("FILENUM"));
				}else if(protype.equals("5")){
					pto.setTitle("【活动预算】"+res.getString("TITLE")+res.getString("FILENUM"));
				}else if(protype.equals("6")){
					pto.setTitle("【取消活动】"+res.getString("TITLE")+res.getString("FILENUM"));
				}else if(protype.equals("7")){
					pto.setTitle("【爱心工程】"+res.getString("TITLE")+res.getString("FILENUM"));
				}
				pto.setNoticeDate(format.format(res.getTimestamp("NOTICEDATE")));
				
//				pto.setWorkFlowId(res.getString("WORKFLOW_ID"));
//				pto.setAppid(res.getString("OID"));
//				pto.setCenterName(res.getString("DEPT_NAME"));
//				pto.setTitle(res.getString("TITLE"));
//				pto.setInstanceId(res.getString("INSTANCE_ID"));
//				pto.setStatus(res.getInt("APPLY_STATUS"));
//				pto.setApplyTime(format.format(res.getTimestamp("APPLICATIONTIME")));
//				pto.setIsSecond(res.getInt("IS_SECOND"));
//				pto.setProType(res.getString("PRO_TYPE"));
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
	
	public int deltip(String tid){
		return  super.executeSQL("delete odbg_notice n where n.nid=?", new String[]{tid});
	}
	
	public int readtip(Long tid){
		return  super.executeSQL("update odbg_notice n set n.noticestatus=2 where n.userid=?", new String[]{tid+""});
	}
	
	public int findcount(Long userid){
		String sql ="select count(n.nid)"+
					" from odbg_notice n where 1=1 and n.userid =  " + userid +" and n.noticestatus =1";
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
