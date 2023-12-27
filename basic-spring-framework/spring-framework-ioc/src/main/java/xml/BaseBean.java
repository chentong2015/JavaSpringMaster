package xml;

import xml.service.BusinessService;
import xml.service.HireService;

public class BaseBean {

    private String name;
    private int count;
    private HireService hireService;
    private BusinessService businessService;

    /**
     * 1. Constructor Based Dependency Injection
     */
    public BaseBean(String name, int count, HireService hireService) {
        this.name = name;
        this.count = count;
        this.hireService = hireService;
    }

    /**
     * 使用<property name="postalCode" value="121212">来注入值
     */
    private String postalCode;

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 2. Setter Based Dependency Injection
     */
    public void setBaseService(BusinessService baseService) {
        this.businessService = baseService;
    }

    public void testService() {
        System.out.println(businessService.offerService(name));
        System.out.println(hireService.getHireMessage());
    }

    @Override
    public String toString() {
        return "BaseBean [name=" + name + "]" + " Coount = " + count + " code = " + postalCode;
    }
}
