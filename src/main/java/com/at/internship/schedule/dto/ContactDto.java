package com.at.internship.schedule.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class ContactDto {
    private Integer id;
    @NotNull(message = "First name is required")
    //@Min(value =2,message = "First name should  be at least two characters length")
    private String firstName;
    private String lastName;
    @Email(message = "Invalid email address")
    private String emailAddress;
    @Min(value = 10, message = "Phone number contain 10 charactedr")
    //@Max(value = 10, message = "Phone number contain 10 character")
    @Digits(integer = 10,fraction = 0, message = "Phone number contains only digits")
    private String phoneNumber;
    private String birthDay;
}
