
package com.enums;

/**
 * 
 * 发布类型
 *
 * @author wangsl
 * @date 2017年7月24日上午11:13:26
 */
public enum PublishTypes {
    /**
     * 未知
     */
    unknowned(0, "未知"),
    
    /**
     * 待发布
     */
    WAITPUBLISH(1, "待发布"),
    
    /**
     * 待审核
     */
    AUDIT(75, "待审核"),
    /**
     * 已发布
     */
    PUBLICFINSH(100, "已发布"),
    /**
     * 撤销
     */
    DELETED(-1, "已撤销");
    
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
    private PublishTypes(int value, String name) {
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
    public static synchronized PublishTypes getInstance(int value) {
        PublishTypes ret = PublishTypes.unknowned;
        
        for(PublishTypes status : PublishTypes.values()) {
            if(status.getValue() == value) {
                ret = status;
                break;
            }
        }
        
        return ret;
    }
}
