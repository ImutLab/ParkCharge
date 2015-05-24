package com.parkcharge.car.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.entity.CarBrand;
import com.parkcharge.car.service.CarBrandService;

@SuppressWarnings("serial")
public class CarBrandAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private CarBrandService carBrandService;

	private CarBrand carBrand;
	private List<CarBrand> list_carBrand;

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public List<CarBrand> getList_carBrand() {
		return list_carBrand;
	}

	public void setList_carBrand(List<CarBrand> list_carBrand) {
		this.list_carBrand = list_carBrand;
	}

	@Override
	public String add() {
		Map<String, Object> map_json = new HashMap<String, Object>();
		map_json.put("data", carBrandService.add(carBrand, 1));
		jsonobj = JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	@Override
	public String del() {
		Map<String,Object> map_json=new HashMap<String,Object>();
		map_json.put("data", carBrandService.del(id,1));
		jsonobj=JSONObject.fromObject(map_json);
		
		return SUCCESS;
	}

	@Override
	public String edit() {
		Map<String,Object> map_json=new HashMap<String,Object>();
		map_json.put("data", carBrandService.edit(carBrand, 1));
		jsonobj=JSONObject.fromObject(map_json);
		return SUCCESS;
	}

	@Override
	public String addPage() {
		return SUCCESS;
	}

	@Override
	public String editPage() {
		carBrand=carBrandService.getEntityById(id);
		return SUCCESS;
	}

	@Override
	public String jsonListPage() {
		list_carBrand=carBrandService.queryByHql("From CarBrand where isdel=0", null);
		return SUCCESS;
	}

	@Override
	public String getJsonList() {
		jsonobj = JSONObject.fromObject(carBrandService.getJsonMapByNameSql("CarBrand.getJsonList", null, 1, MAX_RESULT_NUM));
		return SUCCESS;
	}

	public String addDefaultCarBrand() {
		carBrandService.addDefaultCarBrand();
		return SUCCESS;
	}

}
