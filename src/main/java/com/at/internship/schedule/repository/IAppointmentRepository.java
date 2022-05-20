package com.at.internship.schedule.repository;

import com.at.internship.schedule.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
}
