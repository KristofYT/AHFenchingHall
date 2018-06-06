package com.aihui.fenchinghall.model;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "manager_id")
        public int id;

        @Column(name = "name")
        public String name;

        @Column(name = "m_job")
        public String m_job;

        @Column(name = "con_text",length = 2000)
        public String con_text;

        @Column(name = "upload_add")
        public String upload_add;

}
