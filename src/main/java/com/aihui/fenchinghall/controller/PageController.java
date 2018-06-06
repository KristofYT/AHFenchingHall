package com.aihui.fenchinghall.controller;


import com.aihui.fenchinghall.model.Schedule;
import com.aihui.fenchinghall.model.User;
import com.aihui.fenchinghall.service.RoleService;
import com.aihui.fenchinghall.service.ScheduleService;
import com.aihui.fenchinghall.service.UserService;
import com.aihui.fenchinghall.util.ConvertDateTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

import static com.aihui.fenchinghall.util.ScheduleUtil.getTodayIsWeekInYesr;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/*",method = RequestMethod.GET)
    public ModelAndView error(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView tohome(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @Autowired
    public RoleService roleService;


    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.findUserByEmail(email);
        if( currentUser == null ){
            modelAndView.setViewName("home");
            return modelAndView;
        }
        if(currentUser.role.id==2){
            String  week = getTodayIsWeekInYesr();
            LocalDate localDate = LocalDate.now();
            String yesr = String.valueOf(localDate.getYear());
            ConvertDateTest cd = new ConvertDateTest();
            String  time =cd.getStartDayOfWeekNo(Integer.parseInt(yesr), Integer.parseInt(week));
            System.out.println( " week = " + week +" yesr = " + yesr +" time = " + time);
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
                System.out.println( "null  week = " + week+ "  e = " + e.toString() );
            }
            Schedule schedule = new Schedule();
            schedules = scheduleService.findScheduleByUserId(String.valueOf(currentUser.id));
            for (Schedule  s:schedules
                 ) {
                if( s.user.id == currentUser.id && s.week == Integer.valueOf(week)){
                    schedule = s;
                }
            }
            users =  userService.findAllUsers();
            modelAndView.addObject("users", users);
            modelAndView.addObject("schedule", schedule);
            modelAndView.setViewName("bgcoacheditschedule");
        }else if(currentUser.role.id==1){
            modelAndView.setViewName("bghome");
        }else if(currentUser.role.id==3){
            modelAndView.setViewName("home");
        }else{
            modelAndView.setViewName("home");
        }
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

    @RequestMapping(value = "/uploadtime",method = RequestMethod.GET)
    public ModelAndView uploadtime(HttpSession httpSession){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("uploadtime");
        return modelAndView;
    }


}
