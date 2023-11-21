package com.spring.batch.config;

import com.spring.batch.xml.Transaction;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {

    @Override
    public Transaction process(Transaction transaction) {
        return transaction;
    }
}
