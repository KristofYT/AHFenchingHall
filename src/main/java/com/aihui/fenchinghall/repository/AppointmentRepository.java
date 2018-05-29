package com.aihui.fenchinghall.repository;

import com.aihui.fenchinghall.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {



}
