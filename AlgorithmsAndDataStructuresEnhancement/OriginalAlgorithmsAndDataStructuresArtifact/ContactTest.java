// Author: Jacob Senior
// Assignment: CS320 Milestone One Contact Service
// Due Date: 11/12/2023

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Contact;

class ContactTest {
	
	protected Contact contact;

	@Test
	void testContact() {
		Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
		assertEquals(c.getContactID(), "contactID");
		assertEquals(c.getFirstName(), "firstName");
		assertEquals(c.getLastName(), "lastName");
		assertEquals(c.getPhone(), "1234567890");
		assertEquals(c.getAddress(), "address");
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID12345", "firstName", "lastName", "1234567890", "address");
		});
	}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact(null, "firstName", "lastName", "1234567890", "address");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName12345", "lastName", "1234567890", "address");
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", null, "lastName", "1234567890", "address");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName12345", "1234567890", "address");
		});
	}
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", null, "1234567890", "address");
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "123456789", "address");
		});
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "12345678900", "address");
		});
	}
	
	@Test
	void testContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", null, "address");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "1234567890123456789012345678901");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", null);
		});
	}
	
	@Test
	void testContactSetFirstName() {
		Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
		c.setFirstName("newFirst");
		assertTrue(c.getFirstName().equals("newFirst"));
	}
	
	@Test
	void testContactSetLastName() {
		Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
		c.setLastName("newLast");
		assertTrue(c.getLastName().equals("newLast"));
	}
	
	@Test
	void testContactSetPhone() {
		Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
		c.setPhone("0987654321");
		assertTrue(c.getPhone().equals("0987654321"));
	}
	
	@Test
	void testContactSetAddress() {
		Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
		c.setAddress("newAddress");
		assertTrue(c.getAddress().equals("newAddress"));
	}
	
	@Test
	void testContactSetFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setFirstName("firstName12345");
		});
	}
	
	@Test
	void testContactSetFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setFirstName(null);
		});
	}
	
	@Test
	void testContactSetLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setLastName("lastName12345");
		});
	}
	
	@Test
	void testContactSetLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setLastName(null);
		});
	}
	
	@Test
	void testContactSetPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setPhone("123456789");
		});
	}
	
	@Test
	void testContactSetPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setPhone("12345678901");
		});
	}
	
	@Test
	void testContactSetPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setPhone(null);
		});
	}
	
	@Test
	void testContactSetAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setAddress("1234567890123456789012345678901");
		});
	}
	
	@Test
	void testContactSetAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact c = new Contact("contactID", "firstName", "lastName", "1234567890", "address");
			c.setAddress(null);
		});
	}

}
