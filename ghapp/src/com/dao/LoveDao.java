package com.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.form.CirculationProcess;
import com.form.LoveInfo;
import com.form.WaitForm;
import com.util.LangUtils;


public class LoveDao extends BaseDao{
	
	/**
	 * 显示爱心工程详情信息
	 * @param instanceid
	 * @param Workitemid
	 * @return
	 */
	public LoveInfo getList(String instanceid){
		
		String sql = "select la.lid,la.wfinstanceid,"
					+ "la.total_code,la.channel_code,"
					+ "la.center_name,la.create_name,"
					+ "la.create_time,la.apply_date,"
					+ "la.create_code,la.phone,"
					+ "la.employee_name,la.staff_establishing,"
					+ "la.employee_sex,la.work_number,"
					+ "la.family_name,la.family_sex,"
					+ "la.employee_relation,la.consolation_project,"
					+ "la.type,la.apply_amountd,"
					+ "la.apply_amountx "
					+ "from gh_love_apply la "
					+ "where 1 = 1 ";
		
		if(instanceid != null || instanceid != ""){
			
				sql += " and la.wfinstanceid = '"+instanceid+"'";
		}
		LoveInfo loveInfo = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				loveInfo = new LoveInfo();
				loveInfo.setLid(res.getString("lid"));
				loveInfo.setInstanceId(res.getString("wfinstanceid"));
				loveInfo.setTotalCode(res.getString("total_code"));
				loveInfo.setCenterName(res.getString("center_name"));
				loveInfo.setCreateName(res.getString("create_name"));
				loveInfo.setCreateTime(format.parse(format.format(res.getDate("create_time"))));
				loveInfo.setApplyDate(res.getString("apply_date"));
				loveInfo.setCreateCode(res.getString("create_code"));
				loveInfo.setPhone(res.getString("phone"));
				loveInfo.setEmployeeName(res.getString("employee_name"));
				loveInfo.setStaffEstablishing(res.getString("staff_establishing"));
				loveInfo.setEmployeeSex(res.getString("employee_sex"));
				loveInfo.setWorkNumber(res.getString("work_number"));
				loveInfo.setFamilyName(res.getString("family_name"));
				loveInfo.setFamilySex(res.getString("family_sex"));
				loveInfo.setEmployeeRelation(res.getString("employee_relation"));
				loveInfo.setConsolationProject(res.getString("consolation_project"));
				loveInfo.setApplyAmountd(res.getString("apply_amountd"));
				loveInfo.setApplyAmountx(res.getBigDecimal("apply_amountx").setScale(2).toString());
				loveInfo.setType(res.getInt("type"));
				
				//爱心工程 
				if(loveInfo.getType() == 1){ //爱心工程”慰问金申领表（新、生、故）
					loveInfo.setTitle(loveInfo.getEmployeeName()+"("+loveInfo.getWorkNumber()+")"+"爱心工程慰问金申领");
				}
				if(loveInfo.getType() == 2){ //“爱心工程”慰问金申领表（台聘退休慰问）
					loveInfo.setTitle(loveInfo.getEmployeeName()+"("+loveInfo.getWorkNumber()+")"+"爱心工程慰问金申领");
				}
				if(loveInfo.getType() == 3){ //“爱心工程”慰问金申领表（在职去世）
					loveInfo.setTitle(loveInfo.getEmployeeName()+"("+loveInfo.getWorkNumber()+")"+"爱心工程慰问金申领");
				}
				if(loveInfo.getType() == 4){ //“爱心工程”慰问金申领表（因公殉职）
					loveInfo.setTitle(loveInfo.getEmployeeName()+"("+loveInfo.getWorkNumber()+")"+"爱心工程慰问金申领");
				}
				
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			System.err.println("日期格式转化有问题");
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		
	
		return loveInfo;
	}
	
