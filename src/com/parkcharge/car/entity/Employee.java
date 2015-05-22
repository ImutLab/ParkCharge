package com.parkcharge.car.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 人员信息
 * 
 * @author 陈捷
 *
 */
public class Employee {
	private int id;
	private String name;// 姓名
	private String id_card;// 身份证号
	private String gender;// 性别
	private int age;// 年龄
	private Set<Car> cars = new HashSet<Car>();// 车辆信息

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

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}
