package com.parkcharge.sys.entity;

/**
 * 操作员
 * 
 * @author 陈捷
 *
 */
public class Operator {
	private int id;
	private String name;// 用户名
	private String pass;// 密码
	private String email;// 邮箱地址

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
