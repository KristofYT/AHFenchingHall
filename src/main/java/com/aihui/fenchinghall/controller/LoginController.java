package com.aihui.fenchinghall.controller;

import com.aihui.fenchinghall.model.User;
import com.aihui.fenchinghall.service.RoleService;
import com.aihui.fenchinghall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    public RoleService roleService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }

//    @RequestMapping(value = "/bghome", method = RequestMethod.GET)
//    public ModelAndView bghome() {
//        ModelAndView modelAndView = new ModelAndView();
//        User user=new User();
//        String email=user.email;
//        int id=userService.findRoleIdByEmail(email);
//        if(id==3)
//        {
//            modelAndView.setViewName("bghome");
//        }
//        return modelAndView;
//    }

//    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//            .getAuthentication()
//            .getPrincipal();


}
