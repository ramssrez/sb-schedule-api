package com.at.internship.schedule.controller;

import com.at.internship.schedule.constants.StringConstants;
import com.at.internship.schedule.constants.StringConstantsErrors;
import com.at.internship.schedule.converter.ContactConverter;
import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.dto.ContactCreateDto;
import com.at.internship.schedule.dto.ContactDetailsDto;
import com.at.internship.schedule.dto.ContactUpdateDto;
import com.at.internship.schedule.response.ErrorResponse;
import com.at.internship.schedule.response.GenericResponse;
import com.at.internship.schedule.service.IContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final IContactService contactService;
    private final ContactConverter contactConverter;

    public ContactController(IContactService contactService, ContactConverter contactConverter) {
        this.contactService = contactService;
        this.contactConverter = contactConverter;
    }

    @GetMapping("/all")
    public ResponseEntity findAll(){
        List<ContactDetailsDto> contactDtos= contactService.findAll().stream().map(contactConverter::contactToContactDto).collect(Collectors.toList());
        GenericResponse<List<ContactDetailsDto>> response = new GenericResponse<>();
        ResponseEntity responseEntity = null;
        if (contactDtos.isEmpty()) {
            ErrorResponse<List<ContactDetailsDto>> responseError = new ErrorResponse<>();
            responseError.setCode(StringConstantsErrors.RECORD_NOT_FOUND_CODE);
            responseError.setMessage(StringConstantsErrors.RECORD_NOT_FOUND_MESSAGE);
            responseError.setErrorMessages(Collections.singletonList(StringConstantsErrors.RECORD_NOT_FOUND_EMPTY));
            responseEntity = new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);
        }else{
            response.setCode(StringConstants.FORMAT_RESPONSE_CODE);
            response.setMessage(StringConstants.FORMAT_RESPONSE_MESSAGE);
            responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
            response.setContent(contactDtos);
        }
        return responseEntity;
    }

    @PostMapping("/new")
    public GenericResponse<ContactDetailsDto> createContact(@RequestBody @Valid ContactCreateDto contactCreateDto){
        GenericResponse<ContactDetailsDto> response = new GenericResponse<>();
        Contact contact = contactService.create(contactConverter.createDtoToContact(contactCreateDto));
        ContactDetailsDto dto = contactConverter.contactToContactDto(contact);
        response.setContent(dto);
        response.setCode(StringConstants.FORMAT_RESPONSE_CODE);
        response.setMessage(StringConstants.FORMAT_RESPONSE_MESSAGE);
        return response;
    }

    @PutMapping("/update")
    public GenericResponse<ContactDetailsDto> update(@RequestBody  @Valid ContactUpdateDto contactUpdateDto){
        contactConverter.contactToContactDto(Objects.requireNonNull(contactService.findById(contactUpdateDto.getId()).orElse(null)));
        GenericResponse<ContactDetailsDto> response = new GenericResponse<>();
        Contact contact = contactService.update(contactConverter.updateDtoToContact(contactUpdateDto));
        ContactDetailsDto dto = contactConverter.contactToContactDto(contact);
        response.setContent(dto);
        response.setCode(StringConstants.FORMAT_RESPONSE_CODE);
        response.setMessage(StringConstants.FORMAT_RESPONSE_MESSAGE);
        return response;
    }

    @GetMapping("/findById/{id}")
    public GenericResponse<ContactDetailsDto> findById(@PathVariable("id") Integer id){
        GenericResponse<ContactDetailsDto> response = new GenericResponse<>();
        Contact contact = Objects.requireNonNull(contactService.findById(id).orElse(null));
        ContactDetailsDto dto = contactConverter.contactToContactDto(contact);
        response.setContent(dto);
        response.setCode(StringConstants.FORMAT_RESPONSE_CODE);
        response.setMessage(StringConstants.FORMAT_RESPONSE_MESSAGE);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<ContactDetailsDto> delete (@PathVariable("id") Integer id){
        GenericResponse<ContactDetailsDto> response = new GenericResponse<>();
        Contact contact = Objects.requireNonNull(contactService.findById(id).orElse(null));
        ContactDetailsDto dto = contactConverter.contactToContactDto(contact);
        response.setContent(dto);
        response.setCode(StringConstants.FORMAT_RESPONSE_CODE);
        response.setMessage(StringConstants.FORMAT_RESPONSE_DELETE);
        contactService.delete(id);
        return response;
    }
}
