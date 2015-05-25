package com.parkcharge.car.service;

import org.springframework.stereotype.Service;
import com.parkcharge.car.entity.Car;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarServiceImpl extends Hibernate3CRUDImpl<Car> implements CarService {

	@Override
	public void destoryCar(Car car) {
		
		String sql_destory_car="update car set isdel=1 where car_id="+car.getId();
		String sql_destory_employee="update employee set isdel=1 where employee_id="+car.getEmployee().getId();
		
		this.executeSQL(sql_destory_employee);
		this.executeSQL(sql_destory_car);
	}

}
