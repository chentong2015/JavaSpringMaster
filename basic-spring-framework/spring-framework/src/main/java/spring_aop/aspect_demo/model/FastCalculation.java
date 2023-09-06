package spring_aop.aspect_demo.model;

import org.springframework.aop.framework.AopContext;

public class FastCalculation implements Calculation {

    @Override
    public int add(int num1, int num2) {
        System.out.println("Call add");
        return 0;
    }

    @Override
    public int reduce(int num1, int num2) {
        System.out.println("Call reduce");
        return 0;
    }

    @Override
    public int div(int num1, int num2) {
        System.out.println("Call div");
        int value1 = ((Calculation) AopContext.currentProxy()).add(10, 10);
        int value2 = this.add(10, 10);
        return 0;
    }
}
