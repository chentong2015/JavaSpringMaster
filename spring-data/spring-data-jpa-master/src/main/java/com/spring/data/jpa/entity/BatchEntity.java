package com.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_batch_entity")
public class BatchEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name", columnDefinition = "varchar(32)")
    private String name;

    @Column(name = "m_label", columnDefinition = "varchar(64)")
    private String label;

    public BatchEntity() {
    }

    public BatchEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
