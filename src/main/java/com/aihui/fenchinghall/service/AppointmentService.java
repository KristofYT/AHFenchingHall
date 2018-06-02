package com.aihui.fenchinghall.service;


import com.aihui.fenchinghall.model.Appointment;

import java.util.List;

public interface AppointmentService {


    public Appointment findAppointmentById(String id);


    public void deleteAppointmentById(String id);

    public void updateAppointment(Appointment appointment);

    public void saveAppointment(Appointment appointment);

    public List<Appointment> findAllAppointments();



}
