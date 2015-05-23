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
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public String del() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public String addPage() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public String editPage() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public String jsonListPage() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public String getJsonList() {
		jsonobj=JSONObject.fromObject(carBrandService.getJsonMapByNameSql("CarBrand.getJsonList", null, 1, 100));
		return SUCCESS;
	}

}
