package com.parkcharge.car.service;

import com.parkcharge.car.entity.CarColor;
import com.persistent.dao.HibernateCRUD;

public interface CarColorService extends HibernateCRUD<CarColor> {

	/**
	 * 添加默认的车辆颜色
	 */
	public void addDefaultCarColor();

	/**
	 * 添加车辆颜色
	 * 
	 * @param carColor 车辆颜色
	 * @param flag 标志，无用
	 * @return 添加成功返回true，删除失败返回false
	 */
	public boolean add(CarColor carColor, int flag);

	/**
	 * 修改车辆颜色
	 * 
	 * @param carColor 车辆颜色
	 * @param flag 标志，无用
	 * @return 修改成功返回true，删除失败返回false
	 */
	public boolean edit(CarColor carColor, int flag);

	/**
	 * 删除车辆颜色
	 * 
	 * @param carColor 车辆颜色
	 * @param flag 标志，无用
	 * @return 删除成功返回true，删除失败返回false
	 */
	public boolean del(int id, int flag);

}
