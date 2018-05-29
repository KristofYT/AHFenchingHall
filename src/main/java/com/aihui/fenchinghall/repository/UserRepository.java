package com.aihui.fenchinghall.repository;

import com.aihui.fenchinghall.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    @Transactional
    List<User> removeById(int id);


}
