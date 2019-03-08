package com.servlet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.CirculationProcessDao;
import com.dao.OutlayInfoDao;
import com.dao.WaitDao;
import com.form.Attach;
import com.form.CancelApply;
import com.form.CirculationProcess;
import com.form.OutlayInfo;
import com.form.PayBudget;
import com.form.RemitBill;
import com.form.WaitForm;
import com.util.ResponseUtils;

/**
 * 经费申请详情
 * @author 33
 *
 */
public class OutlayInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 2511821713381136683L;

	public OutlayInfoServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resq){
		OutlayInfoDao outLayInfoDao = new OutlayInfoDao();
		CirculationProcessDao cirProFao = new CirculationProcessDao();
		
		String instanceid = req.getParameter("instanceid");
		
		//已读
		Long readStatus = (Long)req.getSession().getAttribute("readcount");
		if(!"0".equals(readStatus)){
			WaitDao wdao = new WaitDao();
			wdao.editReadStatus(instanceid);
			if(readStatus != null && readStatus > 0){
				req.getSession().setAttribute("readcount", readStatus -1);
			}
		}
		
		//活动预算
		OutlayInfo outLayInfo = null;
		//支出预算
		List<PayBudget> payBudgetList = null;
		//汇款申请单
		List<RemitBill> remitBillList = null;
		//附件列表
		List<Attach> attachList = null;
		//流转过程
		List<CirculationProcess> list = null;
		//取消活动申请
		CancelApply cancelApply = null;
		//总金额
        BigDecimal totalPriceSum = new BigDecimal(0.00);
        totalPriceSum =  totalPriceSum.setScale(2);
        //总专项额度
        BigDecimal totalPriceLines = new BigDecimal(0.00);
        totalPriceLines =  totalPriceLines.setScale(2);
        //总事业编会员会费
        BigDecimal totalCareerVipCast = new BigDecimal(0.00);
        totalCareerVipCast =  totalCareerVipCast.setScale(2);
        //总台聘会员会费
        BigDecimal totalCctvVipCast = new BigDecimal(0.00);
        totalCctvVipCast =  totalCctvVipCast.setScale(2);
        
        String totalPriceSumStr = "";
        String totalPriceLinesStr = "";
        String totalCareerVipCastStr = "";
        String totalCctvVipCastStr = ""; 
        
        //用于前台页面的判断
      	List<String> outLayList = new ArrayList<String>();
      	
		JSONObject obj = new JSONObject();
		if(instanceid != null && instanceid != ""){
			outLayInfo = outLayInfoDao.queryByWfinstanceid(instanceid);
			if(outLayInfo != null){
				
				if(outLayInfo.getOid() != null){
					payBudgetList = outLayInfoDao.getList(outLayInfo.getOid());
					for (int i = 0; i < payBudgetList.size(); i++) {
						PayBudget eneity = payBudgetList.get(i);
			        	totalPriceSum=totalPriceSum.add(new BigDecimal(eneity.getPriceSum()));
			        	totalPriceLines = totalPriceLines.add(new BigDecimal(eneity.getPriceLines()));
			        	totalCareerVipCast = totalCareerVipCast.add(new BigDecimal(eneity.getCareerVipCast()));
			        	totalCctvVipCast = totalCctvVipCast.add(new BigDecimal(eneity.getCctvVipCast()));
					}
					
					totalPriceSumStr = totalPriceSum.setScale(2).toString();
					totalPriceLinesStr =totalPriceLines.setScale(2).toString();
					totalCareerVipCastStr = totalCareerVipCast.setScale(2).toString();
					totalCctvVipCastStr = totalCctvVipCast.setScale(2).toString();
					
					remitBillList = outLayInfoDao.getRemitBillList(outLayInfo.getOid());
					attachList = outLayInfoDao.getAttachList(outLayInfo.getOid());
					if(remitBillList.size()>0){
						//汇款申请单份数
						obj.put("remitBillSize",remitBillList.size());
					}
					if(attachList.size()>0){
						//合同附件份数
						obj.put("attachSize",attachList.size());
					}
					if(payBudgetList.size()>0){
						//预算份数
						obj.put("payBudgetListSize",1);
					}
					
					cancelApply = outLayInfoDao.getCancelByWfinstanceid(outLayInfo.getOid());
					if(cancelApply != null){
						if(cancelApply.getAppId() != null){
							outLayInfo = outLayInfoDao.queryByOid(cancelApply.getAppId());
							payBudgetList = outLayInfoDao.getList(cancelApply.getAppId());
							for (int i = 0; i < payBudgetList.size(); i++) {
								PayBudget eneity = payBudgetList.get(i);
					        	totalPriceSum=totalPriceSum.add(new BigDecimal(eneity.getPriceSum()));
					        	totalPriceLines = totalPriceLines.add(new BigDecimal(eneity.getPriceLines()));
					        	totalCareerVipCast = totalCareerVipCast.add(new BigDecimal(eneity.getCareerVipCast()));
					        	totalCctvVipCast = totalCctvVipCast.add(new BigDecimal(eneity.getCctvVipCast()));
							}
							
							totalPriceSumStr = totalPriceSum.setScale(2).toString();
							totalPriceLinesStr =totalPriceLines.setScale(2).toString();
							totalCareerVipCastStr = totalCareerVipCast.setScale(2).toString();
							totalCctvVipCastStr = totalCctvVipCast.setScale(2).toString();
							
							remitBillList = outLayInfoDao.getRemitBillList(outLayInfo.getOid());
							attachList = outLayInfoDao.getAttachList(outLayInfo.getOid());
							if(remitBillList.size()>0){
								//汇款申请单份数
								obj.put("remitBillSize",remitBillList.size());
							}
							if(attachList.size()>0){
								//合同附件份数
								obj.put("attachSize",attachList.size());
							}
						}
					}
				}
			}
			
			
			
			//流转过程
			list = cirProFao.getCirculationProcess(instanceid);
			
			for (CirculationProcess circulationProcess : list) {
				outLayList.add(circulationProcess.getNodeNameRemoveName());
			}
			
		}
		
		obj.put("outLayInfo", outLayInfo);
		obj.put("payBudgetList", payBudgetList);
		obj.put("totalPriceSumStr",totalPriceSumStr);
		obj.put("totalPriceLinesStr",totalPriceLinesStr);
		obj.put("totalCareerVipCastStr",totalCareerVipCastStr);
		obj.put("totalCctvVipCastStr",totalCctvVipCastStr);
		obj.put("remitBillList",remitBillList);
		obj.put("cancelApply",cancelApply);
		obj.put("list", list);
		obj.put("outLayList", outLayList);
		ResponseUtils.renderJson(resq, obj.toString());
	}
	
	public void init() throws ServletException {
		
	}
	
	
}
