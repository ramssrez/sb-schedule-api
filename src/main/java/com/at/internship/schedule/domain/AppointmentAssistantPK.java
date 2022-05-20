package com.at.internship.schedule.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AppointmentAssistantPK implements Serializable {
    @Column(name = "appointment_id", nullable = false)
    private Integer appointmentId;

    @Column(name = "contact_id", nullable = false)
    private Integer contactId;
}
