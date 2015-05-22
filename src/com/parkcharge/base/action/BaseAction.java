package com.parkcharge.base.action;

/**
 * 通用增删改查action接口
 * 
 * @author 陈捷
 * 
 */
public interface BaseAction {
	/**
	 * 添加信息
	 * 
	 * @return 执行成功返回success，执行失败返回error
	 */
	public String add();

	/**
	 * 删除信息
	 * 
	 * @return 执行成功返回success，执行失败返回error
	 */
	public String del();

	/**
	 * 修改信息
	 * 
	 * @return 执行成功返回success，执行失败返回error
	 */
	public String edit();

	/**
	 * 显示添加信息页面
	 * 
	 * @return 执行成功返回success，执行失败返回error
	 */
	public String addPage();

	/**
	 * 显示修改信息页面
	 * 
	 * @return 执行成功返回success，执行失败返回error
	 */
	public String editPage();

	/**
	 * 显示Json列表信息页面
	 * 
	 * @return 执行成功返回success，执行失败返回error
	 */
	public String jsonListPage();

	/**
	 * 获取JsonList信息
	 * 
	 * @return 执行成功返回success，执行失败返回error
	 */
	public String getJsonList();
}
