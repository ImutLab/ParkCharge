package com.parkcharge.car.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.chenjie.util.DateUtils;
import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarBrand;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.entity.CarColor;
import com.parkcharge.car.entity.Employee;
import com.parkcharge.car.service.CarBrandService;
import com.parkcharge.car.service.CarChargeService;
import com.parkcharge.car.service.CarColorService;
import com.parkcharge.car.service.CarService;
import com.parkcharge.car.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CarBrandService carBrandService;
	@Autowired
	private CarColorService carColorService;
	@Autowired
	private CarService carService;
	@Autowired
	private CarChargeService carChargeService;

	private Employee employee;
	private List<Map<String, Object>> list_employee;
	private Car car;
	private CarCharge carCharge;
	private String charge_date;
	private CarColor carColor;
	private CarBrand carBrand;
	private List<CarBrand> list_carBrand;
	private List<CarColor> list_carColor;

	public List<CarColor> getList_carColor() {
		return list_carColor;
	}

	public void setList_carColor(List<CarColor> list_carColor) {
		this.list_carColor = list_carColor;
	}

	public List<CarBrand> getList_carBrand() {
		return list_carBrand;
	}

	public void setList_carBrand(List<CarBrand> list_carBrand) {
		this.list_carBrand = list_carBrand;
	}

	public CarColor getCarColor() {
		return carColor;
	}

	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public List<Map<String, Object>> getList_employee() {
		return list_employee;
	}

	public void setList_employee(List<Map<String, Object>> list_employee) {
		this.list_employee = list_employee;
	}

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
		car.setCar_brand(carBrandService.getEntity(car.getCar_brand().getId()));//设置关联关系
		car.setCar_color(carColorService.getEntity(car.getCar_color().getId()));//设置关联关系
		Map<String, Object> map_json = new HashMap<String, Object>();
		map_json.put("data", employeeService.add(employee, car, carCharge));
		jsonobj = JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	@Override
	public String del() {
		return SUCCESS;
	}

	@Override
	public String edit() {
		car.setCar_brand(carBrandService.getEntity(car.getCar_brand().getId()));//设置关联关系
		car.setCar_color(carColorService.getEntity(car.getCar_color().getId()));//设置关联关系
		Car tmpCar=carService.getEntityById(car.getId());
		car.setCarCharges(tmpCar.getCarCharges());//设置关联关系
		Map<String, Object> map_json = new HashMap<String, Object>();
		map_json.put("data", employeeService.edit(employee,car));
		jsonobj = JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	@Override
	public String addPage() {
		list_carBrand = carBrandService.queryByHql("From CarBrand where isdel=0", null);
		list_carColor = carColorService.queryByHql("From CarColor where isdel=0", null);
		charge_date = DateUtils.formatDate(new Date());
		return SUCCESS;
	}

	@Override
	public String editPage() {
		employee = employeeService.getEntityById(id);
		car = employee.getCars().iterator().next();
		carColor = car.getCar_color();
		carBrand = car.getCar_brand();

		list_carBrand = carBrandService.queryByHql("From CarBrand where isdel=0", null);
		list_carColor = carColorService.queryByHql("From CarColor where isdel=0", null);

		return SUCCESS;
	}

	@Override
	public String jsonListPage() {
		list_employee = employeeService.queryByNameSql("Employee.getJsonListUnionBrandColorCharge", null);
		return SUCCESS;
	}

	@Override
	public String getJsonList() {
		jsonobj = JSONObject.fromObject(employeeService.getJsonMapByNameSql("Employee.getJsonList", null, 1, MAX_RESULT_NUM));
		return SUCCESS;
	}

	/**
	 * 根据人员id来获取相应的人员车辆信息
	 * 
	 * @return
	 */
	public String getJsonEmployeeCarByEmpId() {
		charge_date = DateUtils.formatDate(new Date());
		Map<String, Object> queryParams = new HashMap<String, Object>();
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
