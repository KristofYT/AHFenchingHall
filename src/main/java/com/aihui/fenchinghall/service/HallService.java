package com.aihui.fenchinghall.service;


import com.aihui.fenchinghall.model.Hall;

import java.util.List;

public interface HallService {

    public Hall findHallById(String id);

    public List<Hall> findAllHalls();

}
