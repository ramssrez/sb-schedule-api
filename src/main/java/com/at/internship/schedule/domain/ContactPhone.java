package com.at.internship.schedule.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact_phone")
public class ContactPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "label")
    private String label;
}
