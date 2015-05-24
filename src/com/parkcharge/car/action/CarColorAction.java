package com.parkcharge.car.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.CarColor;
import com.parkcharge.car.service.CarColorService;

@SuppressWarnings("serial")
public class CarColorAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private CarColorService carColorService;

	private CarColor carColor;
	private List<CarColor> list_carColor;

	public CarColor getCarColor() {
		return carColor;
	}

	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}

	public List<CarColor> getList_carColor() {
		return list_carColor;
	}

	public void setList_carColor(List<CarColor> list_carColor) {
		this.list_carColor = list_carColor;
	}

	@Override
	public String add() {
		Map<String,Object> map_json=new HashMap<String,Object>();
		map_json.put("data", carColorService.add(carColor, 1));
		jsonobj=JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	@Override
	public String del() {
		Map<String,Object> map_json=new HashMap<String,Object>();
		map_json.put("data", carColorService.del(id,1));
		jsonobj=JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	@Override
	public String edit() {
		Map<String,Object> map_json=new HashMap<String,Object>();
		map_json.put("data", carColorService.edit(carColor,1));
		jsonobj=JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	@Override
	public String addPage() {
		return SUCCESS;
	}

	@Override
	public String editPage() {
		carColor=carColorService.getEntityById(id);
		return SUCCESS;
	}

	@Override
	public String jsonListPage() {
		list_carColor=carColorService.queryByHql("From CarColor where isdel=0", null);
		return SUCCESS;
	}

	@Override
	public String getJsonList() {
		System.out.println("CarColor getJsonList is run!");
		jsonobj = JSONObject.fromObject(carColorService.getJsonMapByNameSql("CarColor.getJsonList", null, 1, MAX_RESULT_NUM));
		return SUCCESS;
	}

	public String addDefaultCarColor() {
		carColorService.addDefaultCarColor();
		return SUCCESS;
	}

}
