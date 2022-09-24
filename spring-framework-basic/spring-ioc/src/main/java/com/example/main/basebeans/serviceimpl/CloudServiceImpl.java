package com.example.main.basebeans.serviceimpl;

import com.example.main.basebeans.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offerService(String name) {
		return "Cloud Service Impl =" + name;
	}
}
