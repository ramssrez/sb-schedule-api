package com.at.internship.schedule.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "appointment_assistant")
public class AppointmentAssistant implements Serializable {

    @EmbeddedId
    private  AppointmentAssistantPK appointmentAssistantPK;

    @Column(name = "type", nullable = false,  length = 30)
    private String type;

    @ManyToOne
    @JoinColumn(name = "contact_id", insertable = false, updatable = false)
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = " appointment_id", insertable = false, updatable = false)
    private Appointment appointment;


}
