package com.aihui.fenchinghall.util;

import com.aihui.fenchinghall.model.Schedule;
import com.aihui.fenchinghall.model.User;
import com.aihui.fenchinghall.service.ScheduleService;
import com.aihui.fenchinghall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public  class ScheduleUtil {

    @Autowired
    private static ScheduleService scheduleService;

    @Autowired
    private static UserService userService;

    public static void main(String args[]) throws Exception {
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
            users = userService.findUserByRoleId(2);
        }catch ( Exception e){
            System.out.println(
                    "null  week = " + week
            );
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
        System.out.println("schedules != null  week = " + week);



    }

    @Scheduled(cron = "${scheduler.generate.cron}")
    public void initSchedule() throws Exception{
        String  week = getTodayIsWeekInYesr();
        System.out.println("initSchedule  week = " + week);
        LocalDate localDate = LocalDate.now();
        String yesr = String.valueOf(localDate.getYear());
        ConvertDateTest cd = new ConvertDateTest();
        String  time =cd.getStartDayOfWeekNo(Integer.parseInt(yesr), Integer.parseInt(week));


        List<Schedule> schedules = scheduleService.findScheduleByWeek(Integer.parseInt(week));
        if ( schedules == null){
            List<User> users = userService.findUserByRoleId(2);
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


    }

    public static String getTodayIsWeekInYesr(){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(new Date());
        String week = String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));
        return week;
    }
    public static String getTodayIsDyaInYesr(){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(new Date());
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_YEAR));
        return day;
    }

}
