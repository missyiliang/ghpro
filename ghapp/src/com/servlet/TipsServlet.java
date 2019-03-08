package com.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.TipsDao;
import com.form.TipsForm;
import com.util.ResponseUtils;

/**
 * 办理通知
 * @author 33
 *
 */
public class TipsServlet extends HttpServlet {

	private static final long serialVersionUID = -6429572261493991755L;

	public TipsServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resq){
		String pagenum = req.getParameter("pagenum");
		JSONObject obj = new JSONObject();
		if(req.getSession().getAttribute("userid") !=null){
			Long userid = (Long) req.getSession().getAttribute("userid");
			TipsDao tdao = new TipsDao();
			tdao.readtip(userid);
			List<TipsForm>  tlist = tdao.findList(userid, pagenum);
			
			obj.put("tlist", tlist);
			req.getSession().setAttribute("tipcount",0);
			Long readcount = (Long)req.getSession().getAttribute("readcount");
			obj.put("readcount", readcount);
			obj.put("tipcount", req.getSession().getAttribute("tipcount"));
			ResponseUtils.renderJson(resq, obj.toString());
		}else{
			ResponseUtils.renderJson(resq, obj.toString());
		}
	}
	
	public void init() throws ServletException {
		
	}

}
