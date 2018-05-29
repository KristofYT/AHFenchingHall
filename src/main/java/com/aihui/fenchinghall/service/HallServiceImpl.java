package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.Hall;
import com.aihui.fenchinghall.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hallService")
public class HallServiceImpl implements HallService {


    @Autowired
    private HallRepository hallRepository;

    @Override
    public Hall findHallById(String id) {
        return hallRepository.findOne(Integer.valueOf(id));
    }

    @Override
    public List<Hall> findAllHalls() {
        return hallRepository.findAll();
    }
}
