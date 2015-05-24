package com.parkcharge.car.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.CarColor;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarColorServiceImpl extends Hibernate3CRUDImpl<CarColor> implements CarColorService {

	@Override
	public void addDefaultCarColor() {
		CarColor carColor1 = new CarColor();
		CarColor carColor2 = new CarColor();
		CarColor carColor3 = new CarColor();
		CarColor carColor4 = new CarColor();
		CarColor carColor5 = new CarColor();

		carColor1.setName("黑色");
		carColor2.setName("红色");
		carColor3.setName("蓝色");
		carColor4.setName("绿色");
		carColor5.setName("白色");

		this.add(carColor1);
		this.add(carColor2);
		this.add(carColor3);
		this.add(carColor4);
		this.add(carColor5);

	}

	@Override
	public boolean add(CarColor carColor, int flag) {
		boolean hasCarColor = this.hasCarColorName(carColor);
		if (hasCarColor == true) {
			return false;
		}

		this.add(carColor);

		return true;
	}

	@Override
	public boolean edit(CarColor carColor, int flag) {
		//检测名称是否修改过，如果没有修改过，则直接返回true
		CarColor tmpCarColor=this.getEntityById(carColor.getId());
		if(tmpCarColor.getName().equals(carColor.getName())){
			return true;
		}
		
		//如果名称修改过，则需要检测在原来的表中是否有重名
		boolean hasCarColor = this.hasCarColorName(carColor);
		if (hasCarColor == true) {
			return false;
		}
		
		this.edit(carColor);
		
		return true;
	}

	@Override
	public boolean del(int id, int flag) {
		String sql_has_used="select 1 from car where car_color_id="+id;
		int row_count=this.getRowCountBySql(sql_has_used, null);
		if(row_count>0){
			return false;
		}
		
		CarColor carColor=this.getEntityById(id);
		this.del(carColor);
		
		return true;
	}

	/**
	 * 检测是否有此车辆颜色名称
	 * 
	 * @param carColor
	 * @return 有此车辆颜色名称，返回true，没有返回false
	 */
	private boolean hasCarColorName(CarColor carColor) {
		String sql_has_car_color_name = "select 1 from car_color where name=:name";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("name", carColor.getName());
		int row_count = this.getRowCountBySql(sql_has_car_color_name, null);

		if (row_count > 0) {
			return true;
		}

		return false;
	}
}
