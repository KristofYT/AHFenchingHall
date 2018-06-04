package com.aihui.fenchinghall.controller;


import com.aihui.fenchinghall.model.*;
import com.aihui.fenchinghall.service.RoleService;
import com.aihui.fenchinghall.service.ScheduleService;
import com.aihui.fenchinghall.service.UserService;
import com.aihui.fenchinghall.util.ConvertDateTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import static com.aihui.fenchinghall.util.ScheduleUtil.getTodayIsWeekInYesr;

@RestController
public class ScheduleController {


    @Autowired
    public RoleService roleService;

    @Autowired
    public UserService userService;

    @Autowired
    private ScheduleService scheduleService;


    @RequestMapping(value = "/bgschedule",method = RequestMethod.GET)
    public ModelAndView bgSchedule(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();

        String  week = getTodayIsWeekInYesr();
        LocalDate localDate = LocalDate.now();
        String yesr = String.valueOf(localDate.getYear());
        ConvertDateTest cd = new ConvertDateTest();
        String  time =cd.getStartDayOfWeekNo(Integer.parseInt(yesr), Integer.parseInt(week));
        System.out.println(
                " week = " + week +
                        " yesr = " + yesr +
                        " time = " + time
        );
        List<Schedule> schedules = null;
        List<User> users = null;
        try {
            schedules = scheduleService.findByWeek(Integer.parseInt(week));
            System.out.println(schedules.size() + " schedules  size");
            if(schedules.size() == 0){
                users = userService.findUserByRoleId(2);
                System.out.println(users.size() + " users  size");
                Schedule schedule;
                for (User user:users ) {
                    schedule = new Schedule();
                    schedule.week = Integer.parseInt(week);
                    schedule.time = time;
                    schedule.year = yesr;
                    schedule.user = user;
                    scheduleService.saveSchedule(schedule);
                }
            }
        }catch ( Exception e){
            System.out.println(
                    "null  week = " + week
                    + "  e = " + e.toString()
            );
        }


//        List<Schedule> schedules =  scheduleService.findAllSchedules();
//        List<User> users =  userService.findAllUsers();
        schedules =  scheduleService.findAllSchedules();
        users =  userService.findAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("schedules", schedules);
        modelAndView.setViewName("bgschedule");
        return modelAndView;
    }

    @RequestMapping(value = "/bgeditschedule", method = RequestMethod.GET)
    public ModelAndView editSchedule(WebRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String id = request.getParameter("id");
        Schedule schedule = scheduleService.findScheduleById(id);
        List<User> users =  userService.findAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("schedule", schedule);
        modelAndView.setViewName("bgeditschedule");
        return modelAndView;
    }

    @PostMapping(value = "/bgeditschedule")
    public ModelAndView postEditSchedule(@Valid Schedule schedule, BindingResult bindingResult) {
        System.out.println(" editAppointment POST ");
        ModelAndView modelAndView = new ModelAndView();
        List<User> users =  userService.findAllUsers();
        modelAndView.addObject("users", users);

//        appointment = appointmentService.findAppointmentById(String.valueOf(appointment.id));
        scheduleService.updateSchedule(schedule);
        modelAndView.addObject("successMessage", "schedule has been updated successfully");
        List<Schedule> schedules =  scheduleService.findAllSchedules();
        modelAndView.addObject("schedules", schedules);
        modelAndView.setViewName("bgschedule");
        return modelAndView;
    }



}
