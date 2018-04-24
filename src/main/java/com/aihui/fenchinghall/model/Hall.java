package com.aihui.fenchinghall.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hall_id")
    private int id;

    @NotEmpty(message = "Please provide a camera name")
    @Column(name = "hallName")
    private  String hallName;

    @Column(name = "phone")
    @NotEmpty(message = "Please provide your contact number")
    private String phone;

    @OneToMany
    @JoinTable(name = "hall_city",joinColumns = @JoinColumn(name = "hall_id"),inverseJoinColumns = @JoinColumn(name = "city_id"))
    private int city;


}
