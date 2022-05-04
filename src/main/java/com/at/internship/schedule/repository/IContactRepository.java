package com.at.internship.schedule.repository;

import com.at.internship.schedule.domain.Contact;

import java.util.List;

public interface IContactRepository {
    List<Contact> findAll();
}
