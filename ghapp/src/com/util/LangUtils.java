package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


/**
 * 数据类型操作工具类
 * 
 *
 * @author wangsl
 * @date 2017年5月19日上午10:47:55
 */
public class LangUtils {
    /**
     * 判断对象是否为空，对象可为字符串、对象数组、Collection。对于字符串会先去除前后的空字符。
     * 
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if(obj == null) {
            return true;
        }
        if(obj instanceof String) {
            return ((String) obj).trim().equals("");
        }
        if(obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        if(obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        return false;
    }
    
    /**
     * 判断对象是否为非空，对象可为字符串、对象数组、Collection。对于字符串会先去除前后的空字符。
     * 
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !LangUtils.isEmpty(obj);
    }
    
    /**
     * md5加密
     */
    public static String md5(String src) {
        if(src == null) return null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            StringBuilder dist = new StringBuilder();
            for(byte b : md.digest()) {
                String s = Integer.toHexString(0xFF & b);
                if(s.length() == 1) dist.append("0");
                dist.append(s);
            }
            return dist.toString().toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 去掉前后空白字符，包括中文空格
     */
    public static String trimCn(String str) {
        if(str == null) return null;
        str = str.trim();
        if(str.length() == 0) return str;
        int st = 0;
        int len = str.length();
        while ((st < len) && str.charAt(st) == '　')
            st++;
        while ((st < len) && str.charAt(len - 1) == '　')
            len--;
        if(st > 0 || len < str.length()) str = str.substring(st, len);
        return str.trim();
    }
    
    public static boolean contains(Object[] array, Object item) {
        for(Object obj : array) {
            if(obj.equals(item)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * 将字符串格式成sql查询的like形式，即在前后分别加上%，空格也替换成%。
     * 
     * @return 返回sql模糊查询的字符串，如果字符串为空则返回null
     */
    public static String makeSqlLike(String key) {
        return LangUtils.isNotEmpty(key) ? "%" + key.trim().replaceAll("\\s", "%") + "%" : null;
    }
    
    public static String isoToUtf8(String str) {
        if(str == null) return null;
        try {
            return new String(str.getBytes("iso-8859-1"), "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 将日期转换成字符串，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String formatDate(Date date) {
        if(date == null) return null;
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    
    /**
     * 将日期转换成字符串，格式为自定义
     */
    public static String formatDate(Date date, String formatStyle) {
        if(date == null || isEmpty(formatStyle)) return null;
        return new SimpleDateFormat(formatStyle).format(date);
    }
    
    /**
     * 将日期字符串转换成日期，只支持如下格式： yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDate(String dateStr) {
        if(LangUtils.isEmpty(dateStr)) return null;
        try {
            //日期格式特殊处理
            if(dateStr.contains("/")){
                dateStr=dateStr.replace("/", "-");
            }
            String f = (dateStr.length() == 10 ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss");
            return new SimpleDateFormat(f).parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * 判断一个字符串日期是不是正确的格式
     * 
     * @author lisheng
     * @date 2014年8月18日 下午2:47:43
     * @return boolean
     * @param dateStr
     * @param format
     */
    public static boolean checkDate(String dateStr, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (Exception e) {
            // 如果不能转换,肯定是错误格式
            return false;
        }
        String dateStr2 = df.format(date);
        // 转换后的日期再转换回String,如果不等,逻辑错误.如format为"yyyy-MM-dd",date为
        // "2006-02-31",转换为日期后再转换回字符串为"2006-03-03",说明格式虽然对,但日期逻辑上不对.
        return dateStr.equals(dateStr2);
    }
    
    /**
     * 将字符串转换为Long，转换失败返回null
     */
    public static Long parseLong(String str) {
        return LangUtils.parseLong(str, null);
    }
    
    /**
     * 将字符串转换为Long，转换失败返回defaultValue
     */
    public static Long parseLong(String str, Long defaultValue) {
        if(str == null) return null;
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            
        }
        return defaultValue;
    }
    
    /**
     * 将字符串转换为Integer，转换失败返回null
     */
    public static Integer parseInteger(String str) {
        return LangUtils.parseInteger(str, null);
    }
    
    /**
     * 将字符串转换为Integer，转换失败返回defaultValue
     */
    public static Integer parseInteger(String str, Integer defaultValue) {
        if(str == null) return null;
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            
        }
        return defaultValue;
    }
    
    /**
     * 将字符串转换为Float，转换失败返回null
     */
    public static Float parseFloat(String str) {
        return LangUtils.parseFloat(str, null);
    }
    
    /**
     * 将字符串转换为Float，转换失败返回defaultValue
     */
    public static Float parseFloat(String str, Float defaultValue) {
        if(str == null) return null;
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            
        }
        return defaultValue;
    }
    
    /**
     * 将字符串转换为Double，转换失败返回null
     */
    public static Double parseDouble(String str) {
        return LangUtils.parseDouble(str, null);
    }
    
    /**
     * 将字符串转换为Double，转换失败返回defaultValue
     */
    public static Double parseDouble(String str, Double defaultValue) {
        if(str == null) return null;
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            
        }
        return defaultValue;
    }
    /**
     * 返回四舍五入
     * 
     * @param result_value
     * @return
     */
    public static Double returnDoubleSimple(double result_value) {
        
        BigDecimal bd = new BigDecimal(result_value);
        BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        Double get_double = Double.parseDouble(bd2.toString());
        return get_double;
    }
    
    public static String escapeHtml(String html) {
        if(html == null) return null;
        return html.replaceAll("<", "&lt;");
    }
    
    /**
     * 生成order by sortName sortOrder语句
     * 
     * @param sortName
     * @param sortOrder
     * @return
     */
    public static String makeSqlOrderBy(String sortName, String sortOrder) {
        if(isNotEmpty(sortName) && isNotEmpty(sortOrder)) {
            return "  order by " + sortName.trim() + "  " + sortOrder.trim();
        } else {
            return null;
        }
    }
    
    /**
     * 保留两位小数 不显示成科学计数法
     * 
     * @param num
     * @return
     */
    public static Double decimalFormat(Double num) {
        DecimalFormat df = new DecimalFormat("#.00");
        return parseDouble(df.format(num));
    }
    
    /**
     * 不显示成科学计数法
     * 
     * @author 7729
     * @date 2013-12-26 下午2:53:09
     * @return String
     * @param num
     */
    public static String numberFormat(Double num) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(num);
    }
    
    /**
     * 判断是否数字1
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for(int i = str.length(); --i >= 0;) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 判断是否数字正则判断
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric_gz(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    
    /**
     * 判断是否是数字 asci码值
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric_asci(String str) {
        for(int i = str.length(); --i >= 0;) {
            int chr = str.charAt(i);
            if(chr < 48 || chr > 57) return false;
        }
        return true;
    }
    
    /**
     * 给其他的站点发送请求
     * @author yin
     * @date 2016年8月19日 下午5:12:36   
     * @param url
     * @param param
     * @return
     */
    public static String httpURLConnection(String url, String param) {
        try {
            if(param != null){
                param = new String(param.getBytes("UTF-8"), "ISO-8859-1");
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        DataOutputStream out = null;
        try {
            URL u = new URL(url);// 请求的
            HttpURLConnection urlConn = (HttpURLConnection) u.openConnection();// 打开连接
            urlConn.setInstanceFollowRedirects(false);
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); // json格式
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            //urlConn.setRequestProperty("requiredParam", PlatReqHead.getPlatReqJson(X_Uid));
            urlConn.setRequestMethod("POST"); // post请求
            urlConn.setRequestProperty("Charset", "UTF-8");
            urlConn.connect();
            out = new DataOutputStream(urlConn.getOutputStream());
            out.writeBytes(param);
            out.flush();
            out.close();
            String str = null;

            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    urlConn.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    
    /**
     * 获取所有Fields
     * @param clazz
     * @return
     */
    public static List<Field> getAllFields(Class<?> clazz){
        if(!clazz.equals(Object.class)){
            List<Field> fields = new ArrayList<Field>(Arrays.asList(clazz.getDeclaredFields()));
         
            return fields;
        }else{
            return null;
        }
    }
    /**
     * 
     * 整数相除 保留一位小数
     *
     * @author wangsl
     * @date 2018年4月23日下午2:44:12
     * @param a
     * @param b
     * @return
     */
    public static String division(int a ,int b){
        String result = "";
        float num =(float)a/b;

        DecimalFormat df = new DecimalFormat("0.0");

        result = df.format(num);

        return result;

    }
    
}
