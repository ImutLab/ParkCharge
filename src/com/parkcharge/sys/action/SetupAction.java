package com.parkcharge.sys.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.util.FileUtils;
import com.parkcharge.base.action.BaseAction;
import com.parkcharge.base.action.BaseActionImpl;
import com.parkcharge.car.service.CarBrandService;
import com.parkcharge.car.service.CarColorService;
import com.parkcharge.sys.service.OperatorService;

@SuppressWarnings("serial")
public class SetupAction extends BaseActionImpl implements BaseAction {
	@Autowired
	private CarBrandService carBrandService;
	@Autowired
	private CarColorService carColorService;
	@Autowired
	private OperatorService operatorService;

	private String fileName;// 文件名

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	/**
	 * 初始化安装
	 * 
	 * @return
	 */
	public String install() {
		int row_count = 0;
		String sql_has_operator = "select 1 from operator";
		row_count = operatorService.getRowCountBySql(sql_has_operator, null);
		if (row_count == 0) {
			operatorService.addDefaultOperator("admin");
		}

		row_count = 0;
		String sql_has_car_brand = "select 1 from car_brand";
		row_count = carBrandService.getRowCountBySql(sql_has_car_brand, null);
		if (row_count == 0) {
			carBrandService.addDefaultCarBrand();
		}

		row_count = 0;
		String sql_has_car_color = "select 1 from car_color";
		row_count = carColorService.getRowCountBySql(sql_has_car_color, null);
		if (row_count == 0) {
			carColorService.addDefaultCarColor();
		}

		FileUtils.removeFile(fileName);

		return SUCCESS;
	}

}
