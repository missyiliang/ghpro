
package com.form;

import java.util.List;
import java.util.Map;

/**
 * 
 * tree模型
 *
 * @author wangsl
 * @date 2017年6月7日下午3:14:22
 */
public class TreeNode {
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String wfroleId;
    
    private String name;

	private String text;// 树节点名称
    
    private String iconCls;// 前面的小图标样式
    
    private Boolean checked = false;// 是否勾选状态
    
    private Map<String, Object> attributes;// 其他参数
    
    private List<TreeNode> children;// 子节点
    
    private String state = "open";// 是否展开(open,closed)
    
    /**
     * 父节点
     */
    private String parentIds;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Boolean getChecked() {
        return checked;
    }
    
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
    
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    
    public List<TreeNode> getChildren() {
        return children;
    }
    
    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getIconCls() {
        return iconCls;
    }
    
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    
    public String getParentIds() {
        return parentIds;
    }
    
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }
    
    public String getWfroleId() {
		return wfroleId;
	}

	public void setWfroleId(String wfroleId) {
		this.wfroleId = wfroleId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
