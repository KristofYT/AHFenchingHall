package com.aihui.fenchinghall.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class BgController {



    @RequestMapping(value = "/bghome",method = RequestMethod.GET)
    public ModelAndView about(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("bghome");
        return modelAndView;
    }


}
