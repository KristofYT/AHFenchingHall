package com.aihui.fenchinghall.model;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public int id;



    @Column(name = "email")
    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Please provide an email address")
    public String email;

    @Expose
    @Column(name = "active")
    public int active;

    @Column(name = "name")
    @NotEmpty(message = "Please provide your name")
    public String name;



    @Column(name = "phone")
    @NotEmpty(message = "Please provide your contact number")
    public String phone;

    @Column(name = "password")
    @Length(min = 5, message = "Your password must have at least 5 characters")
    public String password;

    @Expose
    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;

//    @ManyToOne
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
