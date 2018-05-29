package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.Age;

import java.util.List;

public interface AgeService {

    public Age findAgeById(String id);

    public List<Age> findAllAges();

}
