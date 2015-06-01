package org.lyndon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Lyndon on 30/5/15.
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

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

}
