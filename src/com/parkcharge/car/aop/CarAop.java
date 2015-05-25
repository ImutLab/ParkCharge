package com.parkcharge.car.aop;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.DateUtils;
import com.parkcharge.car.entity.Car;
import com.parkcharge.sys.entity.Log;
import com.parkcharge.sys.service.LogService;

/**
 * 车辆信息AOP
 * 
 * @author 陈捷
 *
 */
public class CarAop {

	@Autowired
	private LogService logService;

	/**
	 * 车辆注销日志
	 * 
	 * @param car
	 */
	public void logDestoryCar(Car car) {
		Log log = new Log();
		log.setActionDate(DateUtils.formatDate(new Date()));
		log.setActionName("车辆注销");
		log.setManager("admin");
		log.setOtherInfo("车主姓名:" + car.getEmployee().getName() + ",车辆品牌:" + car.getCar_brand().getName() + ",车辆颜色:" + car.getCar_color().getName());

		logService.add(log);
	}
}
