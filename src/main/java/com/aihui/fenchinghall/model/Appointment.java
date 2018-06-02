package com.aihui.fenchinghall.model;


import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    public int id;


    @Column(name = "name")
    @NotEmpty(message = "Please provide your name")
    public String name;

    @Column(name = "phone")
    @NotEmpty(message = "Please provide your contact number")
    public String phone;

    @Expose
    @ManyToOne
    @JoinColumn(name = "age_id")
    public Age age;

    @Expose
    @ManyToOne
    @JoinColumn(name = "hall_id")
    public Hall hall;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }


}
