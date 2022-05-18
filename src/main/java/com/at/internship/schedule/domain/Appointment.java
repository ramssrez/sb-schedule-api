package com.at.internship.schedule.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "appointment")
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

    @ManyToMany
    /*
    @JoinTable(
            name = "appointment-assistant",
            joinColumns = @JoinColumn(name = "appointment_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id",referencedColumnName = "id")
    )

     */
    private List<Contact> contacts;

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
