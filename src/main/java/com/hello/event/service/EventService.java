package com.hello.event.service;


import com.hello.event.enums.Category;
import com.hello.event.model.Contact;
import com.hello.event.model.Event;
import com.hello.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> findAll() {
       return eventRepository.findAll();
    }
    public Event save(Event event) {
        return eventRepository.save(event);
    }
    public List<Event> search(Category category, String location, LocalDateTime date) {
        return eventRepository.findEventByCategoryOrLocationOrDateTime(category, location, date);
    }

    public List<Contact> getEventContacts(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isPresent()) {
            return event.get().getContacts();
        } else {
            throw new RuntimeException("event not found  : " + eventId);
        }
    }
}
