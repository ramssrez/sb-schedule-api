package com.at.internship.schedule.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Appointment {
    private Integer id;
    private Integer contactId;
    private LocalDateTime time;
    private String subject;
    private Contact contact;

    public Appointment(Appointment source) {
        if(source == null)
            return;
        this.id = source.id;
        this.contactId = source.contactId;
        this.time = source.time;
        this.subject = source.subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return String.format("%s. %s -- %s : %s", id, time, contact, subject);
    }

}
