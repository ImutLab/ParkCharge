package com.parkcharge.car.service;

import com.parkcharge.car.entity.Car;
import com.persistent.dao.HibernateCRUD;

public interface CarService extends HibernateCRUD<Car> {

	/**
	 * 注销车辆信息
	 * 
	 * @param car
	 */
	public void destoryCar(Car car);

}
