package com.form;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * OdPstemInfo entity. @author MyEclipse Persistence Tools
 */

public class OdPstemInfo {
    
    // Fields
    
    private Integer systemId;
    
    private String systemName;
    
    private String url;
    
    private Integer parentId;
    
    private String signCode;
    
    private String desr;
    
    private String username;
    
    private Set<OdResource> resoureces = new HashSet<OdResource>();
    // Constructors
    
    /** default constructor */
    public OdPstemInfo() {
    }
    
    /** full constructor */
    public OdPstemInfo(String systemName, String url, Integer parentId, String signCode, String desr) {
        this.systemName = systemName;
        this.url = url;
        this.parentId = parentId;
        this.signCode = signCode;
        this.desr = desr;
        
    }
    
    // Property accessors
    
    public Integer getSystemId() {
        return this.systemId;
    }
    
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
    
    public String getSystemName() {
        return systemName;
    }
    
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Integer getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public String getSignCode() {
        return this.signCode;
    }
    
    public void setSignCode(String signCode) {
        this.signCode = signCode;
    }
    
    public String getDesr() {
        return desr;
    }
    
    public void setDesr(String desr) {
        this.desr = desr;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Set<OdResource> getResoureces() {
        return resoureces;
    }
    
    public void setResoureces(Set<OdResource> resoureces) {
        this.resoureces = resoureces;
    }

    @Override
    public String toString() {
        return "OdPstemInfo [systemId="
                + systemId + ", systemName=" + systemName + ", url=" + url + ", parentId=" + parentId + ", signCode=" + signCode
                + ", desr=" + desr + ", username=" + username + ", resoureces=" + resoureces + "]";
    }
    
}