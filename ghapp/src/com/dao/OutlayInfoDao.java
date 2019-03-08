package com.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.form.Attach;
import com.form.CancelApply;
import com.form.OutlayInfo;
import com.form.PayBudget;
import com.form.RemitBill;

/**
 * 活动详情
 * @author admin
 *
 */
public class OutlayInfoDao extends BaseDao{
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 通过流程实例id获取活动预算实体
	 * @param wfinstanceid
	 * @return
	 */
	public OutlayInfo queryByWfinstanceid(String wfinstanceid){
		String sql = "select oa.wfinstanceid,"
					+ "oa.oid,oa.total_code,oa.channel_code,"
					+ "oa.center_name,oa.phone,oa.apply_date,"
					+ "oa.join_num,oa.pro_type,"
					+ "oa.ask_name,oa.ask_loc,"
					+ "oa.pay_budget_name,oa.cash_num,"
					+ "nvl2(oa.cash_sum,oa.cash_sum,0) cashSum,oa.bank_num,"
					+ "oa.check_num,oa.outlay_type,"
					+ "oa.pay_type,oa.create_time,"
					+ "oa.create_code,oa.create_name,"
					+ "oa.gh_start_time,oa.gh_end_time "
					+ "from gh_outlay_apply oa "
					+ "where 1=1 ";
		if(wfinstanceid != null && wfinstanceid != ""){
			sql += " and oa.wfinstanceid= '"+wfinstanceid+"'";
		}
		OutlayInfo outLayInfo = null;
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				outLayInfo = new OutlayInfo();
				outLayInfo.setWfinstanceid(res.getString("wfinstanceid"));
				outLayInfo.setOid(res.getString("oid"));
				outLayInfo.setTotalCode(res.getString("total_code"));
				outLayInfo.setChannelCode(res.getString("channel_code"));
				outLayInfo.setCenterName(res.getString("center_name"));
				outLayInfo.setPhone(res.getString("phone"));
				outLayInfo.setApplyDate(res.getString("apply_date"));
				outLayInfo.setJoinNum(res.getInt("join_num"));
				outLayInfo.setProType(res.getString("pro_type"));
				outLayInfo.setAskName(res.getString("ask_name"));
				outLayInfo.setAskLoc(res.getString("ask_loc"));
				outLayInfo.setPayBudgetName(res.getString("pay_budget_name"));
				outLayInfo.setCashNum(res.getString("cash_num"));
				outLayInfo.setCashSum(res.getBigDecimal("cashSum").setScale(2).toString());
				outLayInfo.setBank_num(res.getString("bank_num"));
				outLayInfo.setCheckNum(res.getString("check_num"));
				outLayInfo.setOutlayType(res.getString("outlay_type"));
				outLayInfo.setPayType(res.getString("pay_type"));
				outLayInfo.setCreateTime(format.parse(format.format(res.getDate("create_time"))));
				outLayInfo.setCreateCode(res.getString("create_code"));
				outLayInfo.setCreateName(res.getString("create_name"));
				outLayInfo.setGhStartTime(res.getString("gh_start_time"));
				outLayInfo.setGhEndTime(res.getString("gh_end_time"));
				
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
		
		return outLayInfo;
		
	}
	
