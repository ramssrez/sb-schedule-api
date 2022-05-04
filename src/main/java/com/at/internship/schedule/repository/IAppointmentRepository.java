package com.at.internship.schedule.repository;

import com.at.internship.schedule.domain.Appointment;

import java.util.List;

public interface IAppointmentRepository {
    List<Appointment> findAll();
}
