package com.parkcharge.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chenjie.util.EncryptUtils;
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
		Map<String,Object> queryParams=new HashMap<String,Object>();
		queryParams.put("name", uname);
		queryParams.put("pass", EncryptUtils.MD5(upass));
		
		List<Operator> list_operator=this.queryByHql("From Operator where name=:name and pass=:pass", queryParams);
		if(list_operator==null || list_operator.size()==0){
			return null;
		}
		
		return list_operator.get(0);
	}

}
