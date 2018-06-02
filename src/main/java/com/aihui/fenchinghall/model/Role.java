package com.aihui.fenchinghall.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    public int id;

    @Column(name = "role_name")
    public String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    public Set<User> user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
