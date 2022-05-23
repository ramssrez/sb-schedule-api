package com.at.internship.schedule.service.impl;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.dto.ContactFiltersDto;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.service.IContactService;
import com.at.internship.schedule.utils.EqualSpec;
import com.at.internship.schedule.utils.GreaterSpec;
import com.at.internship.schedule.utils.LikeIgnoreCaseSpec;
import com.at.internship.schedule.utils.LowerSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {
    private final IContactRepository contactRepository;

    public ContactServiceImpl(IContactRepository iContactRepository) {
        this.contactRepository = iContactRepository;
    }

    @Override
    public Page<Contact> findAllFilter(ContactFiltersDto filters, Pageable pageable) {
        String firstNameLike = filters.getFirstName() == null ? null : String.format("%%%s%%", filters.getFirstName());
        String lastNameLike = filters.getLastName() == null ? null : String.format("%%%s%%", filters.getLastName());
        String emailAddressLike = filters.getEmailAddress() == null ? null : String.format("%%%s%%", filters.getEmailAddress());
        LocalDate birthday = filters.getBirthDay() == null ? null :LocalDate.ofInstant(filters.getBirthDay().toInstant(), ZoneId.systemDefault());
        LocalDate birthdayGte = filters.getBirthDayGte() == null ? null : LocalDate.ofInstant(filters.getBirthDayGte().toInstant(), ZoneId.systemDefault());
        LocalDate birthdayLte = filters.getBirthDayLte() == null ? null : LocalDate.ofInstant(filters.getBirthDayLte().toInstant(), ZoneId.systemDefault());
        String nameLike = filters.getNameLike() == null ? null : String.format("%%%s%%", filters.getNameLike());
        Specification<Contact> specs = Specification
                .where(new EqualSpec<Contact>("id", filters.getId()))
                .and(new LikeIgnoreCaseSpec<>("firstName", firstNameLike))
                .and(new LikeIgnoreCaseSpec<>("lastName", lastNameLike))
                .and(new LikeIgnoreCaseSpec<>("emailAddress", emailAddressLike))
                .and(new EqualSpec<>("birthDay", birthday))
                .and(new GreaterSpec<>("birthDay", birthdayGte))
                .and(new LowerSpec<>("birthDay", birthdayLte))
                .and(new LikeIgnoreCaseSpec<>("name", nameLike));

        return contactRepository.findAll(specs, pageable);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> findById(Integer id) {
        return contactRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }
}
