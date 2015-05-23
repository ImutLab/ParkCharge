package com.parkcharge.car.service;

import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.entity.Employee;
import com.persistent.dao.HibernateCRUD;

public interface EmployeeService extends HibernateCRUD<Employee> {

	/**
	 * 新户登记
	 * 
	 * @param employee 人员信息
	 * @param car 车辆信息
	 * @param carCharge 车辆收费信息
	 */
	public boolean add(Employee employee, Car car, CarCharge carCharge);

}
