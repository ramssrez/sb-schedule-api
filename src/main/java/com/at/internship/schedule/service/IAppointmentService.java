package com.at.internship.schedule.service;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.domain.Contact;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {
    List<Appointment> findAll();
    Appointment create(Appointment appointment);
    Appointment update(Appointment appointment);
    Optional<Appointment> findById(Integer id);
    void delete(Integer id);
}
