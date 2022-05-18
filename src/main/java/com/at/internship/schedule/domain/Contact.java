package com.at.internship.schedule.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "contact")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 100)
    private String emailAddress;

    @Column(name = "birth_day", nullable = false)
    private LocalDate birthDay;

    @ManyToMany
    /*
    @JoinTable(
            name = "appointment-assistant",
            joinColumns = @JoinColumn(name = "contact_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id",referencedColumnName = "id")
    )
     */
    private List<Appointment> appointments;


    // Lazy load contactPhones
    //private List<ContactPhone> contactPhones;
    // Lazy load appointments

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return String.format("%s %s (%s)", firstName, lastName, id);
    }

}
