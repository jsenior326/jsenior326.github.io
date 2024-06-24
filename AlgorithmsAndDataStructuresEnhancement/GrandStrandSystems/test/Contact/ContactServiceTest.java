// Author: Jacob Senior
// Assignment: CS320 Milestone One Contact Service
// Due Date: 11/12/2023

package test.Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Contact.Contact;
import grandStrandSystems.Contact.ContactService;

class ContactServiceTest {
	
	private ContactService cs;
	
	@BeforeEach
	void setup() {
		cs = new ContactService();
	}

	@Test
	void testAddContact() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		
		Contact c1 = cs.getContactList().get(0);
		
		assertEquals(c1.getContactID(), "contactID");
		assertEquals(c1.getFirstName(), "firstName");
		assertEquals(c1.getLastName(), "lastName");
		assertEquals(c1.getPhone(), "1234567890");
		assertEquals(c1.getAddress(), "address");
	}
	
	@Test
	void testAddContactMultipleContacts() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		cs.addContact(new Contact("contactID2", "firstName2", "lastName2", "2234567890", "address2"));
		cs.addContact(new Contact("contactID3", "firstName3", "lastName3", "3234567890", "address3"));
		
		Contact c1 = cs.getContactList().get(0);
		Contact c2 = cs.getContactList().get(1);
		Contact c3 = cs.getContactList().get(2);
		
		// Test contact 1
		assertEquals(c1.getContactID(), "contactID");
		assertEquals(c1.getFirstName(), "firstName");
		assertEquals(c1.getLastName(), "lastName");
		assertEquals(c1.getPhone(), "1234567890");
		assertEquals(c1.getAddress(), "address");
		
		// Test contact 2
		assertEquals(c2.getContactID(), "contactID2");
		assertEquals(c2.getFirstName(), "firstName2");
		assertEquals(c2.getLastName(), "lastName2");
		assertEquals(c2.getPhone(), "2234567890");
		assertEquals(c2.getAddress(), "address2");
		
		// Test contact 3
		assertEquals(c3.getContactID(), "contactID3");
		assertEquals(c3.getFirstName(), "firstName3");
		assertEquals(c3.getLastName(), "lastName3");
		assertEquals(c3.getPhone(), "3234567890");
		assertEquals(c3.getAddress(), "address3");
	}
	
	@Test
	void testAddContactNotUnique() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		});
	}
	
	@Test
	void testDeleteContact() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		cs.deleteContact("contactID");
		
		assertEquals(cs.getContactList().size(), 0);
	}
	
	@Test 
	void testDeleteContactMultipleElements() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		cs.addContact(new Contact("contactID2", "firstName", "lastName", "1234567890", "address"));
		cs.deleteContact("contactID");
		
		assertEquals(cs.getContactList().size(), 1);
		assertEquals(cs.getContactList().get(0).getContactID(), "contactID2");
	}
	
	@Test
	void testDeleteContactNoElements() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.deleteContact("none");
		});
	}
	
	@Test
	void testDeleteContactBadContactID() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.deleteContact("none");
		});
	}
	
	@Test
	void testDeleteContactContactIDNull() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.deleteContact(null);
		});
	}
	
	@Test
	void testUpdateContact() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		cs.updateContact("contactID", "newFirst", "newLast", "0987654321", "newAddress");
		Contact c = cs.getContactList().get(0);
		
		assertEquals(cs.getContactList().size(), 1);
		assertEquals(c.getContactID(), "contactID");
		assertEquals(c.getFirstName(), "newFirst");
		assertEquals(c.getLastName(), "newLast");
		assertEquals(c.getPhone(), "0987654321");
		assertEquals(c.getAddress(), "newAddress");
	}
	
	@Test
	void testUpdateContactNoElementsInList() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("contactID", "firstName", "lastName", "1234567890", "address");
		});
	}
	
	@Test
	void testUpdateContactBadContactID() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("badID", "firstName", "lastName", "1234567890", "address");
		});
	}
	
	@Test
	void testUpdateContactContactIDNull() {
		cs.addContact(new Contact("contactID", "firstName", "lastName", "1234567890", "address"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact(null, "firstName", "lastName", "1234567890", "address");
		});
	}

}
