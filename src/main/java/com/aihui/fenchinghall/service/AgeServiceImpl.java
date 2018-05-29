package com.aihui.fenchinghall.service;


import com.aihui.fenchinghall.model.Age;
import com.aihui.fenchinghall.repository.AgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ageService")
public class AgeServiceImpl implements AgeService {


    @Autowired
    private AgeRepository ageRepository;

    @Override
    public Age findAgeById(String id) {
        return ageRepository.findOne(Integer.valueOf(id));
    }

    @Override
    public List<Age> findAllAges() {
        return ageRepository.findAll();
    }
}
