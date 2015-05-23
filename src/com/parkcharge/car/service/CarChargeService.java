package com.parkcharge.car.service;

import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.persistent.dao.HibernateCRUD;

public interface CarChargeService extends HibernateCRUD<CarCharge> {
	
	public void add(CarCharge carCharge,Car car);
}
