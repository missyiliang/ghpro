package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import com.constant.SysConstant;


public class BaseUtils {
	
	/**
	 * 设置查询参数,取出页面上所有的参数,将其保存到request中,并且将有效的查询的参数重新封装到一个新的Map中去
	 * 
	 * @param request
	 * @return 有效的查询参数
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map setSearchParameter(HttpServletRequest request) {
		Map searchMap = new HashMap(); // 封装查询参数
		Map map = request.getParameterMap();
		
		//map.remove("parameterMapSize");//负责去除
		
		Set<Map.Entry> params = map.entrySet();
		for (Map.Entry entry : params) {
			String key = (String) entry.getKey();
			String[] values = (String[]) entry.getValue();
			String value = values[0].trim();
			Object valueTemp = null;
			if (value.equals("-1")) {
				value = null;
			}
			if (values.length > 1) {
				//去查询参数的空格
				valueTemp = values.toString().trim();

			} else {
				valueTemp = value;
			}
			if (StringUtil.isNotNullOrBlank(value) && key.startsWith("_")) {
				if (!key.endsWith("_TEMP")) {
					// 如果是数组，则存放数组
					request.setAttribute(key, valueTemp);
					searchMap.put(key.substring(1, key.length()), valueTemp);
				} else if (key.endsWith("_TEMP")) {
					request.setAttribute(key.substring(0, key.length() - 5),
							valueTemp);
					searchMap
							.put(key.substring(1, key.length() - 5), valueTemp);
				}
			} else {
				if(key.startsWith("_") && StringUtil.isNotNullOrBlank(valueTemp))
					searchMap.put(key, valueTemp);
			}
		}
		// 设置返回
		if (request.getParameter(SysConstant.SYSTEM_BACK_URL) != null) {
			request.setAttribute(SysConstant.SYSTEM_BACK_URL, request
					.getParameter(SysConstant.SYSTEM_BACK_URL));
		}
		return searchMap;
	}
	
}
