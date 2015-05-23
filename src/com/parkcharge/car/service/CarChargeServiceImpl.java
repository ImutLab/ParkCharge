package com.parkcharge.car.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarChargeServiceImpl extends Hibernate3CRUDImpl<CarCharge> implements CarChargeService {

	public void add(CarCharge carCharge,Car car) {
		Map<String,Object> queryParams=new HashMap<String,Object>();
		queryParams.put("car_id", car.getId());
		String next_expire_date=(String) this.queryByNameSql("CarCharge.query_next_expire_date_by_car_id", queryParams).get(0).get("next_expire_date");
		carCharge.setExpire_date(next_expire_date);
		carCharge.setCar(car);
		System.out.println(carCharge.getExpire_date());
		
		this.add(carCharge);
	}

}
