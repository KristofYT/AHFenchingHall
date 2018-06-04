package com.aihui.fenchinghall.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @RequestMapping(value = "/*",method = RequestMethod.GET)
    public ModelAndView error(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView tohome(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public ModelAndView about(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }

    @RequestMapping(value = "/culture",method = RequestMethod.GET)
    public ModelAndView culture(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("culture");
        return modelAndView;
    }

    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public ModelAndView manage(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("manage");
        return modelAndView;
    }

    @RequestMapping(value = "/coach",method = RequestMethod.GET)
    public ModelAndView coach(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("coach");
        return modelAndView;
    }

    @RequestMapping(value = "/fencingworld",method = RequestMethod.GET)
    public ModelAndView fencingworld(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("fencingworld");
        return modelAndView;
    }


    @RequestMapping(value = "/advantage",method = RequestMethod.GET)
    public ModelAndView advantage(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("advantage");
        return modelAndView;
    }

    @RequestMapping(value = "/introduction",method = RequestMethod.GET)
    public ModelAndView introduction(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("introduction");
        return modelAndView;
    }

    @RequestMapping(value = "/rule",method = RequestMethod.GET)
    public ModelAndView rule(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("rule");
        return modelAndView;
    }

    @RequestMapping(value = "/fencing",method = RequestMethod.GET)
    public ModelAndView fencing(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("fencing");
        return modelAndView;
    }

    @RequestMapping(value = "/power",method = RequestMethod.GET)
    public ModelAndView power(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("power");
        return modelAndView;
    }

    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public ModelAndView course(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("course");
        return modelAndView;
    }

    @RequestMapping(value = "/course_s",method = RequestMethod.GET)
    public ModelAndView course_s(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("course_s");
        return modelAndView;
    }
    @RequestMapping(value = "/course_itr",method = RequestMethod.GET)
    public ModelAndView course_itr(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("course_itr");
        return modelAndView;
    }

    @RequestMapping(value = "/member",method = RequestMethod.GET)
    public ModelAndView member(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("member");
        return modelAndView;
    }

    @RequestMapping(value = "/member_time",method = RequestMethod.GET)
    public ModelAndView member_time(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("member_time");
        return modelAndView;
    }




    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }




}
