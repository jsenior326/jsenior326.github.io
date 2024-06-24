// Author: Jacob Senior

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Appointment;
import grandStrandSystems.AppointmentService;

class AppointmentServiceTest {

	private AppointmentService as;
	
	@BeforeEach
	void setup() {
		as = new AppointmentService();
	}
	
	@Test
	void testAppointmentServiceAddAppointment() {
		as.addAppointment(new Appointment("id", new Date(200, 10, 26), "description"));
		
		Appointment a = as.getAppointmentList().get(0);
		
		assertEquals(as.getAppointmentList().size(), 1);
		assertEquals(a.getAppointmentID(), "id");
		assertEquals(a.getAppointmentDate(), new Date(200, 10, 26));
		assertEquals(a.getDescription(), "description");
	}
	
	@Test
	void testAppointmentServiceAddMultipleAppointments() {
		as.addAppointment(new Appointment("id1", new Date(200, 10, 26), "description1"));
		as.addAppointment(new Appointment("id2", new Date(201, 11, 27), "description2"));
		as.addAppointment(new Appointment("id3", new Date(202, 12, 28), "description3"));
		
		Appointment a1 = as.getAppointmentList().get(0);
		Appointment a2 = as.getAppointmentList().get(1);
		Appointment a3 = as.getAppointmentList().get(2);
		
		assertEquals(as.getAppointmentList().size(), 3);
		
		assertEquals(a1.getAppointmentID(), "id1");
		assertEquals(a1.getAppointmentDate(), new Date(200, 10, 26));
		assertEquals(a1.getDescription(), "description1");
		
		assertEquals(a2.getAppointmentID(), "id2");
		assertEquals(a2.getAppointmentDate(), new Date(201, 11, 27));
		assertEquals(a2.getDescription(), "description2");
		
		assertEquals(a3.getAppointmentID(), "id3");
		assertEquals(a3.getAppointmentDate(), new Date(202, 12, 28));
		assertEquals(a3.getDescription(), "description3");
	}
	
	@Test
	void testAddAppointmentNotUnique() {
		as.addAppointment(new Appointment("id", new Date(200, 10, 26), "description"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			as.addAppointment(new Appointment("id", new Date(200, 10, 26), "description"));
		});
	}
	
	@Test
	void testDeleteAppointment() {
		as.addAppointment(new Appointment("id", new Date(200, 10, 26), "description"));
		as.deleteAppointment("id");
		
		assertEquals(as.getAppointmentList().size(), 0);
	}
	
	@Test
	void testDeleteAppointmentMultipleElements() {
		as.addAppointment(new Appointment("id", new Date(200, 10, 26), "description"));
		as.addAppointment(new Appointment("id2", new Date(201, 11, 27), "description2"));
		as.addAppointment(new Appointment("id3", new Date(202, 12, 28), "description3"));
		as.deleteAppointment("id");
		as.deleteAppointment("id3");
		
		assertEquals(as.getAppointmentList().size(), 1);
		assertEquals(as.getAppointmentList().get(0).getAppointmentID(), "id2");
	}
	
	@Test
	void testDeleteAppointmentNoElements() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			as.deleteAppointment("id");
		});
	}
	
	@Test
	void testDeleteAppointmentBadAppointmentID() {
		as.addAppointment(new Appointment("id", new Date(200, 10, 26), "description"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			as.deleteAppointment("id2");
		});
	}
	
	@Test
	void testDeleteAppointmentAppointmentIDNull() {
		as.addAppointment(new Appointment("id", new Date(200, 10, 26), "description"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			as.deleteAppointment(null);
		});
	}

}
