package com.aihui.fenchinghall.model;


import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    public int id;

    @Expose
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    //每周开始的时间
    @Column(name = "year")
    public String year;

    //每周开始的时间
    @Column(name = "time")
    public String time;

    //一年的第几周
    @Expose
    @Column(name = "week")
    public int week;

    @Column(name = "satmor")
    public String satmor;
    @Column(name = "sataft")
    public String sataft;
    @Column(name = "satnig")
    public String satnig;
    @Column(name = "sunmor")
    public String sunmor;
    @Column(name = "sunaft")
    public String sunaft;
    @Column(name = "sunnig")
    public String sunnig;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getSatmor() {
        return satmor;
    }

    public void setSatmor(String satmor) {
        this.satmor = satmor;
    }

    public String getSataft() {
        return sataft;
    }

    public void setSataft(String sataft) {
        this.sataft = sataft;
    }

    public String getSatnig() {
        return satnig;
    }

    public void setSatnig(String satnig) {
        this.satnig = satnig;
    }

    public String getSunmor() {
        return sunmor;
    }

    public void setSunmor(String sunmor) {
        this.sunmor = sunmor;
    }

    public String getSunaft() {
        return sunaft;
    }

    public void setSunaft(String sunaft) {
        this.sunaft = sunaft;
    }

    public String getSunnig() {
        return sunnig;
    }

    public void setSunnig(String sunnig) {
        this.sunnig = sunnig;
    }








}
