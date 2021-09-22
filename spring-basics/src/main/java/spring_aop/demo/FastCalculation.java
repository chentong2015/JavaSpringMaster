package spring_aop.demo;

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
        return 0;
    }
}
