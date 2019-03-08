package com.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.beanutils.PropertyUtils;



/**
 * 实体转换器，允许对实体添加新的字段、修改字段名称和删除字段，或者做一些额外处理。一般在向页面输送实体列表时使用本类。例如： 在向页面传送人员列表List&lt;User&gt;
 * users时，需要给每个User实体添加机构名称字段，可使用如下代码：<br/>
 * new Converter().addField("orgName", "orgId", Orgment.class, "name").toListOfMap(users);
 * 其中，orgName 是新添加的字段名，orgId是User的字段，name是Orgment是字段
 * 
 * @author lisheng
 * @date 2015年11月6日 上午11:33:59
 */
public class Converter {
    
    
    /**
     * 要添加的新字段，key为将要添加到实体中的新属性的名称，value为实现了Convert接口的取值规则。
     */
    private static Map<String, Convert<Object>> newFields = new HashMap<String, Convert<Object>>();
    
    /**
     * 要修改名称的字段，key为原字段名，value为新字段名
     */
    private static Map<String, String> changeFields = new HashMap<String, String>();
    
    /**
     * 要删除的字段名称
     */
    private static Set<String> removeFields = new HashSet<String>();
    
    /**
     * 要对每个实体进行一些处理的方法
     */
    private static Set<Handle<Object>> handlers = new HashSet<Handle<Object>>();
    
    /**
     * 实体类的get方法缓存，结构为：{类:{属性名:属性的get方法}}
     */
    private static Map<Class<?>, Map<String, Method>> fieldAccessorCache = new ConcurrentHashMap<Class<?>, Map<String, Method>>();
    
    
    /**
     * 转换分页对象中的列表为Map列表
     */
    // public Page toListOfMap(Page page){
    // page.setResult(this.toListOfMap(page.getResult()));
    // return page;
    // }
    
    
    /**
     * 改变字段名称
     * 
     * @param newFileName
     *            新字段名称
     * @param oldFieldName
     *            原字段名称
     */
    public Converter changeField(String newFileName, String oldFieldName) {
        changeFields.put(oldFieldName, newFileName);
        return this;
    }
    
    /**
     * 删除字段，可同时删除多个字段
     * 
     * @param fieldNames
     *            要删除的字段名称
     */
    public Converter removeField(String... fieldNames) {
        for(String fieldName : fieldNames) {
            removeFields.add(fieldName);
        }
        return this;
    }
    
    /**
     * 添加要对每个实体进行处理的方法，这个方法将在转换实体前执行。
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Converter addHandler(Handle handler) {
        this.handlers.add(handler);
        return this;
    }
    
    /**
     * 把一个对象里面的字段的值赋值给另外一个对象里面的字段的值
     * 
     * @author lisheng
     * @date 2015年11月6日 上午11:57:46
     * @return T 目标对象
     * @param dest
     *            目标对象
     * @param orig
     *            源对象
     * @param destClazz
     *          LangUtils.java  目标class对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T copyProperties(Object dest, Object orig, Class<T> destClazz) {
        try {
            
            if(LangUtils.isEmpty(dest)) {
                dest = destClazz.newInstance();
            }
            PropertyUtils.copyProperties(dest, orig);
        } catch (Exception e) {
            return (T) dest;
        }
        return (T) dest;
        
    }
    
    /**
     * 要对实体进行处理的方法接口
     * 
     * @author LinZongxue
     * 
     * @param <T>
     *            原实体类
     */
    public interface Handle<T> {
        public void handle(T src);
    }
    
    /**
     * 字段转换规则接口。 实现该接口的to方法，完成实际的转换逻辑。
     * 
     * @author LinZongxue
     * 
     */
    public interface Convert<T> {
        /**
         * 字段转换逻辑
         * 
         * @param src
         *            要转换的实体类
         * @return 目标字段的值
         */
        public Object to(T src);
    }
    
    /**
     * 常量转换器
     * 
     * @author LinZongxue
     */
    private class ConstConverter implements Convert<Object> {
        private Object constValue;
        
        /**
         * 常量转换器
         * 
         * @param constValue
         *            要转换成的常量
         */
        public ConstConverter(Object constValue) {
            this.constValue = constValue;
        }
        
        @Override
        public Object to(Object src) {
            return constValue;
        }
    }
    
    public static void main(String[] args) {
      
    }
}
