package com.parkcharge.car.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.Employee;
import com.parkcharge.car.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeAction extends BaseActionImpl implements BaseAction{
	
	@Autowired
	private EmployeeService employeeService;
	
	private Employee employee;
	private Car car;
	
	
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
	
	/**
	 * 返回到主页
	 * @return
	 */
	public String mainFramePage() {
		return SUCCESS;
	}

}
