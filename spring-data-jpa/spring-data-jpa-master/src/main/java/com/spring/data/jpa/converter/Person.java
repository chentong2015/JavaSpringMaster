package com.spring.data.jpa.converter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PersonTable")
public class Person {

    @Id
    @Column(name = "id")
    private long id;

    // TODO. 该属性使用Converter进行转换，优先考虑HQL来查询属性字段 !!
    //  在数据库中表的列名称可能不一致，在使用Native SQL查询时可能找不到对于的列
    @Column(name = "name")
    @Convert(converter = PersonNameConverter.class)
    private PersonName personName;
}
