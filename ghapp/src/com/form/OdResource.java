package com.form;

import java.sql.Timestamp;


/**
 * OdResource entity. @author MyEclipse Persistence Tools
 */

public class OdResource  {
    
    // Fields
    
    private Integer resourceId;
    
    private Integer systemId;
    
    private String resourceName;
    
    private String urlPath;
    
    private Integer parentId;
    
    private String actionInfo;
    
    private Integer level;
    
    private Integer sortNum;
    
    private String imageIcon;
    
    private String description;
    
    private String systemName;
    
    // Constructors
    
    /** default constructor */
    public OdResource() {
    }
    
    /** full constructor */
    public OdResource(String resourceName, Integer systemId, String urlPath, Integer parentId, String actionInfo, Integer level,
            Integer sortNum, String imageIcon, String description) {
        this.resourceName = resourceName;
        this.systemId = systemId;
        this.urlPath = urlPath;
        this.parentId = parentId;
        this.actionInfo = actionInfo;
        this.level = level;
        this.sortNum = sortNum;
        this.imageIcon = imageIcon;
        this.description = description;
    }
    
    // Property accessors
    
    public Integer getResourceId() {
        return this.resourceId;
    }
    
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
    
    
    
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getSystemId() {
        return systemId;
    }
    
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
    
    public String getUrlPath() {
        return this.urlPath;
    }
    
    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
    
    public Integer getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public String getActionInfo() {
        return this.actionInfo;
    }
    
    public void setActionInfo(String actionInfo) {
        this.actionInfo = actionInfo;
    }
    
    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Integer getSortNum() {
        return this.sortNum;
    }
    
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
    
    public String getImageIcon() {
        return this.imageIcon;
    }
    
    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystemName() {
        return systemName;
    }
    
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
    
}