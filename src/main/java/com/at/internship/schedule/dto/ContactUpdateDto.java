package com.at.internship.schedule.dto;

import com.at.internship.schedule.constants.StringConstantsValidation;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class ContactUpdateDto {
    @NotNull(message = StringConstantsValidation.VALIDATION_ID)
    private Integer id;

    @Size(min = 2, message = StringConstantsValidation.VALIDATION_LENGTH_FIRST_NAME)
    @NotNull(message = StringConstantsValidation.VALIDATION_FIRST_NAME_NULL)
    @NotEmpty(message = StringConstantsValidation.VALIDATION_FIRST_NAME_EMPTY)
    private String firstName;

    @NotNull(message = StringConstantsValidation.VALIDATION_LAST_NAME_NULL)
    @NotEmpty(message = StringConstantsValidation.VALIDATION_LAST_NAME_EMPTY)
    private String lastName;

    @Email(message = StringConstantsValidation.VALIDATION_EMAIL)
    private String emailAddress;

    @NotNull(message = StringConstantsValidation.VALIDATION_BIRTHDAY_NULL)
    @NotEmpty(message = StringConstantsValidation.VALIDATION_BIRTHDAY_EMPTY)
    private String birthDay;
}
