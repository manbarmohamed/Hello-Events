package com.hello.event;

import com.hello.event.model.Contact;
import com.hello.event.repository.ContactRepository;
import com.hello.event.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class ContactTest {

	@Mock
	private ContactRepository contactRepository;

	@InjectMocks
	private ContactService contactService;

	private Contact contactTest;

	@BeforeEach
	void setUp() {
		contactTest = new Contact();
		contactTest.setIdC(1L);
		contactTest.setName("majdou");
		contactTest.setEmail("imane@gmail.com");
		contactTest.setMessage("contact me");
	}

	@Test
	void testGetters() {
		assertEquals(1L, contactTest.getIdC());
		assertEquals("majdou", contactTest.getName());
		assertEquals("imane@gmail.com", contactTest.getEmail());
		assertEquals("contact me", contactTest.getMessage());
	}

	@Test
	void testGetAllContacts() {
		when(contactRepository.findAll()).thenReturn(List.of(contactTest));

		List<Contact> result = contactService.getAllContacts();

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(contactTest.getIdC(), result.get(0).getIdC());

		verify(contactRepository, times(1)).findAll();
	}

	@Test
	void testSaveContact() {
		when(contactRepository.save(any(Contact.class))).thenAnswer(invocation -> {
			Contact savedContact = invocation.getArgument(0);
			if (savedContact.getIdC() == null) {
				savedContact.setIdC(1L);
			}
			return savedContact;
		});

		Contact savedContact = contactService.save(contactTest);

		assertNotNull(savedContact);
		assertEquals(1L, savedContact.getIdC());
	}

	@Test
	void testFindById() {
		when(contactRepository.findById(1L)).thenReturn(Optional.of(contactTest));

		Contact result = contactService.getContactById(1L);

		assertNotNull(result);
		assertEquals(1L, result.getIdC().longValue());
	}
}
