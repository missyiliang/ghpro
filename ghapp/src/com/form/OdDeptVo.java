
package com.form;



/**
 * 
 * 部门vo
 *
 * @author wangsl
 * @date 2017年6月16日下午4:20:53
 */
public class OdDeptVo extends OdDept {
    private Integer userid;
    
    private Integer postId;
    private Boolean ischeck;
    public Integer getUserid() {
        return userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    public Integer getPostId() {
        return postId;
    }
    
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Boolean getIscheck() {
        return ischeck;
    }

    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }
    
}
