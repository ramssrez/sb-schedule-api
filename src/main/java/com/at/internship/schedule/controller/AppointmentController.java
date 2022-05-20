package com.at.internship.schedule.controller;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.service.IAppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final IAppointmentService iAppointmentService;

    public AppointmentController(IAppointmentService iAppointmentService) {
        this.iAppointmentService = iAppointmentService;
    }

    @GetMapping("/all")
    public List<Appointment> findAll(){
        return iAppointmentService.findAll();
    }

}
