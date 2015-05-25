package com.parkcharge.sys.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.sys.entity.Operator;
import com.parkcharge.sys.service.OperatorService;

@SuppressWarnings("serial")
public class OperatorAction extends BaseActionImpl implements BaseAction {
	@Autowired
	private OperatorService operatorService;

	private String uname;// 用户名
	private String upass;// 密码

	private Operator operator;// 操作员

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String del() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String jsonListPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJsonList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String login() {
		operator = operatorService.login(uname, upass);
		if (operator == null) {
			return "login_mobile";
		}

		ActionContext.getContext().getSession().put("operator", operator);
		return SUCCESS;
	}
}
