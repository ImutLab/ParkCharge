package com.parkcharge.car.entity;

/**
 * 车辆信息
 * 
 * @author 陈捷
 *
 */
public class Car {
	private int id;
	private String car_num;// 车辆号码
	private CarColor car_color;// 车辆颜色
	private CarBrand car_brand;// 车辆品牌

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
