package com.parkcharge.car.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.entity.Employee;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class EmployeeServiceImpl extends Hibernate3CRUDImpl<Employee> implements EmployeeService {
	
	@Override
	public void add(Employee employee, Car car, CarCharge carCharge) {
		Set<CarCharge> carCharges=new HashSet<CarCharge>();
		carCharges.add(carCharge);
		car.setCarCharges(carCharges);
		Set<Car> cars=new HashSet<Car>();
		cars.add(car);
		employee.setCars(cars);
		
		this.add(employee);
	}

}
