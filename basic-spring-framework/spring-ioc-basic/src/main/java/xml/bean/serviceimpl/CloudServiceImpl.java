package xml.bean.serviceimpl;

import xml.bean.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offerService(String name) {
		return "Cloud Service Impl =" + name;
	}
}
