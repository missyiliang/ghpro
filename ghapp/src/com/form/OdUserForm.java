
package com.form;

import java.util.ArrayList;
import java.util.List;

import com.enums.UserStyles;
import com.servlet.EnumsColletion;


/**
 * 
 * 用户表单信息
 *
 * @author wangsl
 * @date 2017年6月6日下午5:47:26
 */
public class OdUserForm {
    // 用户信息
    private OdUserVo odUser = new OdUserVo();
    
    // 部门信息
    private OdDeptUserVo odDeptUser = new OdDeptUserVo();
    
    // 角色用户信息
    private OdRoleUserVo odRoleUser = new OdRoleUserVo();
    
    // 部门用户信息
    private OdPostUserVo odPostUser = new OdPostUserVo();
    
    // 用户类型
    private UserStyles _userTypes = UserStyles.unknowned;
    
    // 部门ids
    private String deptids;
    
    private List<String> depids;
    
    // 部门names
    private String deptnames;
    
    // 角色ids
    private String roleids;
    
    // 角色s
    private List<String> rids;
    
    // 角色names
    private String rolenames;
    
    // 岗位s
    private List<String> psts;
    
    // 岗位ids
    private String postids;
    
    // 岗位names
    private String postnames;
    
    // 用户类型list
    private List<TreeNode> userTypeList;
    
    // 用户类型list
    private List<TreeNode> defualUserTypeList;
    
    // 部门ids结果返回信息
    private String deptIdDatas;
    
    private String deptNameDatas;
    
    // 岗位ids结果返回信息
    private String postIdDatas;
    
    private String postNameDatas;
    
    // 角色ids结果返回信息
    private String roleIdDatas;
    
    private String roleNameDatas;
    
    // 岗位编码
    private String postCode;
    
    // 名称
    private String postName;
    
    // 部门编码
    private String deptCode;
    
    // 部门名称
    private String deptName;
    
    // 上级部门
    private String upperdepName;//
    // 上级部门code
    
    private String upperdepCode;//
    
    public OdUserVo getOdUser() {
        return odUser;
    }
    
    public void setOdUser(OdUserVo odUser) {
        this.odUser = odUser;
    }
    
    public OdDeptUser getOdDeptUser() {
        return odDeptUser;
    }
    
    public void setOdDeptUser(OdDeptUserVo odDeptUser) {
        this.odDeptUser = odDeptUser;
    }
    
    public OdRoleUserVo getOdRoleUser() {
        return odRoleUser;
    }
    
    public void setOdRoleUser(OdRoleUserVo odRoleUser) {
        this.odRoleUser = odRoleUser;
    }
    
    public OdPostUserVo getOdPostUser() {
        return odPostUser;
    }
    
    public void setOdPostUser(OdPostUserVo odPostUser) {
        this.odPostUser = odPostUser;
    }
    
    public String getDeptids() {
        return deptids;
    }
    
    public void setDeptids(String deptids) {
        this.deptids = deptids;
    }
    
    public String getDeptnames() {
        return deptnames;
    }
    
    public void setDeptnames(String deptnames) {
        this.deptnames = deptnames;
    }
    
    public String getRoleids() {
        return roleids;
    }
    
    public void setRoleids(String roleids) {
        this.roleids = roleids;
    }
    
