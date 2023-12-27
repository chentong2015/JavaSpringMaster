package com.spring.data.jpa.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "t_large_object_table")
public class LargeObjectEntity {

    @Id
    @GeneratedValue(generator = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    // TODO. Java String映射到JDBC Varchar类型
    //  如果存储的数据量过大，则需要使用对应的JDBC LONGVARCHAR类型
    @Lob
    @Column(name = "json_data")
    @Type(type = "org.hibernate.type.TextType")
    private String jsonData;

    // For binary data in Java 大的二级制数据，用于存储图片
    @Lob
    @Column(name = "photo")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] photo;

    public LargeObjectEntity() {
    }

    public LargeObjectEntity(String name) {
        this.name = name;
    }

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
