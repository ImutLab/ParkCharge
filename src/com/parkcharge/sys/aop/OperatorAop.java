package com.parkcharge.sys.aop;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.DateUtils;
import com.parkcharge.sys.entity.Log;
import com.parkcharge.sys.entity.Operator;
import com.parkcharge.sys.service.LogService;

/**
 * 操作员信息AOP
 * 
 * @author 陈捷
 *
 */
public class OperatorAop {
	@Autowired
	private LogService logService;

	/**
	 * 记录修改密码日志
	 * 
	 * @param operator 操作员
	 * @param oldPass 旧密码
	 * @param newPass 新密码
	 * @param returnValue 返回值
	 */
	public void logEditPass(Operator operator, String oldPass, String newPass, boolean returnValue) {
		Log log = new Log();
		log.setManager(operator.getName());
		log.setActionName("修改密码");
		if (returnValue == true) {
			log.setOtherInfo("修改成功!");
		} else {
			log.setOtherInfo("修改密码失败!");
		}

		log.setActionDate(DateUtils.formatDate(new Date()));

		logService.add(log);
	}

	/**
	 * 用户登录记录
	 * 
	 * @param uname 用户名
	 * @param upass 密码
	 * @param returnValue查找到该用户，则返回该用户的具体信息，否则返回null
	 */
	public void logLogin(String uname, String upass, Operator returnValue) {
		Log log=new Log();
		log.setActionDate(DateUtils.formatDate(new Date()));
		log.setActionName("用户登录");
		log.setManager(uname);
		if(returnValue!=null){
			log.setOtherInfo("登录成功!");
		}else{
			log.setOtherInfo("登录失败!");
		}
		
		logService.add(log);
	}
}
