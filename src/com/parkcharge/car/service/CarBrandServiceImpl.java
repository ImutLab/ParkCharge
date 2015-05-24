package com.parkcharge.car.service;


import org.springframework.stereotype.Service;
import com.parkcharge.car.entity.CarBrand;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarBrandServiceImpl extends Hibernate3CRUDImpl<CarBrand> implements CarBrandService {

	@Override
	public void addDefaultCarBrand() {
		CarBrand carBrand1=new CarBrand();
		CarBrand carBrand2=new CarBrand();
		CarBrand carBrand3=new CarBrand();
		CarBrand carBrand4=new CarBrand();
		CarBrand carBrand5=new CarBrand();
		CarBrand carBrand6=new CarBrand();
		CarBrand carBrand7=new CarBrand();
		CarBrand carBrand8=new CarBrand();
		CarBrand carBrand9=new CarBrand();
		CarBrand carBrand10=new CarBrand();
		CarBrand carBrand11=new CarBrand();
		
		
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

}
