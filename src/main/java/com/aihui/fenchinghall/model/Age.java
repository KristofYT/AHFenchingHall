package com.aihui.fenchinghall.model;

import javax.persistence.*;

@Entity
@Table(name = "age")
public class Age {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "age_id")
    public int id;

    @Column(name = "age")
    public String age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
