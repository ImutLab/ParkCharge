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

	public void delCheck(CarCharge carCharge) throws Throwable {
		Car car = carCharge.getCar();
		// 删除之前需要检查收费编号是不是首次收费，如果是第一个则不允许删除
		String sql_car_charge_id_is_first = "select car_id,min(car_charge_id) min_car_charge_id from car_charge where car_id=" + car.getId();
		String min_car_charge_id = logService.queryBySql(sql_car_charge_id_is_first, null).get(0).get("min_car_charge_id").toString();
		String car_charge_id = carCharge.getId() + "";
		if (min_car_charge_id.equals(car_charge_id)) {
			System.out.println("删除了首次收费记录");
			throw new Throwable("不允许删除首次收费记录");
		}

		// 不允许删除中间的收费记录
		String sql_car_charge_id_is_last = "select car_id,max(car_charge_id) max_car_charge_id from car_charge where car_id=" + car.getId();
		String max_car_charge_id = logService.queryBySql(sql_car_charge_id_is_last, null).get(0).get("max_car_charge_id").toString();
		System.out.println("max_car_charge_id:" + max_car_charge_id + ",car_charge_id:" + car_charge_id);
		if (!max_car_charge_id.equals(car_charge_id)) {
			System.out.println("不允许跨收费记录删除");
			throw new Throwable("不允许跨收费记录删除");
		}

		Log log = new Log();
		log.setActionDate(DateUtils.formatDate(new Date()));
		log.setActionName("删除缴费");
		log.setManager("admin");
		log.setOtherInfo("删除的缴费记录-->缴款人:" + car.getEmployee().getName() + ",缴款金额:" + carCharge.getMoney() + ",缴款日期:" + carCharge.getCharge_date() + ",车主编号:" + car.getEmployee().getId() + ",车辆编号:"
				+ car.getId() + "缴费单编号:" + carCharge.getId());
		logService.add(log);
	}
}
