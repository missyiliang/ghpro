package com.form;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * OdRole entity. @author MyEclipse Persistence Tools
 */

public class OdRole {
    
    // Fields
    
    private Integer roleId;
    
    private String name;
    
    private Integer roleType;
    
    private String description;
    
    private Integer deleteFlag;
    
    private Set<OdUser> users = new HashSet<OdUser>();
    
    private Set<OdPstemInfo> odPstemInfos = new HashSet<OdPstemInfo>();
    
    private Set<OdResource> resoureces = new HashSet<OdResource>();
    // Constructors
    
    /** default constructor */
    public OdRole() {
    }
    
    /** full constructor */
    public OdRole(String name, Integer roleType, String description, Integer deleteFlag, Set<OdUser> users,
            Set<OdPstemInfo> odPstemInfos) {
        this.name = name;
        this.roleType = roleType;
        this.description = description;
        this.users = users;
        this.odPstemInfos = odPstemInfos;
    }
    
    // Property accessors
    
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getRoleType() {
        return this.roleType;
    }
    
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    public Set<OdUser> getUsers() {
        return users;
    }
    
    public void setUsers(Set<OdUser> users) {
        this.users = users;
    }
    
    public Set<OdPstemInfo> getOdPstemInfos() {
        return odPstemInfos;
    }
    
    public Set<OdResource> getResoureces() {
        return resoureces;
    }
    
    public void setResoureces(Set<OdResource> resoureces) {
        this.resoureces = resoureces;
    }
    
    public void setOdPstemInfos(Set<OdPstemInfo> odPstemInfos) {
        this.odPstemInfos = odPstemInfos;
    }
    
}