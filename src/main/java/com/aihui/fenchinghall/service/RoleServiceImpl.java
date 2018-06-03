package com.aihui.fenchinghall.service;


import com.aihui.fenchinghall.model.Role;
import com.aihui.fenchinghall.repository.AgeRepository;
import com.aihui.fenchinghall.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleById(String id) {
        return roleRepository.findOne(Integer.valueOf(id));
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
