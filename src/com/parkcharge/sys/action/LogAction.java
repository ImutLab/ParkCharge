package com.parkcharge.sys.action;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.sys.service.LogService;

/**
 * 操作日志Action
 * 
 * @author 陈捷
 *
 */
@SuppressWarnings("serial")
public class LogAction extends BaseActionImpl implements BaseAction {

	@Autowired
	private LogService logService;

	List<Map<String, Object>> list_log;

	public List<Map<String, Object>> getList_log() {
		return list_log;
	}

	public void setList_log(List<Map<String, Object>> list_log) {
		this.list_log = list_log;
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
		list_log=logService.queryBySqlPage("select * from sys_log order by sys_log_id desc", null,1,100);
		return SUCCESS;
	}

	@Override
	public String getJsonList() {
		// TODO Auto-generated method stub
		return null;
	}

}
