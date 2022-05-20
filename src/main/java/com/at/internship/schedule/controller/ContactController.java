package com.at.internship.schedule.controller;

import com.at.internship.schedule.converter.ContactConverter;
import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.dto.ContactDto;
import com.at.internship.schedule.service.IContactService;
import com.at.internship.schedule.utils.DateUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
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
    public List<ContactDto> findAll(){
        return contactService.findAll().stream().map(contactConverter::toContactDto).collect(Collectors.toList());
    }

    @PostMapping("/new")
    public ContactDto create(@RequestBody ContactDto contact){
        return contactConverter.toContactDto(contactService.create(contactConverter.toContact(contact)));
    }
}
