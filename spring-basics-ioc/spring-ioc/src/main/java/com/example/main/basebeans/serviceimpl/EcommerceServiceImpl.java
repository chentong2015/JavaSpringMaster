package com.example.main.basebeans.serviceimpl;

import com.example.main.basebeans.service.BusinessService;

public class EcommerceServiceImpl implements BusinessService {

	@Override
	public String offerService(String name) {
		return "Ecommerce Service Impl = " + name;
	}
}
