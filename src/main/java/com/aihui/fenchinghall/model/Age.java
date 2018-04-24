package com.aihui.fenchinghall.model;

import javax.persistence.*;

@Entity
@Table(name = "age")
public class Age {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "age_id")
    private int id;

    @Column(name = "age")
    private String age;

}