    public String getRolenames() {
        return rolenames;
    }
    
    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }
    
    public String getPostids() {
        return postids;
    }
    
    public void setPostids(String postids) {
        this.postids = postids;
    }
    
    public String getPostnames() {
        return postnames;
    }
    
    public void setPostnames(String postnames) {
        this.postnames = postnames;
    }
    
    public List<String> getDepids() {
        
        if(deptids != null) {
            depids = new ArrayList<String>();
            String ids[] = deptids.split(",");
            for(String id : ids) {
                depids.add(id);
            }
        }
        return depids;
    }
    
    public List<String> getRids() {
        if(roleids != null) {
            rids = new ArrayList<String>();
            String ids[] = roleids.split(",");
            for(String id : ids) {
                rids.add(id);
            }
        }
        return rids;
    }
    
    public List<String> getPsts() {
        if(postids != null) {
            psts = new ArrayList<String>();
            String ids[] = postids.split(",");
            for(String id : ids) {
                psts.add(id);
            }
        }
        
        return psts;
    }
    
    public String getUserTypeName() {
        String userTypeName = "";
        if(this.getOdUser().getUserType() != null) {
            _userTypes = UserStyles.getInstance(this.getOdUser().getUserType());
            userTypeName = _userTypes.getName();
        }
        
        return userTypeName;
    }
    
    public List<TreeNode> getUserTypeList() {
        if(EnumsColletion.userType()!= null) {
            userTypeList = EnumsColletion.userType();
        }
        return userTypeList;
    }
    
    public List<TreeNode> getDefualUserTypeList() {
        if(EnumsColletion.userType()!= null) {
            defualUserTypeList = EnumsColletion.userTypeDafualt();
        }
        return defualUserTypeList;
    }
    
    public String getDeptIdDatas() {
        StringBuffer sb = new StringBuffer();
        if(this.getOdUser().getDepts()!= null) {
            for(OdDept v : this.getOdUser().getDepts()) {
                sb.append(v.getDeptId() + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            deptIdDatas = sb.toString();
        }
        return deptIdDatas;
    }
    
    public String getPostIdDatas() {
        
        StringBuffer sb = new StringBuffer();
        if(this.getOdUser().getPosts()!= null) {
            for(OdPost v : this.getOdUser().getPosts()) {
                sb.append(v.getPostId() + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            postIdDatas = sb.toString();
        }
        return postIdDatas;
    }
    
    public String getRoleIdDatas() {
        StringBuffer sb = new StringBuffer();
        if(this.getOdUser().getRoles()!=null) {
            for(OdRole v : this.getOdUser().getRoles()) {
                sb.append(v.getRoleId() + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            roleIdDatas = sb.toString();
        }
        return roleIdDatas;
    }
    
    public String getDeptNameDatas() {
        StringBuffer sb = new StringBuffer();
        if(this.getOdUser().getDepts()!=null) {
            for(OdDept v : this.getOdUser().getDepts()) {
                sb.append(v.getName() + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            deptNameDatas = sb.toString();
        }
        return deptNameDatas;
    }
    
    public String getPostNameDatas() {
        StringBuffer sb = new StringBuffer();
        if(this.getOdUser().getPosts()!=null) {
            for(OdPost v : this.getOdUser().getPosts()) {
                sb.append(v.getName() + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            postNameDatas = sb.toString();
        }
        return postNameDatas;
        
    }
    
    public String getRoleNameDatas() {
        StringBuffer sb = new StringBuffer();
        if(this.getOdUser().getRoles()!=null) {
            for(OdRole v : this.getOdUser().getRoles()) {
                sb.append(v.getName() + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            roleNameDatas = sb.toString();
        }
        return roleNameDatas;
    }
    
    public String getPostCode() {
        return postCode;
    }
    
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public String getPostName() {
        return postName;
    }
    
    public void setPostName(String postName) {
        this.postName = postName;
    }
    
    public String getDeptCode() {
        List<OdDept> resulst = new ArrayList<OdDept>();
        if(odUser.getDepts()!=null) {
            resulst.addAll(odUser.getDepts());
            deptCode = resulst.get(0).getSigncode();
        }
        return deptCode;
    }
    
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    
    public String getDeptName() {
        List<OdDept> resulst = new ArrayList<OdDept>();
        if(odUser.getDepts()!=null) {
            resulst.addAll(odUser.getDepts());
            deptName = resulst.get(0).getName();
        }
        return deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    public String getUpperdepName() {
        List<OdDept> resulst = new ArrayList<OdDept>();
        if(odUser.getDepts()!=null) {
            resulst.addAll(odUser.getDepts());
            upperdepName = resulst.get(0).getUpperdepName();
        }
        return upperdepName;
    }
    
    public void setUpperdepName(String upperdepName) {
        this.upperdepName = upperdepName;
    }
    
    public String getUpperdepCode() {
        List<OdDept> resulst = new ArrayList<OdDept>();
        if(odUser.getDepts()!=null) {
            resulst.addAll(odUser.getDepts());
            upperdepCode = resulst.get(0).getUpperdepCode();
        }
        return upperdepCode;
        
    }
    
    public void setUpperdepCode(String upperdepCode) {
        this.upperdepCode = upperdepCode;
    }
    
}
