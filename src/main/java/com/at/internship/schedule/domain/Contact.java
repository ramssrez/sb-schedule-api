package com.at.internship.schedule.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Contact {
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private LocalDate birthDay;

    public Contact(Contact source) {
        if(source == null)
            return;
        this.id = source.id;
        this.firstName = source.firstName;
        this.lastName = source.lastName;
        this.emailAddress = source.emailAddress;
        this.phoneNumber = source.phoneNumber;
        this.birthDay = source.birthDay;
    }

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
