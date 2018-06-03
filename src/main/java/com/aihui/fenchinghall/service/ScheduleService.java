package com.aihui.fenchinghall.service;


import com.aihui.fenchinghall.model.Schedule;

import java.util.List;

public interface ScheduleService {


    public Schedule findScheduleById(String id);


    public List<Schedule> findScheduleByUserId(String id);


    public void deleteScheduleById(String id);

    public void updateSchedule(Schedule schedule);

    public void saveSchedule(Schedule schedule);

    public List<Schedule> findAllSchedules();

    List<Schedule> findScheduleByWeek(int week);

    List<Schedule> findByWeek(int week);



}
