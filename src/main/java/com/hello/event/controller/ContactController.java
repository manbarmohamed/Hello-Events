package com.hello.event.controller;

import com.hello.event.model.Contact;
import com.hello.event.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> saveContact(Contact contact) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contact));
    }


    @GetMapping("/{contact_id}")
    public Contact findContactById( @PathVariable String contact_id) {
        return contactService.getContactById(Long.parseLong(contact_id));
    }
}
