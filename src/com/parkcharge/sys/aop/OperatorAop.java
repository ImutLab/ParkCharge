package com.parkcharge.sys.aop;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.DateUtils;
import com.chenjie.util.EncryptUtils;
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
		System.out.println("logEditPass被执行...");
		Log log=new Log();
		log.setManager(operator.getName());
		if(returnValue==true){
			log.setActionName("修改密码成功!");
			log.setOtherInfo("原密码:"+EncryptUtils.MD5(oldPass)+",新密码:"+EncryptUtils.MD5(newPass));
		}else{
			log.setActionName("修改密码失败!");
		}
		
		log.setActionDate(DateUtils.formatDate(new Date()));
		
		logService.add(log);
	}
}
