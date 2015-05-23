package com.parkcharge.car.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.chenjie.util.SqlUtils;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.entity.Employee;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class EmployeeServiceImpl extends Hibernate3CRUDImpl<Employee> implements EmployeeService {

	@Override
	public boolean add(Employee employee, Car car, CarCharge carCharge) {
		try {
			// 根据登记日期来获取下月过期日期
			Map<String, String> params = new HashMap<String, String>();
			params.put("charge_date", carCharge.getCharge_date());
			String sql_charge_date = this.getNameSql("CarCharge.query_expire_date_by_charge_date");
			sql_charge_date = SqlUtils.convertSql(sql_charge_date, params);
			String expire_date = (String) this.queryBySql(sql_charge_date, null).get(0).get("expire_date");
			carCharge.setExpire_date(expire_date);

			// 设置级联关系
			Set<CarCharge> carCharges = new HashSet<CarCharge>();
			carCharges.add(carCharge);
			car.setCarCharges(carCharges);
			Set<Car> cars = new HashSet<Car>();
			cars.add(car);
			employee.setCars(cars);

			this.add(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
