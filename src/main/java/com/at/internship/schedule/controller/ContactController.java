package com.at.internship.schedule.controller;

import com.at.internship.schedule.converter.ContactConverter;
import com.at.internship.schedule.dto.ContactDto;
import com.at.internship.schedule.service.IContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contact")
@SuppressWarnings("unused")
public class ContactController {

    private final IContactService contactService;
    private final ContactConverter contactConverter;

    public ContactController(
            IContactService contactService,
            ContactConverter contactConverter
    ) {
        this.contactService = contactService;
        this.contactConverter = contactConverter;
    }

    @GetMapping("/all")
    public List<ContactDto> findAll() {
        return contactService.findAll().stream().map(contactConverter::toContactDto).collect(Collectors.toList());
    }

}