	/**
	 * 根据appid获取支出预算信息
	 * @param appid
	 * @return
	 */
	public List<PayBudget> getList(String appid){
		
		String sql = "select pb.pid,pb.appid,"
					+ "pb.seq_code,pb.title,"
					+ "pb.num,pb.unit,pb.price,"
					+ "pb.price_sum,pb.price_lines,"
					+ "pb.career_vip_cast,pb.cctv_vip_cast,"
					+ "pb.settlement_type,pb.direction "
					+ "from gh_pay_budget pb "
					+ "where 1=1 ";
		if(appid != null && appid != ""){
			sql += " and pb.appid= '"+appid+"'";
		}
		List<PayBudget> payBudgetList = new ArrayList<PayBudget>();
		PayBudget payBudget = null;
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				payBudget = new PayBudget();
				payBudget.setPid(res.getString("pid"));
				payBudget.setAppId(res.getString("appid"));
				payBudget.setSeqCode(res.getString("seq_code"));
				payBudget.setTitle(res.getString("title"));
				payBudget.setNum(res.getInt("num"));
				payBudget.setUnit(res.getString("unit"));
				payBudget.setPrice(res.getBigDecimal("price").setScale(2).toString());
				payBudget.setPriceSum(res.getBigDecimal("price_sum").setScale(2).toString());
				payBudget.setPriceLines(res.getBigDecimal("price_lines").setScale(2).toString());
				payBudget.setCareerVipCast(res.getBigDecimal("career_vip_cast").setScale(2).toString());
				payBudget.setCctvVipCast(res.getBigDecimal("cctv_vip_cast").setScale(2).toString());
				payBudget.setSettlementType(res.getString("settlement_type"));
				payBudget.setDirection(res.getString("direction"));
				
				if(payBudget.getTitle()!= null){
					if(payBudget.getTitle().length() > 6){
						payBudget.setTitle(payBudget.getTitle().substring(0, 6));
					}
				}
				payBudgetList.add(payBudget);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		
		return payBudgetList;
		
	}
	
	/**
	 * 根据appid获取汇款申请单信息
	 * @param appid
	 * @return
	 */
	public List<RemitBill> getRemitBillList(String appid){
		
		String sql = "select rb.rid,rb.appid,"
					+ "rb.remit_center_name,rb.recevie_name,"
					+ "rb.remit_cost,rb.recevie_bank_name,"
					+ "rb.remit_use,rb.recevie_bank_card,"
					+ "rb.remit_budget_num "
					+ "from gh_remit_bill rb "
					+ "where 1=1 ";
		if(appid != null && appid != ""){
				sql += " and rb.appid= '"+appid+"'";
		}
		
		List<RemitBill> remitBillList = new ArrayList<RemitBill>();
		RemitBill remitBill = null;
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				remitBill = new RemitBill();
				remitBill.setRid(res.getString("rid"));
				remitBill.setAppId(res.getString("appid"));
				remitBill.setRemitCenterName(res.getString("remit_center_name"));
				remitBill.setRecevieName(res.getString("recevie_name"));
				remitBill.setRemitCost(res.getBigDecimal("remit_cost").setScale(2).toString());
				remitBill.setRecevieBankName(res.getString("recevie_bank_name"));;
				remitBill.setRemitUse(res.getString("remit_use"));
				remitBill.setRecevieBankCard(res.getString("recevie_bank_card"));
				remitBill.setRemitBudgetNum(res.getString("remit_budget_num"));
				
				remitBillList.add(remitBill);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		
		return remitBillList;
		
	}
	
	/**
	 * 根据appid获取上传的附件
	 * @param appid
	 * @return
	 */
	public List<Attach> getAttachList(String appid){
		String sql = "select a.aid, a.att_name, "
					+ "a.up_name, a.up_time,"
					+ " a.url, a.appid "
					+ "from gh_attach a "
					+ "where 1=1  and a.att_type = 1 ";
		if(appid != null && appid != ""){
			sql += " and a.appid = '"+appid+"'";
		}
		
		sql += " order by a.up_time desc";
		
		List<Attach> attachList = new ArrayList<Attach>();
		Attach  attach = null;
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				attach = new Attach();
				attach.setAid(res.getString("aid"));
				attach.setAttName(res.getString("att_name"));
				attach.setUpName(res.getString("up_name"));
				attach.setUpTime(format.format(res.getDate("up_time")));
				attach.setUrl(res.getString("url"));
				attach.setAppId(res.getString("appid"));
				
				attachList.add(attach);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		return attachList ;
		
	}
	
	
	/**
	 * 根据流程id查询取消活动申请
	 * @param wfinstanceid
	 * @return
	 */
	public CancelApply getCancelByWfinstanceid(String appId){
		String sql = "select ca.cid,ca.appid,"
					+ "ca.wfinstanceid,ca.title,"
					+ "ca.apply_status,ca.dept_name,"
					+ "ca.apply_name,ca.cancel_why,"
					+ "ca.create_time,ca.create_code "
					+ "from gh_cancel_apply ca "
					+ "where 1=1 ";
		
		if(appId != null && appId != ""){
			sql += " and ca.appid = '"+appId+"'";
		}
		
		sql += " order by ca.create_time desc";
		
		CancelApply cancelApply = null;
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				
				cancelApply = new CancelApply();
				cancelApply.setCid(res.getString("cid"));
				cancelApply.setAppId(res.getString("appid"));
				cancelApply.setWfinstanceId(res.getString("wfinstanceid"));
				cancelApply.setTitle(res.getString("title"));
				cancelApply.setApplyStatus(res.getInt("apply_status"));
				cancelApply.setDeptName(res.getString("dept_name"));
				cancelApply.setApplyName(res.getString("apply_name"));
				cancelApply.setCancelWhy(res.getString("cancel_why"));
				cancelApply.setCreateTime(format.format(res.getDate("create_time")));
				cancelApply.setCreateCode(res.getString("create_code"));
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		
		return cancelApply;
		
	}
	
