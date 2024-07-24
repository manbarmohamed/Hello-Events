package com.hello.event.controller;

import com.hello.event.enums.Category;
import com.hello.event.model.Event;
import com.hello.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/event")
public class EventController {

    private final EventService eventService;

    //    @GetMapping("/all")
//    public ResponseEntity<List<Event>> getAllEvents() {
//        return ResponseEntity.ok(eventService.findAll());
//    }
//    @PostMapping("/add")
//    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(event));
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<Event>> searchEvents(@RequestParam(required = false) Category category,
//                                                    @RequestParam(required = false) String location,
//                                                    @RequestParam(required = false) LocalDateTime date) {
//        List<Event> eventList = eventService.search(category, location, date);
//        return ResponseEntity.ok(eventList);
//    }
    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.findAll();
        return ResponseEntity.ok(events);
    }

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event savedEvent = eventService.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvents(
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) LocalDateTime date) {
        List<Event> eventList = eventService.search(category, location, date);
        return ResponseEntity.ok(eventList);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEventsForAdmin() {
        List<Event> events = eventService.findAll();
        return ResponseEntity.ok(events);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/events")
    public ResponseEntity<Event> saveOrUpdateEvent(@RequestBody Event event) {
        Event savedEvent = eventService.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }
}
