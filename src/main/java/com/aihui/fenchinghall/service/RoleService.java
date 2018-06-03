package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.Role;

import java.util.List;

public interface RoleService {

    public Role findRoleById(String id);

    public List<Role> findAllRoles();

}
