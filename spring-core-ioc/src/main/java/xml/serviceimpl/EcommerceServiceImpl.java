package xml.serviceimpl;

import xml.service.BusinessService;

public class EcommerceServiceImpl implements BusinessService {

    @Override
    public String offerService(String name) {
        return "Ecommerce Service Impl = " + name;
    }
}
