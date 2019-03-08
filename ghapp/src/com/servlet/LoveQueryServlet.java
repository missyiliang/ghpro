package com.servlet;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.LoveDao;
import com.dao.OutlayDao;
import com.dao.UserDao;
import com.dao.WaitDao;
import com.form.OdBgInstance;
import com.form.OdDept;
import com.form.OdUserForm;
import com.form.WaitForm;
import com.util.BaseUtils;
import com.util.LangUtils;
import com.util.ResponseUtils;

/**
 * 爱心工程查询
 * @author 33
 *
 */
public class LoveQueryServlet extends HttpServlet {

	private static final long serialVersionUID = -8102564214988558189L;

	public LoveQueryServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resq){
//		String pagenum = req.getParameter("pagenum");
//		Long userid =  (Long)req.getSession().getAttribute("userid");
//		String centercode = (String)req.getSession().getAttribute("centerCode");
//		//userid= 7595l;
//		//centercode="jgdw";
//		String title  = req.getParameter("title");
		
		resq.setCharacterEncoding("UTF-8");
		resq.setContentType("text/html;charset=UTF-8");
		String pagenum = req.getParameter("pagenum");
		Long userid =  (Long)req.getSession().getAttribute("userid");
		
		UserDao userDao = new UserDao();
		OdUserForm odUserForm = null;
		Map parameterMap = BaseUtils.setSearchParameter(req);// 设置查询参数
		
		if(userid != null){
			odUserForm = userDao.getViewInfo(userid);
			String postCode = odUserForm.getOdUser().getPostStr();// 判断是什么岗位
	        String uppperCode1 = odUserForm.getOdUser().getUpppderCodeStr();//中心codeStr
	        String upperDeptCode = null;
	        
	        if(LangUtils.isNotEmpty(postCode)) {
	            List<OdDept> depts = new ArrayList<OdDept>();
	            depts.addAll(odUserForm.getOdUser().getDepts());// 得到当前登录人的基础信息
	            
	            String deptId = String.valueOf(depts.get(0).getDeptId());//部门的id
	            String deptCode = odUserForm.getOdUser().getDeptCodeStr();// 部门编码的str
	            //中心名称
	            upperDeptCode = depts.get(0).getUpperdepCode();
	            
	            
	            // 如果是台 则统计所有的中心 或者管理员记录 
	            if(postCode.indexOf("tai") != -1||postCode.indexOf("ghqtaxgcsqcx") != -1||( null!= odUserForm && null!=odUserForm.getOdUser() && null!=odUserForm.getOdUser().getIsAdminRole() &&odUserForm.getOdUser().getIsAdminRole()==1)) {
	                
	                
	            } else if(postCode.indexOf("zhongxin") != -1) {// 如果是中心 则统计所在中心的全部部门合同记录
	                String upperDeptcode2[] = uppperCode1.split(",");
	                StringBuffer upperCode = new StringBuffer();
	                Map<String, Object> map1 = new HashMap<String, Object>();
	                for(String upperDeptcode : upperDeptcode2) {
	                    
	                	List<OdBgInstance> oList = userDao.getDeptByUpserDept(upperDeptcode);
	                    upperCode.append(upperDeptcode + ",");
	                    map1.put(upperDeptcode, upperDeptcode);
	                    if(!map1.containsKey(upperDeptcode)) {
	                        upperCode.append(upperDeptcode + ",");
	                        
	                    }
	                    if(LangUtils.isNotEmpty(oList)) {
	                        for(OdBgInstance bg : oList) {
	                            if(!map1.containsKey(bg.getDeptCode())) {
	                                upperCode.append(bg.getDeptCode() + ",");
	                                
	                            }
	                            map1.put(bg.getDeptCode(), bg.getDeptCode());
	                        }
	                    }
	                }
	                
	                upperCode.delete(upperCode.length() - 1, upperCode.length());
	                parameterMap.put("upperDeptcode", upperCode.toString());
	            } else {
	                parameterMap.put("deptCode", deptCode);
	                parameterMap.put("upperDeptCode", upperDeptCode);
	            }
	            parameterMap.put("userId", userid.toString());
	        }else{
	       	 	 String upperDeptname = "";
	         	 String upperCenterCode = "";
	         	 // 设置用户部门相关信息
	             if(LangUtils.isNotEmpty(odUserForm.getOdUser().getDepts())) {
	                 List<OdDept> depts = new ArrayList<OdDept>();
	                 depts.addAll(odUserForm.getOdUser().getDepts());
	                 // 设置部门id
	                 upperCenterCode = depts.get(0).getUpperdepCode();
	                 upperDeptname = depts.get(0).getUpperdepName();
	             }
	         	 parameterMap.put("userId2", userid.toString());
	         	 parameterMap.put("upperCenterCode", upperCenterCode);
	        }
		}
		
		
		
		
//		String centercode = (String)req.getSession().getAttribute("centerCode");
		String title  = req.getParameter("title");
		if(title != null && !"".equals(title)){
			try {
				title = new String(title.getBytes("ISO8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/****全部****/
		LoveDao oDao = new LoveDao();
		
		OutlayDao lDao = new OutlayDao();
		List<WaitForm> allList = oDao.findallList(pagenum, "9", title, userid,parameterMap, null);
		
		/****待审批****/
		WaitDao wDao = new WaitDao();
		List<WaitForm> waitList = wDao.findWaitList(pagenum, userid, title, "9");
		
		/****审批中****/
		List<WaitForm> doingList = lDao.finddoingList(pagenum, "9", title, userid);
		
		/****待报销****/
		List<WaitForm> bxList = oDao.findallList(pagenum, "9", title, userid,parameterMap, "2");
		
		JSONObject obj = new JSONObject();
		obj.put("allList", allList);
		obj.put("waitList", waitList);
		obj.put("doingList", doingList);
		obj.put("bxList", bxList);
		obj.put("title", title);
		obj.put("tipcount", req.getSession().getAttribute("tipcount"));
		Long readcount = (Long)req.getSession().getAttribute("readcount");
		obj.put("readcount", readcount);

		ResponseUtils.renderJson(resq, obj.toString());
	}
	
	public void init() throws ServletException {
		
	}

}
