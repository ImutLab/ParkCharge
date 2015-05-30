package com.parkcharge.car.aop;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.DateUtils;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.sys.entity.Log;
import com.parkcharge.sys.service.LogService;

/**
 * 收费记录AOP
 * 
 * @author 陈捷
 *
 */
public class CarChargeAop {

	@Autowired
	private LogService logService;

	/**
	 * 添加收费日志
	 * 
	 * @param carCharge 收费信息
	 * @param car 车辆信息
	 */
	public void logAddCarCharge(CarCharge carCharge, Car car) {
		System.out.println("logAddCarCharge被执行...");
		Log log = new Log();
		log.setManager("admin");
		log.setActionName("用户缴费");
		log.setActionDate(DateUtils.formatDate(new Date()));
		log.setOtherInfo("缴款人:" + car.getEmployee().getName() + ",缴款金额:" + carCharge.getMoney() + ",缴款日期:" + carCharge.getCharge_date() + ",车主编号:" + car.getEmployee().getId() + ",车辆编号:" + car.getId());

		logService.add(log);
	}
}
