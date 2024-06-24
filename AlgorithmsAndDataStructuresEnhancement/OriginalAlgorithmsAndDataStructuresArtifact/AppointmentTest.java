// Author: Jacob Senior

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Appointment;

import java.util.Date;

class AppointmentTest {

	@Test
	void testAppointment() {
		Appointment a = new Appointment("id", new Date(200, 10, 26), "description");
		
		assertEquals(a.getAppointmentID(), "id");
		assertEquals(a.getAppointmentDate(), new Date(200, 10, 26));
		assertEquals(a.getDescription(), "description");
	}
	
	@Test
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment a = new Appointment("id1234567890", new Date(200, 10, 26), "description");
		});
	}
	
	@Test
	void testAppointmentIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment a = new Appointment(null, new Date(200, 10, 26), "description");
		});
	}
	
	@Test
	void testAppointmentDateInThePast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment a = new Appointment("id", new Date(0, 0, 0), "description");
		});
	}

	@Test
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment a = new Appointment("id", null, "description");
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment a = new Appointment("id", new Date(200, 10, 26), "description12345678901234567890123456789012345678901234567890");
		});
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment a = new Appointment("id", new Date(200, 10, 26), null);
		});
	}
	
	@Test
	void testAppointmentSetDate() {
		Appointment a = new Appointment("id", new Date(200, 10, 26), "description");
		a.setAppointmentDate(new Date(201, 11, 27));
		assertEquals(a.getAppointmentDate(), new Date(201, 11, 27));
	}
	
	@Test
	void testAppointmentSetDateInThePast() {
		Appointment a = new Appointment("id", new Date(200, 10, 26), "description");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			a.setAppointmentDate(new Date(0, 0, 0));
		});
	}
	
	@Test
	void testAppointmentSetDateNull() {
		Appointment a = new Appointment("id", new Date(200, 10, 26), "description");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			a.setAppointmentDate(null);
		});
	}
	
	@Test
	void testAppointmentSetDescription() {
		Appointment a = new Appointment("id", new Date(200, 10, 26), "description");
		a.setDescription("newDescription");
		assertEquals(a.getDescription(), "newDescription");
	}
	
	@Test
	void testAppointmentSetDescriptionTooLong() {
		Appointment a = new Appointment("id", new Date(200, 10, 26), "description");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			a.setDescription("description12345678901234567890123456789012345678901234567890");
		});
	}
	
	@Test
	void testAppointmentSetDescriptionNull() {
		Appointment a = new Appointment("id", new Date(200, 10, 26), "description");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			a.setDescription(null);
		});
	}
}
