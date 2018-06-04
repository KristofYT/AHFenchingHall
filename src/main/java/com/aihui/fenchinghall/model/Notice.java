package com.aihui.fenchinghall.model;

import javax.persistence.*;

@Entity
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    public int id;

    @Column(name = "content",length = 2000)
    public String content;


}
