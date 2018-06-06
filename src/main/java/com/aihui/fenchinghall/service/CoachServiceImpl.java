package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.Coach;
import com.aihui.fenchinghall.repository.CoachRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("coachService")
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;


    public Coach findCoachById(int id){
        return coachRepository.findOne(Integer.valueOf(id));}

}
