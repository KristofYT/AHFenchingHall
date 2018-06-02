package com.aihui.fenchinghall.service;


import com.aihui.fenchinghall.model.Appointment;
import com.aihui.fenchinghall.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment findAppointmentById(String id) {
        return appointmentRepository.findOne(Integer.valueOf(id));
    }

    @Override
    public void deleteAppointmentById(String id) {
        appointmentRepository.delete(Integer.valueOf(id));
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }


}
