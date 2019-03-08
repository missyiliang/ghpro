package com;

/**
 * 爱心工程-常量
 */
public class LoveProjectContants {
	
	public static final String BLTZ_TG = "已审批通过，请携带材料进行申领";//台工会总字+已审批通过，请携带材料进行申领
	
	public static final String BLTZ_BJ = "已办结";//台工会总字+已办结

	/**
	 * 爱心工程申请状态：草稿箱 0
	 */
	public static final int APPLY_STATUS_CGX = 0;

	/**
	 * 爱心工程申请状态：中心工会主席审批 1
	 */
	public static final int APPLY_STATUS_ZXGHZX = 1;

	/**
	 * 爱心工程申请状态：台工会财务 2
	 */
	public static final int APPLY_STATUS_TGHCW = 2;

	/**
	 * 爱心工程申请状态：台工会主席 3
	 */
	public static final int APPLY_STATUS_TGHZX = 3;
	
	/**
	 * 取消申请状态：财务办结 4
	 */
	public static final int APPLY_STATUS_TGHCWBJ = 4;

	/**
	 * 爱心工程申请状态：结束 4
	 */
	public static final int APPLY_STATUS_END = 33;

	/**
	 * 爱心工程申请状态：退办 4
	 */
	public static final int APPLY_STATUS_REBACK = -1;

}
