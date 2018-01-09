package com.aihui.fenchinghall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/tset")
    public String test(){
        return "hello fenchinghall";
    }
}
