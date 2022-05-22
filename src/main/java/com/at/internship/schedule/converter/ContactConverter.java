package com.at.internship.schedule.converter;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.dto.ContactDetailsDto;
import com.at.internship.schedule.dto.ContactCreateDto;
import com.at.internship.schedule.dto.ContactUpdateDto;
import com.at.internship.schedule.utils.DateUtils;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter {
    private final DateUtils dateUtils;

    public ContactConverter(DateUtils dateUtils) {
        this.dateUtils = dateUtils;
    }

    public ContactDetailsDto contactToContactDto(Contact contact) {
        ContactDetailsDto contactDto = new ContactDetailsDto();
        contactDto.setId(contact.getId());
        contactDto.setFirstName(contact.getFirstName());
        contactDto.setLastName(contact.getLastName());
        contactDto.setEmailAddress(contact.getEmailAddress());
        contactDto.setBirthDay(dateUtils.formatDefault(contact.getBirthDay()));
        return contactDto;
    }
    public Contact contactDtoToContact(ContactDetailsDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setEmailAddress(contactDto.getEmailAddress());
        contact.setBirthDay(dateUtils.parseDefaultDate(contactDto.getBirthDay()));
        return contact;
    }
    public ContactCreateDto contactToCreateDto(Contact contact){
        ContactCreateDto createDto = new ContactCreateDto();
        createDto.setFirstName(contact.getFirstName());
        createDto.setLastName(contact.getLastName());
        createDto.setEmailAddress(contact.getEmailAddress());
        createDto.setBirthDay(dateUtils.formatDefault(contact.getBirthDay()));
        return createDto;
    }
    public Contact createDtoToContact(ContactCreateDto createDto){
        Contact contact = new Contact();
        contact.setFirstName(createDto.getFirstName());
        contact.setLastName(createDto.getLastName());
        contact.setEmailAddress(createDto.getEmailAddress());
        contact.setBirthDay(dateUtils.parseDefaultDate(createDto.getBirthDay()));
        return contact;
    }
    public Contact updateDtoToContact(ContactUpdateDto updateDto){
        Contact contact = new Contact();
        contact.setId(updateDto.getId());
        contact.setFirstName(updateDto.getFirstName());
        contact.setLastName(updateDto.getLastName());
        contact.setEmailAddress(updateDto.getEmailAddress());
        contact.setBirthDay(dateUtils.parseDefaultDate(updateDto.getBirthDay()));
        return contact;
    }

}
