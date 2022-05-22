package com.at.internship.schedule.controller;

import com.at.internship.schedule.constants.StringConstants;
import com.at.internship.schedule.converter.ContactConverter;
import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.dto.ContactCreateDto;
import com.at.internship.schedule.dto.ContactDetailsDto;
import com.at.internship.schedule.dto.ContactUpdateDto;
import com.at.internship.schedule.response.GenericResponse;
import com.at.internship.schedule.service.IContactService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public GenericResponse<List<ContactDetailsDto>> findAll(){
        List<ContactDetailsDto> contactDtos= contactService.findAll().stream().map(contactConverter::contactToContactDto).collect(Collectors.toList());
        GenericResponse<List<ContactDetailsDto>> response = new GenericResponse<>();
        if (contactDtos.isEmpty()) {
            response.setCode("NOT_FOUND");
            response.setMessage("N0 information in the DB");
        }else{
            response.setCode("OK");
            response.setMessage("Success!");
        }
        response.setContent( contactService.findAll().stream().map(contactConverter::contactToContactDto).collect(Collectors.toList()));
        return response;
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
        GenericResponse<ContactDetailsDto> response = new GenericResponse<>();
        Contact contact = contactService.update(contactConverter.updateDtoToContact(contactUpdateDto));
        ContactDetailsDto dto = contactConverter.contactToContactDto(contact);
        response.setContent(dto);
        response.setCode(StringConstants.FORMAT_RESPONSE_CODE);
        response.setMessage(StringConstants.FORMAT_RESPONSE_MESSAGE);
        return response;
    }

    @GetMapping("/find/{id}")
    public ContactDetailsDto findById(@PathVariable("id") Integer id){
        return contactConverter.contactToContactDto(Objects.requireNonNull(contactService.findById(id).orElse(null)));
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") Integer id){
        contactService.delete(id);
    }
}
