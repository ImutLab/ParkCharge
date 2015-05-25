package com.parkcharge.sys.entity;

/**
 * 操作日志表
 * 
 * @author 陈捷
 *
 */
public class Log {
	private int id;
	private String manager;// 管理员
	private String actionName;// 动作名称
	private String actionDate;// 操作日期
	private String otherInfo;// 其他信息

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

}
