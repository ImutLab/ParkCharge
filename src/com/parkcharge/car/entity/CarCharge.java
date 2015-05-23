package com.parkcharge.car.entity;

import java.util.Date;

/**
 * 车辆收费表
 * 
 * @author 陈捷
 *
 */
public class CarCharge {
	private int id;
	private int money;// 缴费金额
	private Date charge_date;// 缴费日期
	private Date expire_date;// 过期日期

	private Car car;// 车辆信息
	
	public Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getCharge_date() {
		return charge_date;
	}

	public void setCharge_date(Date charge_date) {
		this.charge_date = charge_date;
	}

}
