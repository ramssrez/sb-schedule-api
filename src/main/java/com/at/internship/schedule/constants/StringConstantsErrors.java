package com.at.internship.schedule.constants;

public class StringConstantsErrors {
    public static final String RECORD_NOT_FOUND_CODE = "RECORD_NOT_FOUND";
    public static final String RECORD_NOT_FOUND_MESSAGE = "Record not found";
    public static final String RECORD_NOT_FOUND_ERROR = "Requested with %s was not found";
    public static final String RECORD_NOT_FOUND_GENERAL = "Requested was not found it";
    public static final String RECORD_NOT_FOUND_EMPTY = "Requested was not found it, list empty";


    public static final String VALIDATION_FAILED_CODE = "VALIDATION_FAILED";
    public static final String VALIDATION_FAILED_MESSAGE = "There were validation errors";

    public static final String DB_CONSTRAIN_VIOLATION_CODE = "DB_CONSTRAINT_VIOLATION";
    public static final String DB_CONSTRAIN_VIOLATION_MESSAGE = "Database constraint violation";
    public static final String DB_CONSTRAIN_VIOLATION_ERROR = "Contact cannot be deleted because there are appointments as signed to them";

}
