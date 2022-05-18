package com.at.internship.schedule.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact_phone")
public class ContactPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @Column(name = "label", nullable = false, length = 100)
    private String label;
}
