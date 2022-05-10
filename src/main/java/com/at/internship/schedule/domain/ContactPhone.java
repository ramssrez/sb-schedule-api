package com.at.internship.schedule.domain;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class ContactPhone {
    @EmbeddedId
    private ContactPhonePk id;
    private Boolean primaryFlag;
}
