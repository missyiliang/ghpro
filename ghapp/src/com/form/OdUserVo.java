
package com.form;



/**
 * 
 * 用户vo
 *
 * @author wangsl
 * @date 2017年6月6日下午6:07:08
 */
public class OdUserVo extends OdUser {
    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;
    
    private String user_typev;
    
    private Integer sort_num;// 人员排序
    
    private String name;// 部门岗位
    
    private Integer dptUserId;
    
    // 岗位id
    private Integer postId;
    
    // 岗位编码
    private String postCode;
    
    // 名称
    private String postName;
    // 部门id
    
    private Integer deptId;
    
    // 部门编码
    private String deptCode;
    
    // 部门名称
    private String deptName;
    
    // 上级部门ID
    private Integer upperdepId;
    // 上级部门code
    
    private String upperdepCode;
    
    // 上级部门
    private String upperdepName;
    
    // 岗位str
    private String postStr;
    
    // 部门Str
    private String deptCodeStr;
    
    // 中心codeStr
    private String upppderCodeStr;
    
    public String getUser_typev() {
        return user_typev;
    }
    
    public void setUser_typev(String user_typev) {
        this.user_typev = user_typev;
    }
    
    public Integer getSort_num() {
        return sort_num;
    }
    
    public void setSort_num(Integer sort_num) {
        this.sort_num = sort_num;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getDptUserId() {
        return dptUserId;
    }
    
    public void setDptUserId(Integer dptUserId) {
        this.dptUserId = dptUserId;
    }
    
    public Integer getPostId() {
        return postId;
    }
    
    public void setPostId(Integer postId) {
        this.postId = postId;
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
    
    public Integer getDeptId() {
        return deptId;
    }
    
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    
    public String getDeptCode() {
        return deptCode;
    }
    
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    
    public String getDeptName() {
        return deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    public Integer getUpperdepId() {
        return upperdepId;
    }
    
    public void setUpperdepId(Integer upperdepId) {
        this.upperdepId = upperdepId;
    }
    
    public String getUpperdepCode() {
        return upperdepCode;
    }
    
    public void setUpperdepCode(String upperdepCode) {
        this.upperdepCode = upperdepCode;
    }
    
    public String getUpperdepName() {
        return upperdepName;
    }
    
    public void setUpperdepName(String upperdepName) {
        this.upperdepName = upperdepName;
    }
    
    public String getPostStr() {
        return postStr;
    }
    
    public void setPostStr(String postStr) {
        this.postStr = postStr;
    }
    
    public String getDeptCodeStr() {
        return deptCodeStr;
    }
    
    public void setDeptCodeStr(String deptCodeStr) {
        this.deptCodeStr = deptCodeStr;
    }

    public String getUpppderCodeStr() {
        return upppderCodeStr;
    }

    public void setUpppderCodeStr(String upppderCodeStr) {
        this.upppderCodeStr = upppderCodeStr;
    }
    
}
