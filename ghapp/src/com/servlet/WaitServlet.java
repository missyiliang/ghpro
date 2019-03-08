package com.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.TipsDao;
import com.dao.UserDao;
import com.dao.WaitDao;
import com.form.WaitForm;
import com.util.ResponseUtils;

/**
 * 代办列表
 * @author 33
 *
 */
public class WaitServlet extends HttpServlet {
	private static final long serialVersionUID = 8253931111257595193L;


	public WaitServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resq){
		WaitDao wDao = new WaitDao();
		String pagenum = req.getParameter("pagenum");
		String loginname = req.getParameter("userId");
		Long userid = null;
		Object[] user = null;
		String  ucenterCode=null;
		long readcount =0;
		if(loginname == null || "".equals(loginname) || "null".equals(loginname)){
			userid =  (Long)req.getSession().getAttribute("userid");
			ucenterCode = (String)req.getSession().getAttribute("centerCode");
			readcount = (Long)req.getSession().getAttribute("readcount");
		}else{
			UserDao uDao = new UserDao();
			user = uDao.getUserid(loginname);
			userid = (Long)user[0];
			ucenterCode = user[1].toString();
			readcount = wDao.queryReadCount(userid+"");
			req.getSession().setAttribute("readcount", readcount);
		}
		
		
//		String loginname ="00207232";
//		UserDao uDao = new UserDao();
//		Object[] user = uDao.getUserid(loginname);
		if(userid ==null){
			JSONObject obj = new JSONObject();
			obj.put("errorview", "yes");
			ResponseUtils.renderJson(resq, obj.toString());
		}else{
			//Long userid = (Long)user[0];
			
			req.getSession().setAttribute("userid", userid);
			req.getSession().setAttribute("centerCode", ucenterCode);
			//req.getSession().setAttribute("loginame", loginname);
			
			TipsDao tdao = new TipsDao();
			int  c = tdao.findcount(userid);
			req.getSession().setAttribute("tipcount", c);
			
			List<WaitForm> wlist = wDao.findWaitList(pagenum,userid,null,null);
			
			JSONObject obj = new JSONObject();
			obj.put("wlist", wlist);
			obj.put("tipcount", c);
			obj.put("readcount", readcount);
			ResponseUtils.renderJson(resq, obj.toString());
		}
		
	}
	
	public void init() throws ServletException {
		
	}

}
