package com.hello.event.service;

import com.hello.event.exception.ContactNotFoundException;
import com.hello.event.model.Contact;
import com.hello.event.model.User;
import com.hello.event.repository.ContactRepository;
import com.hello.event.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

//    public Contact save(String username, Contact contact) {
//        return contactRepository.save(contact);
//    }
public Contact save(Contact contact) {

    return contactRepository.save(contact);
}

    public Contact getContactById(long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    }

//    public List<Contact> getAllContacts() {
//        return contactRepository.findAll();
//    }
//
//    public List<Contact> getContactsByUsername(String username) {
//        return contactRepository.findByUser_Username(username);
//    }

    public List<Map<String, String>> getTeamAndValues() {
        return List.of(
                Map.of("type", "team", "name", "Alice", "role", "CEO", "bio", "Leader with a vision."),
                Map.of("type", "team", "name", "Bob", "role", "CTO", "bio", "Tech enthusiast."),
                Map.of("type", "value", "title", "Innovation", "description", "We strive to innovate."),
                Map.of("type", "value", "title", "Integrity", "description", "We uphold integrity.")
        );
    }
}
