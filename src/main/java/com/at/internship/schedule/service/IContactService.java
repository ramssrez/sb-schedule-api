package com.at.internship.schedule.service;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.dto.ContactFiltersDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    Page<Contact> findAllFilter(ContactFiltersDto filtersDto, Pageable pageable);
    List<Contact> findAll();
    Contact create(Contact contact);
    Contact update(Contact contact);
    Optional<Contact> findById(Integer id);
    void delete(Integer id);
}
