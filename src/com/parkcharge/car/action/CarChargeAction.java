package com.parkcharge.car.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.Car;
import com.parkcharge.car.entity.CarCharge;
import com.parkcharge.car.service.CarChargeService;
import com.parkcharge.car.service.CarService;

@SuppressWarnings("serial")
public class CarChargeAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private CarChargeService carChargeService;
	@Autowired
	private CarService carService;

	private CarCharge carCharge;
	private Car car;
	List<Map<String, Object>> list_car_charge;

	public List<Map<String, Object>> getList_car_charge() {
		return list_car_charge;
	}

	public void setList_car_charge(List<Map<String, Object>> list_car_charge) {
		this.list_car_charge = list_car_charge;
	}

	public CarCharge getCarCharge() {
		return carCharge;
	}

	public void setCarCharge(CarCharge carCharge) {
		this.carCharge = carCharge;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String add() {
		car = carService.getEntity(car.getId());
		Map<String,Object> map_json=new HashMap<String,Object>();
		map_json.put("car_id", carChargeService.add(carCharge, car));
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
	 * 根据车辆id来查询缴费记录(JSON)
	 * 
	 * @return
	 */
	public String getJsonListByCarId() {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("car_id", car.getId());
		jsonobj = JSONObject.fromObject(carChargeService.getJsonMapByNameSql("CarCharge.getJsonListCarChargeByCarId", queryParams, 1, MAX_RESULT_NUM));
		return SUCCESS;
	}

	/**
	 * 根据车辆id来查询缴费记录
	 * 
	 * @return
	 */
	public String jsonListByCarIdPage() {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("car_id", car.getId());
		list_car_charge = carChargeService.queryByNameSql("CarCharge.getJsonListCarChargeByCarId", queryParams);
		return SUCCESS;
	}

	/**
	 * 欠费查询
	 * 
	 * @return
	 */
	public String expireListPage() {
		list_car_charge = carChargeService.queryByNameSql("CarCharge.getJsonListExpire", null);
		return SUCCESS;
	}
}
