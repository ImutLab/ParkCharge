package com.parkcharge.car.entity;

/**
 * 车辆收费表
 * 
 * @author 陈捷
 *
 */
public class CarCharge {
	private int id;
	private int money;// 缴费金额
	private String charge_date;// 缴费日期
	private String expire_date;// 过期日期
	private int isdel;// 是否删除，0正常，1删除

	public int getIsdel() {
		return isdel;
	}

	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	private Car car;// 车辆信息

	public String getCharge_date() {
		return charge_date;
	}

	public void setCharge_date(String charge_date) {
		this.charge_date = charge_date;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
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

}
