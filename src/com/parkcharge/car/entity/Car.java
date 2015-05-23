package com.parkcharge.car.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 车辆信息
 * 
 * @author 陈捷
 *
 */
public class Car {
	private int id;
	private String car_num;// 车辆号码
	private int car_type;// 车辆类型:0电动车，1摩托车，2小汽车
	private CarColor car_color;// 车辆颜色
	private CarBrand car_brand;// 车辆品牌
	private Employee employee;// 对应人员
	private Set<CarCharge> carCharges = new HashSet<CarCharge>();// 车辆收费记录表

	public Set<CarCharge> getCarCharges() {
		return carCharges;
	}

	public void setCarCharges(Set<CarCharge> carCharges) {
		this.carCharges = carCharges;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getCar_type() {
		return car_type;
	}

	public void setCar_type(int car_type) {
		this.car_type = car_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public CarColor getCar_color() {
		return car_color;
	}

	public void setCar_color(CarColor car_color) {
		this.car_color = car_color;
	}

	public CarBrand getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(CarBrand car_brand) {
		this.car_brand = car_brand;
	}

}
