package com.parkcharge.car.service;

import com.parkcharge.car.entity.CarBrand;
import com.persistent.dao.HibernateCRUD;

public interface CarBrandService extends HibernateCRUD<CarBrand> {

	/**
	 * 添加默认品牌
	 */
	public void addDefaultCarBrand();

	/**
	 * 添加车辆品牌
	 * 
	 * @param carBrand 车辆品牌
	 * @param flag 标志，无用
	 * @return 添加成功返回true，添加失败返回false
	 */
	public boolean add(CarBrand carBrand, int flag);

	/**
	 * 删除车辆品牌
	 * 
	 * @param id
	 * @param flag
	 * @return 删除成功返回true，删除失败返回false
	 */
	public boolean del(int id, int flag);

	/**
	 * 修改车辆品牌
	 * @param carBrand
	 * @param flag
	 * @return 修改成功返回true，修改失败返回false
	 */ 
	public boolean edit(CarBrand carBrand, int flag);
}
