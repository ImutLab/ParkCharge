package com.parkcharge.car.service;

import com.parkcharge.car.entity.CarColor;
import com.persistent.dao.HibernateCRUD;

public interface CarColorService extends HibernateCRUD<CarColor> {

	/**
	 * 添加默认的车辆颜色
	 */
	public void addDefaultCarColor();

}
