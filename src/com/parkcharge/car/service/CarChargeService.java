package com.parkcharge.car.service;

import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.persistent.dao.HibernateCRUD;

public interface CarChargeService extends HibernateCRUD<CarCharge> {

	/**
	 * 添加收费记录，返回车辆id
	 * 
	 * @param carCharge
	 * @param car
	 * @return
	 */
	public int add(CarCharge carCharge, Car car);
}
