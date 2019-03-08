
package com.enums;

/**
 * 
 * 处理方式枚举下拉
 *
 * @author wangsl
 * @date 2018年4月9日下午1:52:31
 */
public enum ReceiveTypes {
    /**
     * 未知
     */
    unknowned(-1, "未知"),
    
    /**
     * 我的拟稿
     */
    WDNG(1, "我的拟稿"),
    /**
     * 我的关注
     */
    WDGZ(2, "我的关注");
    
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
    private ReceiveTypes(int value, String name) {
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
    public static synchronized ReceiveTypes getInstance(int value) {
        ReceiveTypes ret = ReceiveTypes.unknowned;
        
        for(ReceiveTypes status : ReceiveTypes.values()) {
            if(status.getValue() == value) {
                ret = status;
                break;
            }
        }
        
        return ret;
    }
}
