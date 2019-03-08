
package com.constant;

/**
 * 
 * 系统全局变量
 *
 * @author wangsl
 * @date 2017年8月17日上午10:46:18
 */
public class Const {
    /** 工作流 流程状态 未完成- **/
    public static final Integer WORKFLOW_INATCE_STATUS_WAIT = 40;
    
    /** 工作流 流程状态 已完成- **/
    public static final Integer WORKFLOW_INATCE_STATUS_FINSH = 100;
    /** 工作流 流程状态 已完成1- **/
    public static final Integer WORKFLOW_INATCE_STATUS_FINSH1 = 110;
    
    /** 工作流 流程任务状态 未完成- **/
    public static final Integer WORKFLOW_TASK_STATUS_WAIT = 40;
    
    /** 工作流 流程任务状态 已完成- **/
    public static final Integer WORKFLOW_TASK_STATUS_FINSH = 100;
    
    /** 工作流 流程任务状态 已完成1- **/
    public static final Integer WORKFLOW_TASK_STATUS_FINSH1 = 100;
    
    /** 工作流 按钮 提交- **/
    public static String SUBMIT_SUBMIT = "提交";
    
    /** 工作流 按钮 转发- **/
    public static String SUBMIT_ZF = "转发";
    
    /** 工作流 按钮 办结- **/
    public static String SUBMIT_BJ = "办结";
    /** 部门code 节目系统- **/
    public static String DPET_JMXT = "jmxt";
    /** 部门code 技术系统- **/
    public static String DPET_JSXT = "jsxt";
    /** 部门code 行政系统- **/
    public static String DPET_XTXT = "xzxt";
    /** 部门code 经营系统- **/
    public static String DPET_JYXT = "jyxt";
    /** 部门code 其他单位- **/
    public static String DPET_QTDW = "qtdw";
    /** 部门code 根节点部门- **/
    public static String DEPT_ROOT="-1";
    
    
    /**岗位配置  台秘书- **/
    public static String POST_TAIMISHU="tailingdaomishu";
    /** 岗位编码 台领导 - **/
    public static String POST_TAILINGDAO="tailingdao";
    /**岗位配置  中心秘书- **/
    public static String POST_ZHONGXINMISHU="zhongxinmishu";
    /**岗位配置  中心领导- **/
    public static String POST_ZHONGXINLINGDAO="zhongxinlingdao";
    /**岗位配置  综合部主任- **/
    public static String POST_ZHBZR="zonghebuzhuren";
    /**岗位配置 部处秘书- **/
    public static String POST_CHULINGDAOMISHU="chulingdaomishu";
    /**岗位配置 部处领导- **/
    public static String POST_CHULINGDAO="chulingdao";
    
    /**岗位配置  职能部门除秘书**/
    public static String POST_ZHINENGBUMENCHUMISHU ="zhinengbumenchumishu";
    
    /** 节点任务类型类型  代表普通共享任务- **/
    public static Integer NODE_TYPE_PTGX=0;
    /** 节点任务类型类型  代表启动任务- **/
    public static Integer NODE_TYPE_QD=1;
    /** 节点任务类型类型  代表独立任务- **/
    public static Integer NODE_TYPE_DL=2;
    /** 节点任务类型类型  代表自动任务- **/
    public static Integer NODE_TYPE_ZD=3;
    /** 节点任务类型类型  代表顺序任务- **/
    public static Integer NODE_TYPE_SX=4;
    /** 节点任务类型类型  代表重启任务- **/
    public static Integer NODE_TYPE_CQ=6;
    /**数字常量  固定1- **/
    public static Integer CONST_ONE=1;
    /**数字常量  固定2- **/
    public static Integer CONST_TWO=2;
    /**数字常量  固定3- **/
    public static Integer CONST_THREE=3;
    /**数字常量  固定4- **/
    public static Integer CONST_FOUR=4;
    
    /**工作流提交动作  1代表提交提交中心领导/总监ID- **/
    public static Integer ACTION_ONE=1;
    
    /**工作流提交动作  2提交法务联络员ID- **/
    public static Integer ACTION_TWO=2;
    
    /**工作流提交动作  21中心领导- **/
    public static Integer ACTION_WENTYONE=21;
    /**工作流提交动作  21职能部处领导- **/
    public static Integer ACTION_WENTYTWO=22;
    
    /**工作流提交动作  21中心领导- **/
    public static Integer DL_ACTION_WENONE=35603;
    /**工作流提交动作  提交事务室专员- **/
    public static Integer DL_ACTION_WENTYTWO=35604;
    /**工作流提交动作  提交职能领导办理- **/
    public static Integer DL_ACTION_WENTYTHREE=41019;
    /**工作流提交动作 会签同意 **/
    public static Integer ACTION_HQBTX=35605;
    /**工作流提交动作  退办- **/
    public static String ACTION_BTN_TB="退办";
    /**工作流提交动作  会签- **/
    public static String ACTION_BTN_HQ="会签";
    /**工作流提交动作  退办拟稿人- **/
    public static String ACTION_BTN_TBNGR="退办拟稿人";
    
