package com.aihui.fenchinghall.controller;

import com.aihui.fenchinghall.model.*;
import com.aihui.fenchinghall.repository.RoleRepository;
import com.aihui.fenchinghall.service.RoleService;
import com.aihui.fenchinghall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public RoleService roleService;

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/bguser",method = RequestMethod.GET)
    public ModelAndView bgappointment(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        List<User> users =  userService.findAllUsers();
        List<Role> roles =  roleService.findAllRoles();
        modelAndView.addObject("users", users);
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("bguser");
        return modelAndView;
    }

    @PostMapping(value = "/register")// save appointment
    public ModelAndView postRegister(@RequestParam String email, @RequestParam String password,@RequestParam String name, @RequestParam String phone ) {
        ModelAndView modelAndView= new ModelAndView();
        System.out.println( " register  email = " + email
                + " ,password= " + password
                + " ,name = " + name
                + " ,phone= " + phone);
        if( email == null && password ==null ){
            modelAndView.setViewName("home");
            return modelAndView;
        }
        User user = new User();
        user.email = email;
        user.password = password;
        user.name = name;
        user.phone = phone;
        user.active = 1;
        user.role = roleService.findRoleById(String.valueOf(3));
        userService.saveUser(user);

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/bgnewuser", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAllRoles();
        modelAndView.addObject("roles", roles);
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("bgnewuser");
        return modelAndView;
    }

    @RequestMapping(value = "/bgnewuser", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAllRoles();
        modelAndView.addObject("roles", roles);

        User userExists = userService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user", "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("bgnewuser");
        } else {

            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            List<User> userList = userService.findAllUsers();
            modelAndView.addObject("users", userList);
            modelAndView.setViewName("bguser");

        }
        return modelAndView;
    }


    @RequestMapping(value = "/bgedituser", method = RequestMethod.GET)
    public ModelAndView editUser(WebRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAllRoles();
        modelAndView.addObject("roles", roles);
        String email = request.getParameter("email");
        User user = userService.findUserByEmail(email);
//        String id = request.getParameter("id");
//        User user = userService.findUserByEmail(email)
        modelAndView.addObject("user", user);
        modelAndView.setViewName("bgedituser");
        return modelAndView;
    }

    @RequestMapping(value = "/bgedituser", method = RequestMethod.POST)
    public ModelAndView editUserSubmit(@Valid User user, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAllRoles();
        modelAndView.addObject("roles", roles);

//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("bgedituser");
//        } else {
//
//
//
//        }
        userService.updateUser(user);
        modelAndView.addObject("successMessage", "User has been updated successfully");
        List<User> userList = userService.findAllUsers();
        modelAndView.addObject("users", userList);
        modelAndView.setViewName("bguser");
        return modelAndView;
    }

    @RequestMapping(value = "/bgdeleteuser", method = {RequestMethod.GET})
    public ModelAndView deleteUser(WebRequest request) {
        String id = request.getParameter("id");
        userService.deleteUserById(Integer.parseInt(id));

        ModelAndView modelAndView = new ModelAndView();
        List<User> users =  userService.findAllUsers();
        List<Role> roles =  roleService.findAllRoles();
        modelAndView.addObject("users", users);
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("bguser");
        return modelAndView;
    }

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
