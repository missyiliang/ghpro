package com.form;

import java.util.HashSet;
import java.util.Set;


/**
 * OdPost entity. @author MyEclipse Persistence Tools
 */

public class OdPost {
    
    // Fields
    
    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = -4751341811385410049L;

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    
    private Integer postId;
    
    private String name;
    
    private String code;
    
    private String description;
    
    private Set<OdDept> depts = new HashSet<OdDept>();
    // Constructors
    
    /** default constructor */
    public OdPost() {
    }
    
    /** full constructor */
    public OdPost(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }
    
    // Property accessors
    
    public Integer getPostId() {
        return this.postId;
    }
    
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Set<OdDept> getDepts() {
        return depts;
    }
    
    public void setDepts(Set<OdDept> depts) {
        this.depts = depts;
    }
    
}