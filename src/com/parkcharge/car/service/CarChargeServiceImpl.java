package com.parkcharge.car.service;

import org.springframework.stereotype.Service;
import com.parkcharge.car.entity.CarCharge;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class CarChargeServiceImpl extends Hibernate3CRUDImpl<CarCharge> implements CarChargeService {

}
