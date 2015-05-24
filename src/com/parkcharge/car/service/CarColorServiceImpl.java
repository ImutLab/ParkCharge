package com.parkcharge.car.service;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.CarColor;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarColorServiceImpl extends Hibernate3CRUDImpl<CarColor> implements CarColorService {

	@Override
	public void addDefaultCarColor() {
		CarColor carColor1=new CarColor();
		CarColor carColor2=new CarColor();
		CarColor carColor3=new CarColor();
		CarColor carColor4=new CarColor();
		CarColor carColor5=new CarColor();
		
		
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

}
