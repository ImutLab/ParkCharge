package com.parkcharge.car.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.DateUtils;
import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.entity.Employee;
import com.parkcharge.car.service.CarBrandService;
import com.parkcharge.car.service.CarColorService;
import com.parkcharge.car.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CarBrandService carBrandService;
	@Autowired
	private CarColorService carColorService;

	private Employee employee;
	private Car car;
	private CarCharge carCharge;
	private String charge_date;

	public String getCharge_date() {
		return charge_date;
	}

	public void setCharge_date(String charge_date) {
		this.charge_date = charge_date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public CarCharge getCarCharge() {
		return carCharge;
	}

	public void setCarCharge(CarCharge carCharge) {
		this.carCharge = carCharge;
	}

	@Override
	public String add() {
		car.setCar_brand(carBrandService.getEntity(car.getCar_brand().getId()));
		car.setCar_color(carColorService.getEntity(car.getCar_color().getId()));
		Map<String,Object> map_json=new HashMap<String,Object>();
		map_json.put("data", employeeService.add(employee, car, carCharge));
		jsonobj=JSONObject.fromObject(map_json);
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
		charge_date = DateUtils.formatDate(new Date());
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
		jsonobj = JSONObject.fromObject(employeeService.getJsonMapByNameSql("Employee.getJsonList", null, 1, 100));
		return SUCCESS;
	}

	/**
	 * 根据人员id来获取相应的人员车辆信息
	 * 
	 * @return
	 */
	public String getJsonEmployeeCarByEmpId() {
		charge_date = DateUtils.formatDate(new Date());
		Map<String,Object> queryParams=new HashMap<String,Object>();
		queryParams.put("employee_id", id);
		
		Map<String, Object> map_json = new HashMap<String, Object>();
		map_json.put("data", employeeService.queryByNameSql("Employee.getJsonEmployeeCarByEmpId", queryParams).get(0));
		map_json.put("charge_date", charge_date);
		jsonobj = JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	/**
	 * 返回到主页
	 * 
	 * @return
	 */
	public String mainFramePage() {
		return SUCCESS;
	}

}
