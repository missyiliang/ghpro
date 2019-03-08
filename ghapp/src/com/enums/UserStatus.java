
package com.enums;

/**
 * 
 * 用户类型枚举
 *
 * @author wangsl
 * @date 2017年6月9日下午7:18:14
 */
public enum UserStatus {
    /**
     * 未知
     */
    unknowned("", "未知"),
    
    /**
     * 后台管理站点用户
     */
    userYx("0", "有效"),
    
    /**
     * 无效
     */
    userWx("1", "无效");
    
    /**
     * 枚举对象值
     */
    String _value;
    
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
    private UserStatus(String value, String name) {
        this._value = value;
        this._Name = name;
    }
    
    /**
     * 取得枚举对象值
     * 
     * @return 枚举对象值
     */
    public String getValue() {
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
    public static synchronized UserStatus getInstance(int value) {
        UserStatus ret = UserStatus.unknowned;
        
        for(UserStatus status : UserStatus.values()) {
            if(status.getValue().equals(value)) {
                ret = status;
                break;
            }
        }
        
        return ret;
    }
}
