package com.parkcharge.sys.service;

import com.parkcharge.sys.entity.Operator;
import com.persistent.dao.HibernateCRUD;

/**
 * 操作员Service
 * 
 * @author 陈捷
 *
 */
public interface OperatorService extends HibernateCRUD<Operator> {

	/**
	 * 用户登录
	 * 
	 * @param uname 用户名
	 * @param upass 密码
	 * @return 查找到该用户，则返回该用户的具体信息，否则返回null
	 */
	public Operator login(String uname, String upass);

	/**
	 * 修改密码
	 * 
	 * @param operator 操作员
	 * @param oldPass 旧密码
	 * @param newPass 新密码
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean editPass(Operator operator, String oldPass, String newPass,String uemail);

	/**
	 * 添加默认操作员
	 */
	public void addDefaultOperator(String uname);

	/**
	 * 忘记密码
	 * 
	 * @param uname 用户名
	 * @param uemail 邮箱地址
	 * @return 找到对应用户名和邮箱地址，则返回新密码
	 */
	public String editForgetPass(String uname, String uemail);

}
