package com.parkcharge.car.aop;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.DateUtils;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.entity.Employee;
import com.parkcharge.sys.entity.Log;
import com.parkcharge.sys.service.LogService;

/**
 * 人员信息AOP
 * 
 * @author 陈捷
 *
 */
public class EmployeeAop {

	@Autowired
	private LogService logService;

	/**
	 * 新户登记日志
	 * 
	 * @param employee 人员信息
	 * @param car 车辆信息
	 * @param carCharge 车辆收费信息
	 * @param returnValue 返回值
	 */
	public void logAddEmployee(Employee employee, Car car, CarCharge carCharge, boolean returnValue) {
		Log log = new Log();
		log.setActionName("新户登记");
		if (returnValue == true) {
			log.setOtherInfo("登记成功!新户名称:" + employee.getName() + 
					",车辆品牌:" + car.getCar_brand().getName() + 
					",车辆颜色:" + car.getCar_color().getName() + 
					",收费金额:" + carCharge.getMoney() + 
					",收费日期:"+ carCharge.getCharge_date() + 
					",车主编号:" + employee.getId() + 
					",车辆编号:" + car.getId());
		} else {
			log.setOtherInfo("登记失败!");
		}

		log.setManager("admin");
		log.setActionDate(DateUtils.formatDate(new Date()));

		logService.add(log);
	}
	
	
	/**
	 * 修改车主信息日志
	 * 
	 * @param employee 车主信息
	 * @param car 车辆信息
	 * @param returnValue edit返回值
	 */
	public void logEditEmployee(Employee employee, Car car,boolean returnValue) {
		Log log = new Log();
		log.setActionName("修改用户");
		if (returnValue == true) {
			log.setOtherInfo("修改成功!车主新名称:" + employee.getName() + 
					",车辆品牌:" + car.getCar_brand().getName() + 
					",车辆颜色:" + car.getCar_color().getName() + 
					",车主编号:" + employee.getId() + 
					",车辆编号:" + car.getId());
		} else {
			log.setOtherInfo("修改失败!");
		}
		
		log.setManager("admin");
		log.setActionDate(DateUtils.formatDate(new Date()));
		
		logService.add(log);
	}
}
