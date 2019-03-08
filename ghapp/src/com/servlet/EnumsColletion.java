
package com.servlet;

import java.util.ArrayList;
import java.util.List;

import com.enums.BehaviorOptTypes;
import com.enums.PublishTypes;
import com.enums.ReceiveTypes;
import com.enums.UserStatus;
import com.enums.UserStyles;
import com.enums.WfFileStyleTypes;
import com.enums.WfRoleTypes;
import com.form.TreeNode;


/**
 * 
 * 管理枚举类型集合数据
 *
 * @author wangsl
 * @date 2017年6月19日下午1:00:47
 */
public class EnumsColletion {
    
    /**
     * 
     * 获取用户类型集合数据
     *
     * @author wangsl
     * @date 2017年6月19日下午1:01:12
     * @return
     */
    public static List<TreeNode> userType() {
        UserStyles[] arry = UserStyles.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        TreeNode first = new TreeNode();
        first.setText("--请选择--");
        first.setId("");
        lst.add(first);
        for(int i = 1; i < arry.length; i++) {
            UserStyles a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    
    /**
     * 
     * 获取用户类型集合数据默认去掉选择
     *
     * @author wangsl
     * @date 2017年6月19日下午1:01:12
     * @return
     */
    public static List<TreeNode> userTypeDafualt() {
        UserStyles[] arry = UserStyles.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        for(int i = 1; i < arry.length; i++) {
            UserStyles a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    
    /**
     * 
     * 用户状态
     *
     * @author wangsl
     * @date 2017年6月23日上午10:20:16
     * @return
     */
    public static List<TreeNode> userStatus() {
        UserStatus[] arry = UserStatus.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        TreeNode first = new TreeNode();
        first.setText("--请选择--");
        first.setId("");
        lst.add(first);
        for(int i = 1; i < arry.length; i++) {
            UserStatus a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    
    /**
     * 
     * 用户配置记录
     *
     * @author wangsl
     * @date 2017年7月21日下午2:35:53
     * @return
     */
    public static List<TreeNode> optTypes() {
        BehaviorOptTypes[] arry = BehaviorOptTypes.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        for(int i = 1; i < arry.length; i++) {
            BehaviorOptTypes a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    
    /**
     * 
     * 发布类型下拉
     *
     * @author wangsl
     * @date 2017年7月24日上午11:25:59
     * @return
     */
    public static List<TreeNode> publishTypes() {
        PublishTypes[] arry = PublishTypes.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        for(int i = 1; i < arry.length; i++) {
            PublishTypes a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    
    /**
     * 
     * 获取用户角色类型
     *
     * @author wangsl
     * @date 2017年7月27日上午11:59:09
     * @return
     */
    public static List<TreeNode> wfRoleTypes() {
        WfRoleTypes[] arry = WfRoleTypes.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        for(int i = 1; i < arry.length; i++) {
            WfRoleTypes a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    
    /**
     * 
     * 文号下拉
     *
     * @author wangsl
     * @date 2017年7月31日下午3:57:10
     * @return
     */
    public static List<TreeNode> wfFileStyleTypes() {
        WfFileStyleTypes[] arry = WfFileStyleTypes.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        for(int i = 1; i < arry.length; i++) {
            WfFileStyleTypes a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    /**
     * 
     * 获取处理方式下拉
     *
     * @return
     */
    public static List<TreeNode> wfReceiveTypes() {
        ReceiveTypes[] arry = ReceiveTypes.values();
        List<TreeNode> lst = new ArrayList<TreeNode>();
        for(int i = 1; i < arry.length; i++) {
            ReceiveTypes a = arry[i];
            TreeNode tmp = new TreeNode();
            tmp.setText(a.getName());
            tmp.setId(a.getValue() + "");
            lst.add(tmp);
        }
        return lst;
        
    }
    
}
