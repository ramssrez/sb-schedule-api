package com.at.internship.schedule.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "local_date", nullable = false)
    private LocalDateTime time;

    @Column(name = "subject", nullable = false, length = 500)
    private String subject;

    @ManyToOne
    private Contact contact;

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
//
//    public String toString() {
//        return String.format("%s. %s -- %s : %s", id, time, contact, subject);
//    }

}
