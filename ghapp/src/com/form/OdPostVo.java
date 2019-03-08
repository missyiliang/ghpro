
package com.form;



/**
 * 
 * 岗位vo
 *
 * @author wangsl
 * @date 2017年6月16日上午10:24:17
 */
public class OdPostVo extends OdPost {
    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;
    
    private Integer userid;
    
    private Integer deptId;
    
    private String postName;
    
    private String postCode;
    
    public Integer getUserid() {
        return userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    public Integer getDeptId() {
        return deptId;
    }
    
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    
    public String getPostName() {
        return postName;
    }
    
    public void setPostName(String postName) {
        this.postName = postName;
    }
    
    public String getPostCode() {
        return postCode;
    }
    
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
}
