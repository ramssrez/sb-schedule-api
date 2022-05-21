package com.at.internship.schedule.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class ContactDto {
    private Integer id;
    @NotNull(message = "First name is required")
    private String firstName;
    private String lastName;
    @Email(message = "Invalid email address")
    private String emailAddress;
    private String birthDay;
}
