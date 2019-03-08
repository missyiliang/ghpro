package com.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.constant.Const;
import com.form.LoveInfo;
import com.form.OdBgInstance;
import com.form.OdDept;
import com.form.OdDeptVo;
import com.form.OdPost;
import com.form.OdPostVo;
import com.form.OdRole;
import com.form.OdRoleVo;
import com.form.OdUser;
import com.form.OdUserForm;
import com.form.OdUserVo;
import com.form.PayBudget;
import com.util.Converter;
import com.util.LangUtils;


public class UserDao extends BaseDao{

	public Object[] getUserid(String loginname){
		String sql ="select t.USERID,d.SIGNCODE from ODBG_USER t,ODBG_DEPT_USER du,ODBG_DEPT d where" +
				" t.userid = du.user_id and du.dept_id = d.dept_id" +
				" and t.LOGINNAME='"+loginname+"'";// and d.upperdep_code in ('xzxt','jmxt','jyxt','jsxt','tsdw','qtdw')
		
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			Object[] obj = null;
			while(res != null && res.next()){
				obj = new Object[2];
				obj[0] = res.getLong("USERID");
				obj[1] = res.getString("SIGNCODE");
				return obj;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		return null;
	}
	
	
	/*//根据id获取当前用户数据
	public OdUser findById(Integer id) {
		String sql = "select * from odbg_user u where 1=1 ";
		if(id != null ){
			sql += " and u.userid="+id;
		}
		OdUser odUser = null;
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				odUser = new OdUser();
				odUser.setUserid(res.getInt("userid"));
				
				
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
		
	}*/
	
	/**
	 * 根据用户id获取用户信息
	 * @param userid
	 * @return
	 */
	public OdUser findById(Long userid){
		String sql = "select * From odbg_user u where 1=1 and u.delete_flag=0";
		if(userid != null){
			sql += " and u.userid = "+userid;
		}
		
		OdUser odUser = null;
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				odUser = new OdUser();
				odUser.setUserid(res.getInt("USERID"));
				odUser.setLoginname(res.getString("LOGINNAME"));
				odUser.setUsername(res.getString("USERNAME"));
				odUser.setUserId2(res.getString("USERID2"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		
		return odUser;
	}
	
	/**
	 * 根据用户的id获取用户所在部门
	 * @param userid
	 * @return
	 */
	public List<OdDeptVo> findDeptSqlUserId(Long userid){
		String sql = "select d.dept_id deptId,"
					+ "d.name name,d.signcode signcode,"
					+ " d.upperdep_id upperdepId, "
					+ "d.upperdep_code upperdepCode, "
					+ "d.upperdep_name upperdepName, ud.user_id userid "
					+ "from odbg_dept_user ud "
					+ "left join odbg_dept d "
					+ "on ud.dept_id = d.dept_id "
					+ "where 1 = 1 ";
		if(userid != null){
			sql += " and ud.user_id= "+userid;
		}
			sql += " order by ud.dept_user_id";
			
			List<OdDeptVo> list = new ArrayList<OdDeptVo>();
			OdDeptVo  odDeptVo = null;
			try {
				conn = super.getConn();
				p = conn.prepareStatement(sql);
				res = p.executeQuery();
				while(res != null && res.next()){
					odDeptVo = new OdDeptVo();
					odDeptVo.setDeptId(res.getInt("deptId"));
					odDeptVo.setName(res.getString("name"));
					odDeptVo.setSigncode(res.getString("signcode"));
					odDeptVo.setUpperdepId(res.getInt("upperdepId"));
					odDeptVo.setUpperdepCode(res.getString("upperdepCode"));
					odDeptVo.setUpperdepName(res.getString("upperdepName"));
					odDeptVo.setUserid(res.getInt("userid"));
					
					list.add(odDeptVo);
				}
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				super.closeAll(conn, p, res);
			}
			
			return list;
	}
	
	/**
	 * 获取当前用户所属的角色
	 * @param userid
	 * @return
	 */
	public List<OdRoleVo> findRoleSqlUserId(Long userid){
		String sql = "select  ur.role_id roleId ,"
				+ "r.name name,ur.user_id userid  "
				+ "from odbg_role_user ur "
				+ "left join odbg_role r "
				+ "on  ur.role_id=r.role_id "
				+ "where 1=1 ";
		if(userid != null){
			sql += "and  ur.user_id="+userid;
		}
		List<OdRoleVo> list = new ArrayList<OdRoleVo>();
		OdRoleVo odRoleVo = null;
		try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				odRoleVo = new OdRoleVo();
				odRoleVo.setRoleId(res.getInt("roleId"));
				odRoleVo.setName(res.getString("name"));
				odRoleVo.setUserid(res.getInt("userid"));
				
				list.add(odRoleVo);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
		
		return list;
	}
	
	/**
	 * 获取当前用户所属岗位
	 * @param userid
	 * @return
	 */
	 public List<OdPostVo> findPostSimpleSqlUserId2(Long userid){
		 String sql = "select up.post_id postId,"
		 		+ "p.code code,p.name name,"
		 		+ "up.user_id userid "
		 		+ "from odbg_post_user up, odbg_post p "
		 		+ "where 1 = 1 and up.post_id = p.post_id ";
		 if(userid != null){
			 sql += " and up.user_id="+userid;
		 }
		 List<OdPostVo> list  = new ArrayList<OdPostVo>();;
		 OdPostVo odPostVo = null;
		 
		 try {
				conn = super.getConn();
				p = conn.prepareStatement(sql);
				res = p.executeQuery();
				while(res != null && res.next()){
					odPostVo = new OdPostVo();
					odPostVo.setPostId(res.getInt("postId"));
					odPostVo.setCode(res.getString("code"));
					odPostVo.setName(res.getString("name"));
					odPostVo.setUserid(res.getInt("userid"));
					
					list.add(odPostVo);
				}
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				super.closeAll(conn, p, res);
			}
		 
		 return list;
	 }
	 
	 
	 /**
     * 
     * 判断当前用户是中心
     *
     * @param uppperCode
     *            2代表技术系统 一类
     * @return 1待办普通 2待办技术系统 3.根节点
     */
    private Integer getCurryUserDept(String uppperCode) {
        Integer type = 1;
        if(Const.DPET_JMXT.equals(uppperCode)
                || Const.DPET_JSXT.equals(uppperCode) || Const.DPET_XTXT.equals(uppperCode) || Const.DPET_JYXT.equals(uppperCode)
                || Const.DPET_QTDW.equals(uppperCode)) {
            type = 2;
            
        } else if(Const.DEPT_ROOT.equals(uppperCode)) {
            type = 3;
            
        }
        
        return type;
    }
	 
	 
    public List<OdBgInstance> getDeptByUpserDept(String upperDeptcode){
    	String sql = "select t.dept_code, t.dept_name "
    			+ "from ODBG_INSTANCE t "
    			+ "where t.workflow_id = 5  and t.status <> 0 ";
    	if(!LangUtils.isEmpty(upperDeptcode)){
    		sql += " and t.upper_deptcode = '"+upperDeptcode+"'";
    	}
    	
    	sql += " group by t.dept_code, t.dept_name";
    	
    	List<OdBgInstance> list = new ArrayList<OdBgInstance>();
    	OdBgInstance odBgInstance = null;
    	
    	try {
			conn = super.getConn();
			p = conn.prepareStatement(sql);
			res = p.executeQuery();
			while(res != null && res.next()){
				odBgInstance = new OdBgInstance();
				odBgInstance.setDeptCode(res.getString("dept_code"));
				odBgInstance.setDeptName(res.getString("dept_name"));
				
				list.add(odBgInstance);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(conn, p, res);
		}
    	
    	return list ;
    }
    
    
	 public OdUserForm getViewInfo(Long userid){
		 OdUserForm odUserForm = new OdUserForm();
		 OdUserVo userVo = null;
		 if(LangUtils.isEmpty(userVo)) {
			 OdUser odUser = null;
			 if(!LangUtils.isEmpty(userid)){
				// 获取用户基本信息
				 odUser = this.findById(userid);
			 }
            
            String upperdepName="";
            String upperdepCode="";
            // 获取所在部门
            List<OdDeptVo> deptList = this.findDeptSqlUserId(userid);
            StringBuilder deptString = new StringBuilder();
            StringBuilder uppperDeptString = new StringBuilder();
            if(LangUtils.isNotEmpty(deptList)) {
                Set<OdDept> voSet = new HashSet<OdDept>();
                for(OdDeptVo vo : deptList) {
                    OdDept v = new OdDept();
                    v.setDeptId(vo.getDeptId());
                    v.setName(vo.getName());
                    v.setSigncode(vo.getSigncode());
                    v.setUpperdepId(vo.getUpperdepId());
                    if(LangUtils.isNotEmpty(vo.getUpperdepCode())) {
                        Integer deptType = getCurryUserDept(vo.getUpperdepCode());
                        if(deptType == 2) {
                            v.setUpperdepName(vo.getName());
                            v.setUpperdepCode(vo.getSigncode());
                            uppperDeptString.append(vo.getSigncode() + ",");
                            upperdepName=v.getUpperdepName();
                            upperdepCode=v.getUpperdepCode();
                        } else {
                            v.setUpperdepName(vo.getUpperdepName());
                            v.setUpperdepCode(vo.getUpperdepCode());
                            upperdepName=v.getUpperdepName();
                            upperdepCode=v.getUpperdepCode();
                        }
                    }
                    deptString.append(vo.getSigncode() + ",");
                    
                    voSet.add(v);
                }
                deptString.delete(deptString.length() - 1, deptString.length());
                if(LangUtils.isNotEmpty(uppperDeptString) && uppperDeptString.length() > 0) {
                    uppperDeptString.delete(uppperDeptString.length() - 1, uppperDeptString.length());
                }
                odUser.setDepts(voSet);
            }
            
            // 获取所属的角色
            List<OdRoleVo> roleList = this.findRoleSqlUserId(userid);
            if(LangUtils.isNotEmpty(roleList)) {
                Set<OdRole> voSet = new HashSet<OdRole>();
                for(OdRoleVo vo : roleList) {
                    if(LangUtils.isNotEmpty(vo.getRoleId()) && vo.getRoleId() == 1) {
                        odUser.setIsAdminRole(1);
                    }
                    OdRole v = new OdRole();
                    v.setRoleId(vo.getRoleId());
                    v.setName(vo.getName());
                    voSet.add(v);
                }
                odUser.setRoles(voSet);
            }
            // 获取用户所属岗位
            List<OdPostVo> postList = this.findPostSimpleSqlUserId2(userid);
            StringBuilder postString = new StringBuilder();
            if(LangUtils.isNotEmpty(postList)) {
                Set<OdPost> voSet = new HashSet<OdPost>();
                for(OdPostVo vo : postList) {
                    OdPost v = new OdPost();
                    v.setPostId(vo.getPostId());
                    v.setName(vo.getName());
                    v.setCode(vo.getCode());
                    if(!voSet.contains(v)) {
                        postString.append(vo.getCode() + "|");
                        voSet.add(v);
                    }
                    
                }
                postString.delete(postString.length() - 1, postString.length());
                odUser.setPosts(voSet);
            }
            
            OdUserVo odUserVo = new OdUserVo();
            Converter.copyProperties(odUserVo, odUser, OdUserVo.class);
            odUserVo.setPostStr(postString.toString());
            odUserVo.setDeptCodeStr(deptString.toString());
            odUserVo.setUpppderCodeStr(uppperDeptString.toString());
            odUserForm.setOdUser(odUserVo);
		 }
	      return odUserForm;
	 }
	
}
