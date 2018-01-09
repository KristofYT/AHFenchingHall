package com.aihui.fenchinghall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView home(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
