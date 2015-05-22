package com.parkcharge.car.action;

import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;

@SuppressWarnings("serial")
public class EmployeeAction extends BaseActionImpl implements BaseAction{

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
		// TODO Auto-generated method stub
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
