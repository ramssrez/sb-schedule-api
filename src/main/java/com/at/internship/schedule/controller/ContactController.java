package com.at.internship.schedule.controller;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.service.IContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public List<Contact> findAll(){
        return contactService.findAll();
    }

    @PostMapping("/new")
    public Contact create(@RequestBody Contact contact){
        return contactService.create(contact);
    }
}
