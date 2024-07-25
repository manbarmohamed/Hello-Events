package com.hello.event;

import com.hello.event.enums.Category;
import com.hello.event.model.Event;
import com.hello.event.repository.EventRepository;
import com.hello.event.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class EventTest {

	@Mock
	private EventRepository eventRepository;

	@InjectMocks
	private EventService eventService;

	private Event eventTest;

	@BeforeEach
	void setUp() {
		eventTest = new Event();
		eventTest.setIdE(1L);
		eventTest.setName("ceremonie");
		eventTest.setCategory(Category.CONFERENCE);
		eventTest.setDescription("diploma distribution ceremony");
		eventTest.setDateTime(LocalDateTime.of(2023, 1, 1, 10, 0));
		eventTest.setCapacity(67);
	}

	@Test
	public void testGetters() {
		assertEquals(1L, eventTest.getIdE());
		assertEquals("ceremonie", eventTest.getName());
		assertEquals(Category.CONFERENCE, eventTest.getCategory());
		assertEquals(67, eventTest.getCapacity());
		assertEquals(LocalDateTime.of(2023, 1, 1, 10, 0), eventTest.getDateTime());
	}

	@Test
	void testGetAllEvents() {
		when(eventRepository.findAll()).thenReturn(List.of(eventTest));

		List<Event> result = eventService.findAll();

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(eventTest.getIdE(), result.get(0).getIdE());

		verify(eventRepository, times(1)).findAll();
	}

	@Test
	void testSaveEvent() {
		when(eventRepository.save(any(Event.class))).thenAnswer(invocation -> {
			Event saveEvent = invocation.getArgument(0);
			if (saveEvent.getIdE() == null) {
				saveEvent.setIdE(1L);
			}
			return saveEvent;
		});
		Event eventTest = new Event();
		Event event = eventService.save(eventTest);
		assertNotNull(event);
		assertEquals(1L, event.getIdE());
	}
	@Test
	void testFindById(){
		Event event = new Event();
		event.setIdE(1L);
		when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
		Event result =  eventService.getEventById(1L);
		assertNotNull(result);
		assertEquals(1L , result.getIdE().longValue());
	}

//	@Test
//	public void testFindById() {
//		Event result = eventService.getEventById(1L);
//		assertNotNull(result);
//		assertEquals(1L, result.getIdE().longValue());
//	}


}

