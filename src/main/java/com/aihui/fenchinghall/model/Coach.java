package com.aihui.fenchinghall.model;


import javax.persistence.*;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coach_id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "job")
    public String job;



    @Column(name = "con_text",length = 2000)
    public String con_text;

    @Column(name = "upload_add")
    public String upload_add;
}
