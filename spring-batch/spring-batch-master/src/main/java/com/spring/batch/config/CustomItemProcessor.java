package com.spring.batch.config;

import com.spring.batch.xml.Transaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;

public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {

    // Processor: 定义读取数据的加工过程，传递的参数非空
    @Override
    public Transaction process(@NonNull Transaction transaction) {
        System.out.println("processing transaction item");
        return transaction;
    }
}
