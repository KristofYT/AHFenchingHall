package com.aihui.fenchinghall.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private int id;

}
