package com.spring.data.jpa.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "t_large_object_table")
public class SettingsEntity {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    // TODO. 大对象的存储必须要放到transaction事务中，因为它可能是一个耗时的操作 !!
    //  A large object can be stored in several records,
    //  that's why you have to use a transaction. All records are correct or nothing at all.
    @Lob
    @Column(name = "json_data", nullable = false)
    @Type(type = "org.hibernate.type.StringType")
    private String jsonData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
