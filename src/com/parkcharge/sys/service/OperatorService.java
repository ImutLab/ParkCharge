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

}
