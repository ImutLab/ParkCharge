package com.parkcharge.car.service;

import org.springframework.stereotype.Service;

import com.parkcharge.car.entity.Employee;
import com.persistent.impl.Hibernate3CRUDImpl;

@Service
public class EmployeeServiceImpl extends Hibernate3CRUDImpl<Employee> implements EmployeeService {

}
