package com.hello.event.service;


import com.hello.event.enums.Category;
import com.hello.event.model.Event;
import com.hello.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

}
