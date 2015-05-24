package com.parkcharge.car.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.CarBrand;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarBrandServiceImpl extends Hibernate3CRUDImpl<CarBrand> implements CarBrandService {

	@Override
	public void addDefaultCarBrand() {
		CarBrand carBrand1 = new CarBrand();
		CarBrand carBrand2 = new CarBrand();
		CarBrand carBrand3 = new CarBrand();
		CarBrand carBrand4 = new CarBrand();
		CarBrand carBrand5 = new CarBrand();
		CarBrand carBrand6 = new CarBrand();
		CarBrand carBrand7 = new CarBrand();
		CarBrand carBrand8 = new CarBrand();
		CarBrand carBrand9 = new CarBrand();
		CarBrand carBrand10 = new CarBrand();
		CarBrand carBrand11 = new CarBrand();

		carBrand1.setName("绿源");
		carBrand2.setName("新日");
		carBrand3.setName("爱玛");
		carBrand4.setName("雅迪");
		carBrand5.setName("立马");
		carBrand6.setName("小鸟");
		carBrand7.setName("雅马哈");
		carBrand8.setName("捷安特");
		carBrand9.setName("比德文");
		carBrand10.setName("澳柯玛");
		carBrand11.setName("其他");

		this.add(carBrand1);
		this.add(carBrand2);
		this.add(carBrand3);
		this.add(carBrand4);
		this.add(carBrand5);
		this.add(carBrand6);
		this.add(carBrand7);
		this.add(carBrand8);
		this.add(carBrand9);
		this.add(carBrand10);
		this.add(carBrand11);

	}

	@Override
	public boolean add(CarBrand carBrand, int flag) {
		// 添加车辆品牌之前先判断是否已有相同名称的品牌
		boolean hasRepeat = this.hasCarBrandName(carBrand);
		if (hasRepeat == true) {
			return false;
		}

		this.add(carBrand);

		return true;
	}

	@Override
	public boolean del(int id, int flag) {
		// 先检测车辆品牌是否已经使用了，如果被使用了，则不能删除
		String sql_has_used = "select 1 from car where car_brand_id=" + id;
		int row_count = this.getRowCountBySql(sql_has_used, null);

		if (row_count > 0) {
			return false;
		}

		CarBrand carBrand = this.getEntityById(id);
		this.del(carBrand);
		return true;
	}

	@Override
	public boolean edit(CarBrand carBrand, int flag) {
		// 首先检测一下，原名称和现在的是否相同，如果相同则直接返回，否则需要检测新的名称在表中是否有重复的
		CarBrand tmpCarBrand = this.getEntityById(carBrand.getId());
		if (tmpCarBrand.getName().equals(carBrand.getName())) {
			return true;
		}

		// 检测是否有重名
		boolean hasRepeat = this.hasCarBrandName(carBrand);
		if (hasRepeat == true) {
			return false;
		}

		this.edit(carBrand);

		return true;
	}

	/**
	 * 检测是否有重复的品牌名称
	 * 
	 * @param carBrand 车辆品牌
	 * @return 有重复的名称返回true，没有返回false
	 */
	private boolean hasCarBrandName(CarBrand carBrand) {
		// 检测新名字是否现在有重复
		String sql_has_brand_name = "select 1 from car_brand where name=:name";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", carBrand.getName());
		int row_count = this.getRowCountBySql(sql_has_brand_name, params);

		if (row_count > 0) {
			return true;
		}

		return false;
	}

}
