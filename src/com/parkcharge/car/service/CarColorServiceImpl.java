package com.parkcharge.car.service;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.CarColor;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarColorServiceImpl extends Hibernate3CRUDImpl<CarColor> implements CarColorService {

}
