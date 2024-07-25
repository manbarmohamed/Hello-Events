package com.hello.event.controller;

import com.hello.event.model.Contact;
import com.hello.event.model.User;
import com.hello.event.service.ContactService;
import com.hello.event.service.EventService;
import com.hello.event.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;
    private final EventService eventService;


    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<List<Contact>> getEventContacts(@PathVariable Long id) {
        List<Contact> contacts = eventService.getEventContacts(id);
        return ResponseEntity.ok(contacts);
    }

@PreAuthorize("hasRole('CLIENT')")
@PostMapping("/add")
public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String username = loggedInUser.getName();
    Contact savedContact = contactService.save(username, contact);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
}
    @GetMapping("/about")
    public ResponseEntity<List<Map<String, String>>> getTeamAndValues() {
        return ResponseEntity.ok(contactService.getTeamAndValues());
    }
}
//    @GetMapping
//    public ResponseEntity<List<Contact>> getMyContacts() {
//        List<Contact> contacts = contactService.getAllContacts();
//        return ResponseEntity.ok(contacts);
//    }

//    @PostMapping("/add")
//    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String username = loggedInUser.getName();
//        Contact savedContact = contactService.save(username, contact);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
//    }

//    @GetMapping("/{contact_id}")
//    public ResponseEntity<Contact> findContactById(@PathVariable Long contact_id) {
//        Contact contact = contactService.getContactById(contact_id);
//        return ResponseEntity.ok(contact);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<List<Contact>> getEventContacts(@PathVariable Long id) {
//        List<Contact> contacts = eventService.getEventContacts(id);
//        return ResponseEntity.ok(contacts);
//    }

