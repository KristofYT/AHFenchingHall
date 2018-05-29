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
    private int id;



    @Column(name = "email")
    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Please provide an email address")
    private String email;

    @Expose
    @Column(name = "active")
    private int active;

    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your firstName")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last firstName")
    private String lastName;

    @Column(name = "phone")
    @NotEmpty(message = "Please provide your contact number")
    private String phone;

    @Column(name = "password")
    @Length(min = 5, message = "Your password must have at least 5 characters")
    private String password;

    @Expose
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

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
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
