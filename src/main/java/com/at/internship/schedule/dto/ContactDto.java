package com.at.internship.schedule.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ContactDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String birthDay;
}
