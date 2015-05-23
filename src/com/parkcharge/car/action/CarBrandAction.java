package com.parkcharge.car.action;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.service.CarBrandService;

@SuppressWarnings("serial")
public class CarBrandAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private CarBrandService carBrandService;
	
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
		jsonobj=JSONObject.fromObject(carBrandService.getJsonMapByNameSql("CarBrand.getJsonList", null, 1, 100));
		return SUCCESS;
	}

}