	/**
	 * 根据取消活动申请的appid获取活动申请的数据
	 * @param oid
	 * @return
	 */
	public OutlayInfo queryByOid(String oid){
		String sql = "select oa.wfinstanceid,"
				+ "oa.oid,oa.total_code,oa.channel_code,"
				+ "oa.center_name,oa.phone,oa.apply_date,"
				+ "oa.join_num,oa.pro_type,"
				+ "oa.ask_name,oa.ask_loc,"
				+ "oa.pay_budget_name,oa.cash_num,"
				+ "nvl2(oa.cash_sum,oa.cash_sum,0) cashSum,oa.bank_num,"
				+ "oa.check_num,oa.outlay_type,"
				+ "oa.pay_type,oa.create_time,"
				+ "oa.create_code,oa.create_name,"
				+ "oa.gh_start_time,oa.gh_end_time "
				+ "from gh_outlay_apply oa "
				+ "where 1=1 ";
		
		if(oid != null && oid != ""){
			sql += " and oa.oid= '"+oid+"'";
		}
		sql += " order by oa.create_time desc";
		
		OutlayInfo outLayInfo = null;
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				outLayInfo = new OutlayInfo();
				outLayInfo.setWfinstanceid(res.getString("wfinstanceid"));
				outLayInfo.setOid(res.getString("oid"));
				outLayInfo.setTotalCode(res.getString("total_code"));
				outLayInfo.setChannelCode(res.getString("channel_code"));
				outLayInfo.setCenterName(res.getString("center_name"));
				outLayInfo.setPhone(res.getString("phone"));
				outLayInfo.setApplyDate(res.getString("apply_date"));
				outLayInfo.setJoinNum(res.getInt("join_num"));
				outLayInfo.setProType(res.getString("pro_type"));
				outLayInfo.setAskName(res.getString("ask_name"));
				outLayInfo.setAskLoc(res.getString("ask_loc"));
				outLayInfo.setPayBudgetName(res.getString("pay_budget_name"));
				outLayInfo.setCashNum(res.getString("cash_num"));
				outLayInfo.setCashSum(res.getBigDecimal("cashSum").setScale(2).toString());
				outLayInfo.setBank_num(res.getString("bank_num"));
				outLayInfo.setCheckNum(res.getString("check_num"));
				outLayInfo.setOutlayType(res.getString("outlay_type"));
				outLayInfo.setPayType(res.getString("pay_type"));
				outLayInfo.setCreateTime(format.parse(format.format(res.getDate("create_time"))));
				outLayInfo.setCreateCode(res.getString("create_code"));
				outLayInfo.setCreateName(res.getString("create_name"));
				outLayInfo.setGhStartTime(res.getString("gh_start_time"));
				outLayInfo.setGhEndTime(res.getString("gh_end_time"));
				
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
		
		return outLayInfo;
	}
	
}
