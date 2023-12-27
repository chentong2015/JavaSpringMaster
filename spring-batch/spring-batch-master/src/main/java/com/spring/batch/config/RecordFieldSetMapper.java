package com.spring.batch.config;

import com.spring.batch.xml.Transaction;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecordFieldSetMapper implements FieldSetMapper<Transaction> {

    // TODO. 必须定义FieldSet中名称的token标识，才能通过字符串名称来读取指定位置的数据
    @Override
    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        Transaction transaction = new Transaction();

        transaction.setUsername(fieldSet.readString("username"));
        transaction.setUserId(fieldSet.readInt(1));
        transaction.setAmount(fieldSet.readDouble(3));

        // 必须严格匹配Date日期的格式化，才能解析并读取
        String dateString = fieldSet.readString(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        transaction.setDate(LocalDate.parse(dateString, formatter));
        return transaction;
    }
}
