package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.User;
import com.aihui.fenchinghall.repository.UserRepository;
import com.aihui.fenchinghall.util.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.removeById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public String validate(String username, String password) {
        User user = findUserByEmail(username);
        if( user != null){
            if( password.equals(user.getPassword())){
                return GsonHelper.modelToJson(user);
            }
        }
        return "0";
    }

    @Override
    public List<User> findUserByRoleId(int id) {
        return userRepository.findUserByRoleId(id);
    }
}
