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


    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found: " + id));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found: " + id));
        existingEvent.setName(updatedEvent.getName());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setDateTime(updatedEvent.getDateTime());
        existingEvent.setLocation(updatedEvent.getLocation());
        existingEvent.setCapacity(updatedEvent.getCapacity());
        existingEvent.setCategory(updatedEvent.getCategory());

        return eventRepository.save(existingEvent);
    }
}
