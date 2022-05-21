package com.at.internship.schedule.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "contact_phone")
public class ContactPhone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contact_id", nullable = false)
    private Integer id_contact;

    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @Column(name = "label", nullable = false, length = 100)
    private String label;

    @ManyToOne
    @JoinColumn(name = "contact_id",insertable = false, updatable = false)
    private Contact contact;

}
