package basebeans.serviceimpl;

import basebeans.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offerService(String name) {
		return "Cloud Service Impl =" + name;
	}
}
