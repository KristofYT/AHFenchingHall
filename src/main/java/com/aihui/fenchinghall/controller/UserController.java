package com.aihui.fenchinghall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @RequestMapping(value = "/template",method = RequestMethod.GET)
    public ModelAndView template(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("template");
        return modelAndView;
    }

    @RequestMapping(value = "/templatebg",method = RequestMethod.GET)
    public ModelAndView templatebg(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("templatebg");
        return modelAndView;
    }

}
