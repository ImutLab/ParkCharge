package com.parkcharge.car.action;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;

/**
 * 车辆信息Action
 * 
 * @author 陈捷
 *
 */
@SuppressWarnings("serial")
public class CarAction extends BaseActionImpl implements BaseAction {

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
	

}
