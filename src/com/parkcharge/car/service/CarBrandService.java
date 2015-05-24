package com.parkcharge.car.service;

import com.parkcharge.car.entity.CarBrand;
import com.persistent.dao.HibernateCRUD;

public interface CarBrandService extends HibernateCRUD<CarBrand> {

	/**
	 * 添加默认品牌
	 */
	public void addDefaultCarBrand();

}
