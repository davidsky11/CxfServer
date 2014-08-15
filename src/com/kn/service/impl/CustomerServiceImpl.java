package com.kn.service.impl;

import java.util.Calendar;

import com.kn.bean.Customer;
import com.kn.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer findCustomerById(String id) {
		Customer customer = new Customer();
		customer.setId("customer_" + id);
		customer.setName("customer_kn");
		customer.setBirthday(Calendar.getInstance().getTime());
		return customer;
	}
	
	@Override
	public Customer findCustomerByName(String name) {
		Customer customer = new Customer();
		customer.setId(name);
		customer.setName(name);
		customer.setBirthday(Calendar.getInstance().getTime());
		return customer;
	}

}
