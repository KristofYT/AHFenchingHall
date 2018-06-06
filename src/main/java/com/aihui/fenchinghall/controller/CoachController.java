package com.aihui.fenchinghall.controller;


import com.aihui.fenchinghall.model.Coach;
import com.aihui.fenchinghall.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class CoachController {
    @Autowired
    private CoachService coachService;

//    @RequestMapping(value="/coach",method =RequestMethod.GET)
//    public ModelAndView coach(HttpSession httpSession){
//    ModelAndView modelAndView=new ModelAndView();
//        Coach coach=coachService.findCoachById(int id);
//
//    }

}
