package com.aihui.fenchinghall.model;


import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hall_id")
    public int id;

    @NotEmpty(message = "Please provide a hall name")
    @Column(name = "hall_name")
    public  String hallName;

    @Column(name = "phone")
    @NotEmpty(message = "Please provide your contact number")
    public String phone;

    @Expose
    @ManyToOne
    @JoinColumn(name = "city_id")
    public City city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
