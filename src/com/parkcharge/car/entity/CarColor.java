package com.parkcharge.car.entity;

/**
 * 汽车颜色
 * 
 * @author 陈捷
 *
 */
public class CarColor {
	private int id;
	private String name;// 汽车颜色名称
	private int isdel;// 是否删除，0正常，1删除

	public int getIsdel() {
		return isdel;
	}

	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
