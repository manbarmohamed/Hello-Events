package com.hello.event.repository;

import com.hello.event.enums.Category;
import com.hello.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventByCategoryOrLocationOrDateTime(Category category, String location, LocalDateTime dateTime);
}
