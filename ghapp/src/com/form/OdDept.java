package com.form;

import java.util.Date;

/**
 * OdDept entity. @author MyEclipse Persistence Tools
 */

public class OdDept  {
    
    // Fields
    
    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;
    
    private Integer deptId;
    
    private Integer orgtypeId;
    
    private Integer upperdepId;
    
    private Integer level;
    
    private String treepath;
    
    private String upperdepName;
    
    private String upperdepCode;
    
    private String name;
    
    private String shortName;
    
    private Integer sortNum;
    
    private Integer deptType;
    
    private String signcode;
    
    private String deptLimitsCode;
    
    // Constructors
    
    /** default constructor */
    public OdDept() {
    }
    
    /** full constructor */
   
    
    // Property accessors
    
    public Integer getOrgtypeId() {
        return this.orgtypeId;
    }
    
    public OdDept(Integer deptId, Integer orgtypeId, Integer upperdepId, Integer level, String treepath, String upperdepName,
            String upperdepCode, String name, String shortName, Integer sortNum, Integer deptType, String signcode,
            String deptLimitsCode) {
        super();
        this.deptId = deptId;
        this.orgtypeId = orgtypeId;
        this.upperdepId = upperdepId;
        this.level = level;
        this.treepath = treepath;
        this.upperdepName = upperdepName;
        this.upperdepCode = upperdepCode;
        this.name = name;
        this.shortName = shortName;
        this.sortNum = sortNum;
        this.deptType = deptType;
        this.signcode = signcode;
        this.deptLimitsCode = deptLimitsCode;
    }

    public Integer getDeptId() {
        return deptId;
    }
    
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    
    public void setOrgtypeId(Integer orgtypeId) {
        this.orgtypeId = orgtypeId;
    }
    
    public Integer getUpperdepId() {
        return this.upperdepId;
    }
    
    public void setUpperdepId(Integer upperdepId) {
        this.upperdepId = upperdepId;
    }
    
    public String getUpperdepName() {
        // if(LangUtils.isNotEmpty(upperdepCode)) {
        // if(upperdepCode.equals(Const.DPET_JMXT)
        // || upperdepCode.equals(Const.DPET_JSXT) || upperdepCode.equals(Const.DPET_XTXT)
        // || upperdepCode.equals(Const.DPET_JYXT) || upperdepCode.equals(Const.DPET_QTDW)) {
        //
        // }
        // upperdepName = this.name;
        // }
        return this.upperdepName;
    }
    
    public void setUpperdepName(String upperdepName) {
        this.upperdepName = upperdepName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getShortName() {
        return this.shortName;
    }
    
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    
    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public String getSigncode() {
        return this.signcode;
    }
    
    public void setSigncode(String signcode) {
        this.signcode = signcode;
    }
    
    public String getTreepath() {
        return this.treepath;
    }
    
    public void setTreepath(String treepath) {
        this.treepath = treepath;
    }
    
    public Integer getSortNum() {
        return this.sortNum;
    }
    
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
    
    public String getUpperdepCode() {
        return upperdepCode;
    }
    
    public void setUpperdepCode(String upperdepCode) {
        this.upperdepCode = upperdepCode;
    }
    
    public String getDeptLimitsCode() {
        return deptLimitsCode;
    }
    
    public void setDeptLimitsCode(String deptLimitsCode) {
        this.deptLimitsCode = deptLimitsCode;
    }
    
    public Integer getDeptType() {
        return deptType;
    }
    
    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }
    
}