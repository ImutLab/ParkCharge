package com.parkcharge.car.service;


import org.springframework.stereotype.Service;
import com.parkcharge.car.entity.CarBrand;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarBrandServiceImpl extends Hibernate3CRUDImpl<CarBrand> implements CarBrandService {

}
