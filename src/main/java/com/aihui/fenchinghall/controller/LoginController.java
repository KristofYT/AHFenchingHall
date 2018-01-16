package com.aihui.fenchinghall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {



    @RequestMapping(value = "/*",method = RequestMethod.GET)
    public ModelAndView home(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

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

}
