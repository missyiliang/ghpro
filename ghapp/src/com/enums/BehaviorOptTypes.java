
package com.enums;

/**
 * 
 * 用配置操作类型枚举
 *
 * @author wangsl
 * @date 2017年6月9日下午7:18:14
 */
public enum BehaviorOptTypes {
    /**
     * 未知
     */
    unknowned(0, "未知"),
    
    /**
     * 新增
     */
    ADD(1, "新增"),
    
    /**
     * 修改
     */
    MODIFTY(2, "修改"),
    
    /**
     * 删除
     */
    DELETE(3, "删除"),
    /**
     * 其他
     */
    OTHER(4, "其他");
    
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
    private BehaviorOptTypes(int value, String name) {
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
    public static synchronized BehaviorOptTypes getInstance(int value) {
        BehaviorOptTypes ret = BehaviorOptTypes.unknowned;
        
        for(BehaviorOptTypes status : BehaviorOptTypes.values()) {
            if(status.getValue() == value) {
                ret = status;
                break;
            }
        }
        
        return ret;
    }
}
