package com.at.internship.schedule.service.impl;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.service.IAppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImp implements IAppointmentService {
    private final IAppointmentRepository appointmentRepository;

    public AppointmentServiceImp(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
