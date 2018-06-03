package com.aihui.fenchinghall.controller;


import com.aihui.fenchinghall.model.Age;
import com.aihui.fenchinghall.model.Appointment;
import com.aihui.fenchinghall.model.Hall;
import com.aihui.fenchinghall.service.AgeService;
import com.aihui.fenchinghall.service.AppointmentService;
import com.aihui.fenchinghall.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@ResponseBody
@RestController
public class AppointmentController {

    @Autowired
    private HallService hallService;

    @Autowired
    private AgeService ageService;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(value = "/appointment")// save appointment
    public String postAppointment(@RequestParam String name, @RequestParam String phone,@RequestParam String age, @RequestParam String hall) {
        System.out.println( " postAppointment  name = " + name
                + " ,phone= " + phone
                + " ,age= " + age
                + " ,hall= " + hall  );
        if( name == null && phone ==null ){
            return "failed";
        }
        Appointment appointment = new Appointment();
        appointment.setName(name);
        appointment.setPhone(phone);
        appointment.setAge(ageService.findAgeById(age));
        appointment.setHall(hallService.findHallById(hall));
        appointmentService.saveAppointment(appointment);
        return "success";
    }

    @RequestMapping(value = "/bgappointment",method = RequestMethod.GET)
    public ModelAndView bgappointment(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        List<Appointment> allAppointments =  appointmentService.findAllAppointments();
        List<Age> ageList =  ageService.findAllAges();
        List<Hall> hallList =  hallService.findAllHalls();
        modelAndView.addObject("allAppointments", allAppointments);
        modelAndView.addObject("ages", ageList);
        modelAndView.addObject("halls", hallList);
        modelAndView.setViewName("bgappointment");
        return modelAndView;
    }

    @RequestMapping(value = "/bgeditappointment", method = RequestMethod.GET)
    public ModelAndView editAppointment(WebRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String id = request.getParameter("id");
        Appointment appointment = appointmentService.findAppointmentById(id);
        List<Age> ageList =  ageService.findAllAges();
        List<Hall> hallList =  hallService.findAllHalls();
        modelAndView.addObject("ages", ageList);
        modelAndView.addObject("halls", hallList);
        modelAndView.addObject("appointment", appointment);
        modelAndView.setViewName("bgeditappointment");
        return modelAndView;
    }

    @PostMapping(value = "/bgeditappointment")
    public ModelAndView postEditAppointment(@Valid Appointment appointment, BindingResult bindingResult) {
        System.out.println(" editAppointment POST ");
        ModelAndView modelAndView = new ModelAndView();
        List<Age> ageList =  ageService.findAllAges();
        List<Hall> hallList =  hallService.findAllHalls();
        modelAndView.addObject("ages", ageList);
        modelAndView.addObject("halls", hallList);

//        appointment = appointmentService.findAppointmentById(String.valueOf(appointment.id));
        appointmentService.updateAppointment(appointment);
        modelAndView.addObject("successMessage", "User has been updated successfully");
        List<Appointment> allAppointments =  appointmentService.findAllAppointments();
        modelAndView.addObject("allAppointments", allAppointments);
        modelAndView.setViewName("bgappointment");
        return modelAndView;
    }

    @RequestMapping(value = "/bgdeleteAppointment", method = RequestMethod.GET)
    public ModelAndView deleteAppointment(WebRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String id = request.getParameter("id");
        appointmentService.deleteAppointmentById(id);

        List<Appointment> allAppointments =  appointmentService.findAllAppointments();
        List<Age> ageList =  ageService.findAllAges();
        List<Hall> hallList =  hallService.findAllHalls();
        modelAndView.addObject("allAppointments", allAppointments);
        modelAndView.addObject("ages", ageList);
        modelAndView.addObject("halls", hallList);
        modelAndView.setViewName("bgappointment");
        return modelAndView;
    }


}
