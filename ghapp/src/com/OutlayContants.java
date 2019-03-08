package com;

/**
 * 经费申请-常量
 */
public class OutlayContants {
	
	public static final String BLTZ_TB_BJ = "被退办，请重新填写活动申请";
	public static final String BLTZ_BJ = "已完成报销,流程结束";
	public static final String BLTZ_TLDSPTG = "请示已审批通过";
	public static final String BLTZ_QX = "活动已取消";
	public static final String BLTZ_TB_XGCL = "被退办，请修改材料内容";
	public static final String BLTZ_HK = "已汇款，请携带资料进行报销";
	
	/**
	 * 项目地址
	 */
	public static final String GH_PROJECT_URL = "/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/installedApps/OA-TESTWAS-04Node01Cell/gh_war.ear/gh.war";
	
	/**
	 * 附件地址
	 */
	public static final String GH_ATTACH_FILE_PATH = "/OAShare/ghxt/attach";
	
//	/**
//	 * 项目地址
//	 */
//	public static final String GH_PROJECT_URL = "D://workspace5//gh//WebRoot";
//	
//	/**
//	 * 附件地址
//	 */
//	public static final String GH_ATTACH_FILE_PATH = "d://OAShare//ghxt//attach";
	

	/**
	 * xx
	 */
	public static final String a = "";

	/**
	 * 经费申请状态：草稿箱 0
	 */
	public static final int APPLY_STATUS_CGX = 0;

	/**
	 * 经费申请状态：中心工会主席 1
	 */
	public static final int APPLY_STATUS_1_ZXGHZX = 1;

	/**
	 * 经费申请状态：台工会财务 2
	 */
	public static final int APPLY_STATUS_1_TGHCW = 2;

	/**
	 * 经费申请状态：台工会主席 3
	 */
	public static final int APPLY_STATUS_1_TGHZX = 3;

	/**
	 * 经费申请状态：组织员填写汇款 4
	 */
	public static final int APPLY_STATUS_1_ZZY = 4;

	/**
	 * 经费申请状态：中心工会主席 5
	 */
	public static final int APPLY_STATUS_2_ZXGHZX = 5;

	/**
	 * 经费申请状态：台工会财务 6
	 */
	public static final int APPLY_STATUS_2_TGHCW = 6;

	/**
	 * 经费申请状态：台工会主席 7
	 */
	public static final int APPLY_STATUS_2_TGHZX = 7;

	/**
	 * 经费申请状态：台工会财务签字 8
	 */
	public static final int APPLY_STATUS_2_TGHCWPJQZ = 8;

	/**
	 * 经费申请状态：台工会出纳签字 9
	 */
	public static final int APPLY_STATUS_2_TGHCNPJQZ = 9;
	
//	/**
//	 * 经费申请状态：台工会财务签字 10
//	 */
//	public static final int APPLY_STATUS_2_JBRBX = 10;
	
	/**
	 * 经费申请状态：台工会财务签字 10
	 */
	public static final int APPLY_STATUS_2_TGHCWBJ = 10;
	
	/**
	 * 经费申请状态：结束
	 */
	public static final int APPLY_STATUS_2_END = 33;


	/**
	 * 经费申请状态：退办
	 */
	public static final int APPLY_STATUS_2_REBACK = -1;

}
