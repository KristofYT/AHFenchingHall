package com.aihui.fenchinghall.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    public int id;

    @Column(name = "city_name")
    public String city_name;

}
