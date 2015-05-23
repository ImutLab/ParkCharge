package com.parkcharge.car.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.service.CarChargeService;
import com.parkcharge.car.service.CarService;

@SuppressWarnings("serial")
public class CarChargeAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private CarChargeService carChargeService;
	@Autowired
	private CarService carService;

	private CarCharge carCharge;
	private Car car;

	public CarCharge getCarCharge() {
		return carCharge;
	}

	public void setCarCharge(CarCharge carCharge) {
		this.carCharge = carCharge;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String add() {
		car = carService.getEntity(car.getId());
		carChargeService.add(carCharge,car);
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

}
