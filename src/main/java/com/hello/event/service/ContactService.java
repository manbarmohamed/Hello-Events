package com.hello.event.service;

import com.hello.event.exception.ContactNotFoundException;
import com.hello.event.model.Contact;
import com.hello.event.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact save(String username, Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact getContactById(long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<Contact> getContactsByUsername(String username) {
        return contactRepository.findByUserUsername(username); // Utilisez la méthode ajoutée dans ContactRepository
    }
}
