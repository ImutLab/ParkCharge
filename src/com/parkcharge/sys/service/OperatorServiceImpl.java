package com.parkcharge.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chenjie.util.EncryptUtils;
import com.chenjie.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.parkcharge.sys.entity.Operator;
import com.persistent.impl.Hibernate3CRUDImpl;

/**
 * 操作员Service
 * 
 * @author 陈捷
 *
 */
@Service
public class OperatorServiceImpl extends Hibernate3CRUDImpl<Operator> implements OperatorService {

	@Override
	public Operator login(String uname, String upass) {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("name", uname);
		queryParams.put("pass", EncryptUtils.MD5(upass));

		List<Operator> list_operator = this.queryByHql("From Operator where name=:name and pass=:pass", queryParams);
		if (list_operator == null || list_operator.size() == 0) {
			return null;
		}

		return list_operator.get(0);
	}

	@Override
	public boolean editPass(Operator operator, String oldPass, String newPass, String uemail) {
		if (operator == null) {
			return false;
		}

		oldPass = EncryptUtils.MD5(oldPass);
		newPass = EncryptUtils.MD5(newPass);

		if (!oldPass.equals(operator.getPass())) {
			return false;
		}

		operator.setPass(newPass);
		operator.setEmail(uemail);
		this.edit(operator);

		ActionContext.getContext().getSession().put("operator", operator);
		return true;
	}

	@Override
	public void addDefaultOperator(String uname) {
		Operator operator = new Operator();
		operator.setName(uname);
		operator.setPass(EncryptUtils.MD5("123456"));
		operator.setEmail("email@qq.com");

		this.add(operator);
	}

	@Override
	public String editForgetPass(String uname, String uemail) {
		String newPass = null;
		String sql_has_operator = "select 1 from operator where name=:name and email=:email";
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("name", uname);
		queryParams.put("email", uemail);

		int row_count = this.getRowCountBySql(sql_has_operator, queryParams);

		if (row_count > 0) {
			newPass = StringUtils.getRandomString(6);
			String hql_get_operator = "From Operator where name=:name and email=:email";
			Operator operator = this.getEntityByHql(hql_get_operator, queryParams);
			operator.setPass(EncryptUtils.MD5(newPass));
			this.edit(operator);
		}

		return newPass;
	}

}
