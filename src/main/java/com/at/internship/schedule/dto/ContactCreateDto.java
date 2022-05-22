package com.at.internship.schedule.dto;

import com.at.internship.schedule.constants.StringConstantsValidation;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ContactCreateDto {

    @Size(min = 2, message = StringConstantsValidation.VALIDATION_LENGTH_FIRST_NAME)
    @NotNull(message = StringConstantsValidation.VALIDATION_FIRST_NAME_NULL)
    @NotEmpty(message = StringConstantsValidation.VALIDATION_FIRST_NAME_EMPTY)
    private String firstName;

    @NotNull(message = StringConstantsValidation.VALIDATION_LAST_NAME_NULL)
    @NotEmpty(message = StringConstantsValidation.VALIDATION_LAST_NAME_EMPTY)
    private String lastName;

    @Email(message = StringConstantsValidation.VALIDATION_EMAIL)
    private String emailAddress;

    private String birthDay;
}
