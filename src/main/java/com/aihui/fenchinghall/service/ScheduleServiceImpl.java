package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.Schedule;
import com.aihui.fenchinghall.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findSchedule() {
        return null;
    }

    @Override
    public Schedule findScheduleById(String id) {
        return scheduleRepository.findOne(Integer.valueOf(id));
    }

    @Override
    public List<Schedule> findScheduleByUserId(String id) {
        return scheduleRepository.findScheduleByUserId(Integer.parseInt(id));
    }

    @Override
    public void deleteScheduleById(String id) {
        scheduleRepository.delete(Integer.valueOf(id));
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> findScheduleByWeek(int week) {
        return scheduleRepository.findScheduleByWeek(week);
    }

    @Override
    public List<Schedule> findByWeek(int week) {
        return scheduleRepository.findByWeek(week);
    }
}
