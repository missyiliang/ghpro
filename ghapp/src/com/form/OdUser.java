package com.form;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OdUser entity. @author MyEclipse Persistence Tools
 */

public class OdUser {
    
    // Fields
    
    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;
    
    private Integer userid;
    
    private String loginname;
    
    private String displayname;
    
    private String username;
    
    private String otherName;
    
    private String oldName;
    
    private String alias;
    
    private String password;
    
    private String sex;
    
    private String zodiac;
    
    private String birthDate;
    
    private String nativePlace;
    
    private String residenceType;
    
    private String birthPlace;
    
    private String birthCountry;
    
    private String birthProvince;
    
    private String maritalStatus;
    
    private String nationality;
    
    private String startDate;
    
    private String endDate;
    
    private String pinyin;
    
    private String hometel;
    
    private String mobilphone;
    
    private String croptel;
    
    private String fax;
    
    private String homeaddress;
    
    private String defaultemail;
    
    private String eamil;
    
    private Integer userType;
    
    private String clientip;
    
    private Date lockedTime;
    
    private Integer accessRights;
    
    private String userId2;
    
    private Set<OdRole> roles = new HashSet<OdRole>();
    
    private Set<OdDept> depts = new HashSet<OdDept>();
    
    private Set<OdPost> posts = new HashSet<OdPost>();
    //是否管理员
    private Integer isAdminRole;
    // Constructors
    
    /** default constructor */
    public OdUser() {
        
    }
    
    public OdUser(String loginname, String displayname, String username, String otherName, String oldName, String alias,
            String password, String sex, String zodiac, String birthDate, String nativePlace, String residenceType,
            String birthPlace, String birthCountry, String birthProvince, String maritalStatus, String nationality,
            String startDate, String endDate, String pinyin, String hometel, String mobilphone, String croptel, String fax,
            String homeaddress, String defaultemail, String eamil, Integer userType, String clientip, Date lockedTime,
            Integer accessRights,String userId2) {
        super();
        this.loginname = loginname;
        this.displayname = displayname;
        this.username = username;
        this.otherName = otherName;
        this.oldName = oldName;
        this.alias = alias;
        this.sex = sex;
        this.zodiac = zodiac;
        this.birthDate = birthDate;
        this.nativePlace = nativePlace;
        this.residenceType = residenceType;
        this.birthPlace = birthPlace;
        this.birthCountry = birthCountry;
        this.birthProvince = birthProvince;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pinyin = pinyin;
        this.password = password;
        this.hometel = hometel;
        this.mobilphone = mobilphone;
        this.croptel = croptel;
        this.fax = fax;
        this.homeaddress = homeaddress;
        this.defaultemail = defaultemail;
        this.eamil = eamil;
        this.userType = userType;
        this.clientip = clientip;
        this.lockedTime = lockedTime;
        this.accessRights = accessRights;
        this.userId2=userId2;
    }
    
    /** full constructor */
    
    // Property accessors
    public Integer getUserid() {
        return userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    public String getLoginname() {
        return loginname;
    }
    
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
    
    public String getDisplayname() {
        return displayname;
    }
    
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getOtherName() {
        return otherName;
    }
    
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
    
    public String getOldName() {
        return oldName;
    }
    
    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
    
    public String getAlias() {
        return alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getZodiac() {
        return zodiac;
    }
    
    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getNativePlace() {
        return nativePlace;
    }
    
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    
    public String getResidenceType() {
        return residenceType;
    }
    
    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }
    
    public String getBirthPlace() {
        return birthPlace;
    }
    
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    
    public String getBirthCountry() {
        return birthCountry;
    }
    
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }
    
    public String getBirthProvince() {
        return birthProvince;
    }
    
    public void setBirthProvince(String birthProvince) {
        this.birthProvince = birthProvince;
    }
    
    public String getMaritalStatus() {
        return maritalStatus;
    }
    
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    public String getPinyin() {
        return pinyin;
    }
    
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    
    public String getHometel() {
        return hometel;
    }
    
    public void setHometel(String hometel) {
        this.hometel = hometel;
    }
    
    public String getMobilphone() {
        return mobilphone;
    }
    
    public void setMobilphone(String mobilphone) {
        this.mobilphone = mobilphone;
    }
    
    public String getCroptel() {
        return croptel;
    }
    
    public void setCroptel(String croptel) {
        this.croptel = croptel;
    }
    
    public String getFax() {
        return fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public String getHomeaddress() {
        return homeaddress;
    }
    
    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }
    
    public String getDefaultemail() {
        return defaultemail;
    }
    
    public void setDefaultemail(String defaultemail) {
        this.defaultemail = defaultemail;
    }
    
    public String getEamil() {
        return eamil;
    }
    
    public void setEamil(String eamil) {
        this.eamil = eamil;
    }
    
    public Integer getUserType() {
        return userType;
    }
    
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    
    public String getClientip() {
        return clientip;
    }
    
    public void setClientip(String clientip) {
        this.clientip = clientip;
    }
    
    public Date getLockedTime() {
        return lockedTime;
    }
    
    public void setLockedTime(Date lockedTime) {
        this.lockedTime = lockedTime;
    }
    
    public Integer getAccessRights() {
        return accessRights;
    }
    
    public void setAccessRights(Integer accessRights) {
        this.accessRights = accessRights;
    }
    
    public String getUserId2() {
        return userId2;
    }

    public void setUserId2(String userId2) {
        this.userId2 = userId2;
    }

    public Set<OdRole> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<OdRole> roles) {
        this.roles = roles;
    }
    
    public Set<OdDept> getDepts() {
        return depts;
    }
    
    public void setDepts(Set<OdDept> depts) {
        this.depts = depts;
    }
    
    public Set<OdPost> getPosts() {
        return posts;
    }
    
    public void setPosts(Set<OdPost> posts) {
        this.posts = posts;
    }

    public Integer getIsAdminRole() {
        return isAdminRole;
    }

    public void setIsAdminRole(Integer isAdminRole) {
        this.isAdminRole = isAdminRole;
    }
    
}