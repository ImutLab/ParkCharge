package com.parkcharge.car.action;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.service.CarColorService;

@SuppressWarnings("serial")
public class CarColorAction extends BaseActionImpl implements BaseAction{
	
	@Autowired
	private CarColorService carColorService;
	
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
		System.out.println("CarColor getJsonList is run!");
		jsonobj=JSONObject.fromObject(carColorService.getJsonMapByNameSql("CarColor.getJsonList", null, 1, MAX_RESULT_NUM));
		return SUCCESS;
	}

}