	/**
	 * 
	 * @param pagenum 分页页码
	 * @param workflowid 流程类型
	 * 
	 * @param tilte 标题
	 * @param userid 用户ID
	 * @return
	 */
	public List<WaitForm> findallList(String pagenum,String workflowid,String tilte,Long userid,Map<String, Object> parameterMap,String flag){
		int pagesize = 10;
		int startsize = 1;
		int endsize = 10;
		int pagenu = new Integer(pagenum);
		if(pagenu >0){
			startsize = pagenu*pagesize;
			endsize = startsize+pagesize;
		}
		String sql = "select * from ( select * from (select"+
					" i.INSTANCE_ID,i.WORKFLOW_ID,i.TITLE,i.INITATOR_NAME,i.STATUS,i.CREATE_TIME,a.LID OID,"+
					" a.TOTAL_CODE,a.CHANNEL_CODE,i.PRO_TYPE,a.CENTER_NAME,a.CREATE_TIME as APPLICATIONTIME,"+
					" a.APPLY_STATUS,a.APPLY_DATE,"+
					" row_number() over(partition by i.instance_id order by i.create_time desc) rn "+
					" from odbg_instance i left join GH_LOVE_APPLY a on i.instance_id = a.wfinstanceid "+
					" where  i.status != 0 and i.workflow_id= "+workflowid;
		if(tilte != null && !"".equals(tilte)){
			sql += 	" and i.title like '%" + tilte + "%'";
		}
		if(flag != null &&  "1".equals(flag)){
			sql += " and i.apply_status = " + 8;
		}
		if(flag != null &&  "2".equals(flag)){
			sql += " and i.apply_status = " + 3;
		}
		
		
		String deptCode = (String) parameterMap.get("deptCode");
        String upperDeptcode = (String) parameterMap.get("upperDeptcode");//中心编码
        
        String upperDeptCode = (String) parameterMap.get("upperDeptCode");//中心编码
        
        String userId2 = (String) parameterMap.get("userId2");
        String upperCenterCode = (String) parameterMap.get("upperCenterCode");
		
        
        if(LangUtils.isNotEmpty(upperCenterCode)){
        	sql += " and (i.initator_id like '%" + userId2 + "%' or i.upper_deptcode in('" + upperCenterCode + "') ) ";
        }
        
        
        if(LangUtils.isNotEmpty(upperDeptcode)) {
            String upperDeptcodes[] = upperDeptcode.split(",");
            StringBuffer deptIds = new StringBuffer();
            for(String ids : upperDeptcodes) {
                deptIds.append("'" + ids + "',");
            }
            deptIds.delete(deptIds.length() - 1, deptIds.length());
            sql += " and (i.initator_id like '%" + userid + "%' or i.upper_deptcode in(" + deptIds + ") ) ";
        }else if(LangUtils.isNotEmpty(upperDeptCode)){ //中心编码
        	String upperDeptcodes[] = upperDeptCode.split(",");
            StringBuffer deptIds = new StringBuffer();
            for(String ids : upperDeptcodes) {
                deptIds.append("'" + ids + "',");
            }
            deptIds.delete(deptIds.length() - 1, deptIds.length());
            sql += " and (i.initator_id like '%" + userid + "%' or i.upper_deptcode in(" + deptIds + ") ) ";
        }else if(LangUtils.isNotEmpty(deptCode)) {
            String deptCodes[] = deptCode.split(",");
            StringBuffer deptIds = new StringBuffer();
            for(String ids : deptCodes) {
                deptIds.append("'" + ids + "',");
            }
            deptIds.delete(deptIds.length() - 1, deptIds.length());
            sql += " and (i.initator_id like '%" + userid + "%' or i.dept_code in(" + deptIds + ") ) ";
        } else{
        	
        }
        
    	sql +=	" )where 1=1 and rn=1 order by create_time desc ) "+
					" where rownum <= " + endsize;
		
		List<WaitForm> plist = new ArrayList<WaitForm>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		WaitForm pto = null;
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
//				private Integer isSecond;//是否是第二弊遍流程
//				private String proType;//项目类型
				pto = new WaitForm();
				pto.setAppid(res.getString("OID"));
				pto.setInstanceId(res.getString("INSTANCE_ID"));
				pto.setStatus(res.getInt("APPLY_STATUS"));
				
				pto.setTitle("【"+res.getString("PRO_TYPE")+"】" + res.getString("TITLE"));
				
				if(pto.getStatus() != null && pto.getStatus() == -1){
					pto.setTitle("【退办结束】" + res.getString("TITLE"));
				}
//				if(pto.getIsCancel() != 2){
//					if(pto.getStatus() <= 4 && (pto.getIsSecond() == null || pto.getIsSecond() != 1)){
//						pto.setTitle("【请示信息】" + res.getString("TITLE"));
//					}else if(pto.getStatus() >= 4 && pto.getIsSecond() == 1){
//						pto.setTitle("【活动预算】" + res.getString("TITLE"));
//					}
//				}else if(pto.getIsCancel() != null && pto.getIsCancel() == 2){
//					pto.setTitle("【取消活动】" + res.getString("TITLE"));
//				}
				
				pto.setApplyTime(format.format(res.getTimestamp("APPLICATIONTIME")));
				pto.setCenterName(res.getString("CENTER_NAME"));
				plist.add(pto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		return plist;
	}
	
	public List<WaitForm> finddoingList(String pagenum,String workflowid,String tilte,Long userid){
		
		/*String sql = "select * from ( select * from (select"+
					" wf.WORKFLOW_ID, wf.INSTANCE_ID,wf.WORKITEM_ID,wf.TITLE,"+
					" wf.APPLICATION_TIME as APPLICATIONTIME,wf.PRO_TYPE,wf.CENTER_NAME,wf.CHANNEL_CODE,"+
					" wf.APPLY_STATUS,wf.OID,wf.IS_SECOND,"+
					" row_number() over(partition by wf.instance_id order by wf.create_time desc) rn "+
					" from odbg_workitem_all wf where 1=1  "+
					" and wf.ins_status =40  and wf.status =100 and wf.user_id =1201 )"+
					" where 1=1 and rn=1 order by create_time desc )"+
					" where  rownum <= 10";*/
		String sql = "select * from (select"+
				" wf.WORKFLOW_ID, wf.INSTANCE_ID,wf.WORKITEM_ID,wf.TITLE,"+
				" wf.APPLICATION_TIME as APPLICATIONTIME,wf.PRO_TYPE,wf.CENTER_NAME,wf.CHANNEL_CODE,"+
				" wf.APPLY_STATUS,wf.OID,wf.IS_SECOND,wf.CREATE_TIME,"+
				" row_number() over(partition by wf.instance_id order by wf.create_time desc) rn "+
				" from odbg_workitem_all wf where 1=1  "+
				" and wf.ins_status =40  and wf.status =100 and wf.user_id =1201 )"+
				" where 1=1 and rn=1 order by create_time desc ";
		
		List<WaitForm> plist = new ArrayList<WaitForm>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		WaitForm pto = null;
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
//				private Integer isSecond;//是否是第二弊遍流程
//				private String proType;//项目类型
				pto = new WaitForm();
//				pto.setAppid(res.getString("OID"));
//				pto.setInstanceId(res.getString("INSTANCE_ID"));
//				pto.setIsSecond(res.getInt("IS_SECOND"));
//				pto.setStatus(res.getInt("APPLY_STATUS"));
//				pto.setApplyTime(format.format(res.getTimestamp("APPLICATIONTIME")));
//				pto.setCenterName(res.getString("CENTER_NAME"));
				
				
				pto.setWorkFlowId(res.getString("WORKFLOW_ID"));
				pto.setAppid(res.getString("OID"));
				pto.setCenterName(res.getString("CENTER_NAME"));
				pto.setTitle(res.getString("TITLE"));
				pto.setInstanceId(res.getString("INSTANCE_ID"));
				pto.setStatus(res.getInt("APPLY_STATUS"));
				pto.setApplyTime(format.format(res.getTimestamp("APPLICATIONTIME")));
				pto.setIsSecond(res.getInt("IS_SECOND"));
				pto.setProType(res.getString("PRO_TYPE"));
				
				if(pto.getWorkFlowId() != null && "7".equals(pto.getWorkFlowId())){
					if(pto.getStatus() <= 4 && (pto.getIsSecond() == null || pto.getIsSecond() != 1)){
						pto.setTitle("【请示信息】" + pto.getTitle());
					}else if(pto.getStatus() >= 4 && pto.getIsSecond() == 1){
						pto.setTitle("【活动预算】" + pto.getTitle());
					}
				}
				if(pto.getWorkFlowId() != null && "8".equals(pto.getWorkFlowId())){
					pto.setTitle("【取消活动】" + pto.getTitle());
				}
				if(pto.getWorkFlowId() != null && "9".equals(pto.getWorkFlowId())){
					pto.setTitle("【" + pto.getProType() + "】" + pto.getTitle());
				}
				if(pto.getStatus() != null && pto.getStatus() == -1){
					pto.setTitle("【退办结束】" + pto.getTitle());
				}
				plist.add(pto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		return plist;
	}
}
