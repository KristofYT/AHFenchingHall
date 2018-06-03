package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.User;

import java.util.List;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);

    public List<User> findAllUsers();

    public void deleteUserById(int id);

    public String validate(String username, String password);

    void updateUser(User user);

    List<User> findUserByRoleId(int id);
}
