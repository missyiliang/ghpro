package com.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.CirculationProcessDao;
import com.dao.LoveDao;
import com.dao.WaitDao;
import com.form.CirculationProcess;
import com.form.LoveInfo;
import com.form.WaitForm;
import com.util.ResponseUtils;

/**
 * 爱心工程详情
 * @author 33
 *
 */
public class LoveInfoServlet extends HttpServlet {

	private static final long serialVersionUID = -9173210343327941028L;

	public LoveInfoServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resq){
		
		LoveDao loveDao = new LoveDao();
		CirculationProcessDao cirProFao = new CirculationProcessDao();
		
//		String instanceid = "8aef00a4682ba206016836add5850003";
//		Integer Workitemid = 1467664;
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
		
		
		LoveInfo loveInfo = null;
		List<CirculationProcess> list = null;
		
		//用于前台页面的判断
		List<String> loveInfoList = new ArrayList<String>();
		
		if(instanceid != null || instanceid != ""){
			
			loveInfo = loveDao.getList(instanceid);
			//流转过程
			list = cirProFao.getCirculationProcess(instanceid);
			
			for (CirculationProcess circulationProcess : list) {
				loveInfoList.add(circulationProcess.getNodeNameRemoveName());
			}
		}
		
		JSONObject obj = new JSONObject();
		obj.put("loveInfo", loveInfo);
		obj.put("list", list);
		obj.put("loveInfoList", loveInfoList);
		ResponseUtils.renderJson(resq, obj.toString());
		
		
	}
	
	public void init() throws ServletException {
		
	}

}
