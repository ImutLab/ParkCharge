package com.parkcharge.car.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.service.CarService;

/**
 * 车辆信息Action
 * 
 * @author 陈捷
 *
 */
@SuppressWarnings("serial")
public class CarAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private CarService carService;
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String add() {
		return SUCCESS;
	}

	@Override
	public String del() {
		return SUCCESS;
	}

	@Override
	public String edit() {
		return SUCCESS;
	}

	@Override
	public String addPage() {
		return SUCCESS;
	}

	@Override
	public String editPage() {
		return SUCCESS;
	}

	@Override
	public String jsonListPage() {
		return SUCCESS;
	}

	@Override
	public String getJsonList() {
		return SUCCESS;
	}

	public String destoryCar() {
		carService.destoryCar(car);
		return SUCCESS;
	}

}
