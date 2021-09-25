package spring_aop.aspect_transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionCalculation {

    @Transactional
    public void pay(String accountId, double money) {
        System.out.println("Test ...");
    }
}
