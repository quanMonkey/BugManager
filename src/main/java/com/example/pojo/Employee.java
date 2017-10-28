package com.example.pojo;


import javax.persistence.*;

/**
 * Created by liuquan on 2017/10/28.
 */
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.TABLE, generator="gen_tbl")
    @TableGenerator(name="gen_tbl",table="gen_table",pkColumnName = "key_name", pkColumnValue = "identity", valueColumnName="key_value")
    private int id;

    @Column
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
