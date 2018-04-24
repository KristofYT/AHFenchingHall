package com.aihui.fenchinghall.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private int id;


    @Column(name = "name")
    @NotEmpty(message = "Please provide your name")
    private String name;

    @Column(name = "phone")
    @NotEmpty(message = "Please provide your contact number")
    private String phone;






}
