package com.parkcharge.car.service;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.Car;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarServiceImpl extends Hibernate3CRUDImpl<Car> implements CarService {

}