    /**部门  版权法律事务室- **/
    public static String DEPT_CODE_BQFLSWS="bqhflsws";
    
    /**工作流提交动作  提交台领导- **/
    public static String ACTION_BTN_TJTLD="提交台领导";
    /**工作流提交动作  提交中心领导/总监"- **/
    public static String ACTION_BTN_TJZXLD="提交中心领导/总监";
    /**工作流提交动作  提交部处副主任"- **/
    public static String ACTION_BTN_TJBCFZR="提交部处副主任";
    /**工作流提交动作  提交部处主任"- **/
    public static String ACTION_BTN_TJBCLD="提交部处主任";
    /**工作流提交动作  提交中心秘书"- **/
    public static String ACTION_BTN_TJZXMS="提交中心秘书";
    /**工作流提交动作  提交职能部门领导"- **/
    public static String ACTION_BTN_TJZNBMLD="提交职能部处领导";
    /**工作流提交动作  提交职能部门领导"- **/
    public static String ACTION_BTN_TJZNBMLD2="提交职能部门领导";
    /**工作流提交动作  提交报总局"- **/
    public static String ACTION_BTN_TJBZJ="提交报总局";
    /**工作流提交动作  提交台办室复核"- **/
    public static String ACTION_BTN_TJTBSFSZJ="提交台办室复核";
    /**工作流提交动作  返回中心校对"- **/
    public static String ACTION_BTN_FHZXXD="返回中心校对";
    /**工作流提交动作 提交台办室初核"- **/
    public static String ACTION_BTN_TJTBSCH="提交秘书处初核";
    /**工作流提交动作 提交台办室初核"- **/
    public static String ACTION_BTN_TJTBSFH="提交台办室复核";
    /**工作流提交动作 提转发频道/转发频道/中心"- **/
    public static String ACTION_BTN_ZFPDZX="转发频道/中心";
    /**工作流提交动作 转发本中心部处"- **/
    public static String ACTION_BTN_ZFBZBC="转发本中心部处";
    /**工作流提交动作 办结"- **/
    public static String ACTION_BTN_BJ="办结";
    /**工作流提交动作 转发返回来文中心"- **/
    public static String ACTION_BTN_ZFLDWZX="转发返回来文中心";    
    /**工作流提交动作 退办中心- **/
    public static String ACTION_BTN_TBZX="退办中心";    
    /**工作流提交动作 提交台领导秘书处- **/
    public static String ACTION_BTN_TBSMSC="提交台领导秘书处";
    /**工作流提交动作 提交台领导秘书处- **/
    public static String ACTION_BTN_TJJSGLZX="提交技管中心";    
    /**工作流提交动作 提交法务中心- **/
    public static String ACTION_BTN_TJFWMS="提交法务秘书";  
    /**工作流提交动作 返回技管中心- **/
    public static String ACTION_BTN_FHZXMS="返回技管中心";   
    /**工作流提交动作 返回法规处- **/
    public static String ACTION_BTN_FHFGC="返回法规处"; 
    /**工作流提交动作 会签中心- **/
    public static String ACTION_BTN_HQZX="会签中心"; 
    /**工作流提交动作 返回经办人- **/
    public static String ACTION_BTN_FHJBR="返回经办人"; 
    /**工作流提交动作 转发财务- **/
    public static String ACTION_BTN_ZFCW="转发财务"; 
    
    
    /** 类型：0 **/
    public static final Integer TYPE_ZERO = 0;
    
    /** 类型：1 **/
    public static final Integer TYPE_ONE = 1;
    
    /** 类型：2 **/
    public static final Integer TYPE_TWO = 2;
    
    /** 类型：3 **/
    public static final Integer TYPE_THREE = 3;
    
    /** 类型：4 **/
    public static final Integer TYPE_FORE = 4;
    /** 类型：5 **/
    public static final Integer TYPE_FIVE = 5;
    /** 类型：6 **/
    public static final Integer TYPE_SIX = 6;
    /** 类型：7 **/
    public static final Integer TYPE_SEVEN = 7;
    /** 类型：8 **/
    public static final Integer TYPE_EIGHT = 8;
    /** 类型：9 **/
    public static final Integer TYPE_NINE = 9;
    /** 类型：10 **/
    public static final Integer TYPE_TEN = 10;
    /** 类型：11 **/
    public static final Integer TYPE_ELEVEN = 11;
    /** 类型：12 **/
    public static final Integer TYPE_TWELVE = 12;
    /** 类型：13**/
    public static final Integer TYPE_THIRTEEN = 13;
    /** 类型：14**/
    public static final Integer TYPE_FOURTEEN = 14;
    /** 类型：15**/
    public static final Integer TYPE_FIFTEEN = 15;

    
 
}
