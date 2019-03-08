
package com.enums;

/**
 * 
 * 工作流文号样式类型
 *
 * @author wangsl
 * @date 2017年7月31日下午3:09:29
 */
public enum WfFileStyleTypes {
    /**
     * 未知
     */
    unknowned("0", "未知"),
    /**
     * 台内行文
     */
    //TNXWSTYLE("1", "台内行文"),
    /**
     * 台收文
     */
    //ENVVAR("2", "台收文"),
    
    /**
     * 台发文
     */
    //TFWSTYLE("3", "台发文"),
    /**
     * 对外发文
     */
    //DYFWSTYLE("4", "对外发文"),
    /**
     * 合同
     */
    //DYNAMIC("5", "合同审批"),
    /**
     *因私出国
     */
    //YSCG("6", "因私出国"),
    
    /**
     *工会
     */
    GH("7", "工会"),
    
    /**
     *爱心工程
     */
    AXGC("9", "爱心工程");
    
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
    private WfFileStyleTypes(String value, String name) {
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
    public static synchronized WfFileStyleTypes getInstance(String value) {
        WfFileStyleTypes ret = WfFileStyleTypes.unknowned;
        
        for(WfFileStyleTypes status : WfFileStyleTypes.values()) {
            if(status.getValue().equals(value)) {
                ret = status;
                break;
            }
        }
        
        return ret;
    }
}
