package com.util;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 字符串工具类
 * 
 * @author thramo
 * 
 */
public class StringUtil  {
	private static final Log log = LogFactory.getLog(StringUtil.class);

	/**
	 * 判断字符串是否不为空或者不为空字符
	 * 
	 * @param str
	 *            允许为NULL
	 * @return
	 */
	public static boolean isNotNullOrBlank(Object o) {
		if (null == o) {
			return false;
		} else {
			String str = o.toString();
			if ("".equals(str.trim())) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 判断字符串是否为空或者不为空字符
	 * 
	 * @param str
	 *            允许为NULL
	 * @return
	 */
	public static boolean isNullOrBlank(Object o) {
		return !isNotNullOrBlank(o);
	}

	/**
	 * 判断字符串是否不为空或者不为空字符及不为"-1"
	 * 
	 * @param str
	 *            允许为NULL
	 * @return
	 */
	public static boolean isValidStr(Object o) {
		if (null == o) {
			return false;
		} else {
			String str = o.toString();
			if ("".equals(str.trim())) {
				return false;
			} else if ("-1".equals(str.trim())) {
				return false;
			} else if ("null".equals(str.trim().toLowerCase())) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 将字符串的前后空格去掉
	 * 
	 * @param str
	 * @return
	 */
	public static String removeBlank(String str) {
		if (null == str) {
			return null;
		} else {
			return str.trim();
		}
	}

	/**
	 * 返回对象的字符串形式
	 * 
	 * @param object
	 * @return
	 */
	public static String objectToString(Object object) {
		return objectToString(object, "");
	}

	/**
	 * 返回对象的字符串形式,对象为空的时候,返回默认值
	 * 
	 * @param object
	 * @param defaultStr
	 * @return
	 */
	public static String objectToString(Object object, String defaultStr) {
		if (object == null) {
			return defaultStr;
		} else {
			return object.toString().trim();
		}
	}

	/**
	 * 将List转换成String
	 * 
	 * @param list
	 *            List 集合
	 * @return
	 */
	public static String convertToString(List<String> list) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			str.append(list.get(i));
			if (i < (list.size() - 1))
				str.append(".");
		}
		return str.toString();
	}

	/**
	 * 字符串数组转成带分隔符的字符串
	 * 
	 * @param String
	 *            [] array
	 * @param String
	 *            separator
	 * @return String array为空时 放回 ""
	 */
	public static String ArrayToString(String[] array, String separator) {
		String str = "";

		if (array != null && separator != null && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				if (i < array.length - 1)
					str += array[i] + separator;
				else
					str += array[i];
			}
		}

		return str;
	}

	/**
	 * 长整型ID生成器
	 * 
	 * @return 唯一的一个ID
	 */
	public static Serializable generate() {
		AtomicInteger intSequence = null;
		intSequence = new AtomicInteger(0);
		long key = System.currentTimeMillis();
		key = key * 10000;
		key = key + intSequence.getAndIncrement();
		intSequence.compareAndSet(9900, 0);
		return key;
	}

	/**
	 * 将字符串转换为Integer
	 * 
	 * @param object
	 *            待转换的字符串
	 * @return
	 */
	public static Integer getIntegerParameter(Object object) {
		return new Integer(object.toString());
	}

	/**
	 * 将字符串转换为Long
	 * 
	 * @param object
	 *            待转换的字符串
	 * @return
	 */
	public static Long getLongParameter(Object object) {
		return new Long(object.toString());
	}

	/**
	 * 将对象o转换为String类型
	 * 
	 * @param o
	 * @param defaultValue
	 *            o为空时的默认值
	 * @return
	 */
	public static String getString(Object o, String defaultValue) {
		if (null == o) {
			return defaultValue;
		} else {
			return o.toString();
		}
	}

	/**
	 * 将对象o转换为String类型
	 * 
	 * @param o
	 * @return
	 */
	public static String getString(Object o) {
		if (null == o) {
			return null;
		} else {
			return o.toString();
		}
	}

	/**
	 * 将对象o转换为Long类型
	 * 
	 * @param o
	 * @param defaultValue
	 *            为空时的默认值
	 * @return
	 */
	public static Long getLong(Object o, Long defaultValue) {
		if (null == o) {
			return defaultValue;
		} else {
			return ((java.math.BigDecimal) o).longValue();
		}
	}

	/**
	 * 将对象o转换为Integer类型
	 * 
	 * @param o
	 * @param defaultValue
	 *            为空时的默认值
	 * @return
	 */
	public static Integer getInteger(Object o, Integer defaultValue) {
		if (null == o) {
			return defaultValue;
		} else {
			return ((java.math.BigDecimal) o).intValue();
		}
	}

	/**
	 * 转换为oracle 函数
	 * 
	 * @param date
	 *            时间
	 * @return
	 */
	public static String getOracleDate(String date) {
		return "to_date('" + date + "','yyyy-MM-dd')";
	}

	/**
	 * 转换为oracle 函数
	 * 
	 * @param date
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String getOracleDate(String date, String format) {
		return "to_date('" + date + "','" + format + "')";
	}

	/**
	 * 字符串前后加逗号
	 * 
	 * @param str
	 *            如果是null,返回null,如果是"",返回""
	 * @return
	 */
	public static String getCommaString(String str) {

		if (!StringUtil.isNotNullOrBlank(str)) {
			return "";
		} else {
			if (!str.startsWith(",")) {
				str = "," + str;
			}
			if (!str.endsWith(",")) {
				str = str + ",";
			}
		}
		return str;
	}

	/**
	 * 字符串前后加逗号
	 * 
	 * @param str
	 *            如果是null或者为返回defaultStr
	 * @param defaultStr
	 * @return
	 */
	public static String getCommaString(String str, String defaultStr) {
		if (!StringUtil.isNotNullOrBlank(str)) {
			return defaultStr;
		} else {
			if (!str.startsWith(",")) {
				return "," + str;
			}
			if (!str.endsWith(",")) {
				return str + ",";
			}
		}
		return str;
	}

	/**
	 * 判断是否是正确的手机格式
	 * 
	 * @param phone
	 *            要判断的字符串
	 * @return true:是正确的手机格式;false:非正确的手机格式
	 */
	public static boolean isPhone(String phone) {
		Pattern p1 = Pattern.compile("^((\\+{0,1}86){0,1})1[0-9]{10}");
		Matcher m1 = p1.matcher(phone);
		if (m1.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 如果是-1，则返回null值
	 * 
	 * @param legTypeId
	 * @return
	 */
	public static Long setSelectNull(Long legTypeId) {
		if (null != legTypeId) {
			if ("-1".equals(legTypeId.toString())) {
				legTypeId = null;
			}
		}
		return legTypeId;
	}

	/**
	 * 根据代表的手机字段组织手机号码，代表的手机字段必须遵守一定的业务规则，多个手机以,隔开，说明在每个手机号码后面以()形式给出，
	 * 比如某某的手机号码13432432122(秘书),14332211333（家）
	 * 
	 * @param mobile
	 * @return
	 */
	public static String getdeputyMobile(String mobiles) {
		if (StringUtil.isNullOrBlank(mobiles)) {
			return "";
		}
		String mobileStr = "";
		mobiles = mobiles.replaceAll("，", ",");
		String[] mobileArray = mobiles.split(",");
		for (int i = 0; i < mobileArray.length; i++) {
			if (mobileArray[i].length() > 13) {
				mobileArray[i] = mobileArray[i].substring(0,
						mobileArray[i].length() - 1);
			}
			if (isPhone(mobileArray[i])) {
				mobileStr = mobileStr + mobileArray[i];
				if (i < mobileArray.length - 1) {
					mobileStr = mobileStr + ",";
				}
			} else {
				log.equals(mobileStr + "手机格式错误");
			}
		}
		return mobileStr;
	}
}
