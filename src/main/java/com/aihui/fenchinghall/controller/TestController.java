package com.aihui.fenchinghall.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @RequestMapping(value = "/baidumap",method = RequestMethod.GET)
    public ModelAndView baidumap(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("baidumap");
        return modelAndView;
    }

    @RequestMapping(value = "/bstrap",method = RequestMethod.GET)
    public ModelAndView baidumbstrapap(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("bstrap");
        return modelAndView;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
