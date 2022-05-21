package com.at.internship.schedule.controller;

import com.at.internship.schedule.converter.ContactConverter;
import com.at.internship.schedule.dto.ContactDto;
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
    public List<ContactDto> findAll(){
        return contactService.findAll().stream().map(contactConverter::toContactDto).collect(Collectors.toList());
    }

    @PostMapping("/new")
    public ContactDto create(@RequestBody @Valid ContactDto contact){
        return contactConverter.toContactDto(contactService.create(contactConverter.toContact(contact)));
    }

    @PutMapping("/update")
    public ContactDto update(@RequestBody ContactDto contact){
        return contactConverter.toContactDto(contactService.update(contactConverter.toContact(contact)));
    }

    @GetMapping("/find/{id}")
    public ContactDto findById(@PathVariable("id") Integer id){
        return contactConverter.toContactDto(Objects.requireNonNull(contactService.findById(id).orElse(null)));
    }

    /*
    @GetMapping("/find/{id}")
    public Optional<Contact> findById(@PathVariable("id") Integer id){
        return contactService.findById(id);
    }

     */

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") Integer id){
        contactService.delete(id);
    }
}
