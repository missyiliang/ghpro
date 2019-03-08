package com.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.TipsDao;
import com.dao.WaitDao;
import com.form.WaitForm;
import com.util.ResponseUtils;

/**
 * 删除办理通知
 * @author 33
 *
 */
public class DelTipsServlet extends HttpServlet {

	private static final long serialVersionUID = -1944173640528875767L;

	public DelTipsServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resq){
		JSONObject obj = new JSONObject();
		String tids = req.getParameter("ids");
		TipsDao tdao = new TipsDao();
		try {
			String tid[] = tids.split(",");
			if(tid != null){
				for (int i = 0; i < tid.length; i++) {
					tdao.deltip(tid[i]);
				}
				obj.put("status", "OK");
				obj.put("msg", "删除成功!");
			}else{
				obj.put("status", "err");
				obj.put("msg", "删除失败!");
			}
			ResponseUtils.renderJson(resq, obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void init() throws ServletException {
		
	}

}
