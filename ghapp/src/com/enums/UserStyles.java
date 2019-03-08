
package com.enums;
/**
 * 
 * 用户类型枚举
 *
 * @author wangsl
 * @date 2017年6月9日下午7:18:14
 */
public enum UserStyles {
    /**
     * 未知
     */
    unknowned(0, "未知"),
    
    /**
     *  普通用户
     */
    ptUser(1, "普通用户"),
    
    /**
     * 运维人员
     */
    ywUser(2, "运维人员"),
    
    /**
     * 后台管理人员
     */
    htglUser(3, "后台管理人员"),
    /**
     * 审计人员
     */
    sjUser(4, "审计人员"),
    /**
     * 审计人员
     */
    glUser(5, "管理员");
    
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
     * @param value 枚举值
     * @param name 状态名称
     */
    private UserStyles(int value, String name) {  
        this._value = value;  
        this._Name = name;  
    }  
    
    /**
     * 取得枚举对象值
     * @return 枚举对象值
     */
    public int getValue() {
        return this._value;
    }
    
    /**
     * 取得名称
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
    public static synchronized UserStyles getInstance(int value) {
        UserStyles ret = UserStyles.unknowned;
        
        for(UserStyles status : UserStyles.values()) {
            if(status.getValue() == value) {
                ret = status;
                break;
            }
        }
        
        return ret;
    }
}

