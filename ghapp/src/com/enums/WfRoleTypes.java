
package com.enums;

/**
 * 
 * 工作流角色分类角色
 *
 * @author wangsl
 * @date 2017年7月24日上午11:13:26
 */
public enum WfRoleTypes {
    /**
     * 未知
     */
    unknowned(0, "未知"),
    
    /**
     * 普通用户角色
     */
    GENARAL(1, "普通用户角色"),
    /**
     * 部门岗位信息
     */
    DEPPOSTVAR(2, "部门岗位角色"),
    /**
     * 相关部门岗位信息
     */
    XGDEPPOSTVAR(3, "相关部门岗位角色"),
    
    /**
     * 环境变量角色
     */
    ENVVAR(4, "环境变量角色"),
    
    /**
     * 动态用户角色
     */
    DYNAMIC(5, "动态用户角色");
    
    /**
     * 枚举对象值
     */
    int _value;
    
    /**
     * 状态名称
     */
    String _Name;
    
    /**
     * 私有构造函数
     * 
     * @param value
     *            枚举值
     * @param name
     *            状态名称
     */
    private WfRoleTypes(int value, String name) {
        this._value = value;
        this._Name = name;
    }
    
    /**
     * 取得枚举对象值
     * 
     * @return 枚举对象值
     */
    public int getValue() {
        return this._value;
    }
    
    /**
     * 取得名称
     * 
     * @return 名称
     */
    public String getName() {
        return this._Name;
    }
    
    /**
     * 通过value值取得状态对象实例
     * 
     * @param value
     * @return
     */
    public static synchronized WfRoleTypes getInstance(int value) {
        WfRoleTypes ret = WfRoleTypes.unknowned;
        
        for(WfRoleTypes status : WfRoleTypes.values()) {
            if(status.getValue() == value) {
                ret = status;
                break;
            }
        }
        
        return ret;
    }
}
