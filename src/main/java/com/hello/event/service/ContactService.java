package com.hello.event.service;


import com.hello.event.exception.ContactNotFoundExceptiion;
import com.hello.event.model.Contact;
import com.hello.event.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
    public Contact getContactById(long id) {
        Contact contact = contactRepository.findById(id).
                orElseThrow(()-> new ContactNotFoundExceptiion("Contact not found"));
        return contact;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
