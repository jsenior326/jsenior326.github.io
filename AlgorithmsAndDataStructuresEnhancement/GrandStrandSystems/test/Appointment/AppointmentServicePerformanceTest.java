package test.Appointment;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Appointment.Appointment;
import grandStrandSystems.Appointment.AppointmentService;
import grandStrandSystems.Appointment.AppointmentServiceWithQuickSort;

public class AppointmentServicePerformanceTest {
	private AppointmentService as;
	private AppointmentServiceWithQuickSort asqs;
	
	@BeforeEach
	void setup() {
		as = new AppointmentService();
		asqs = new AppointmentServiceWithQuickSort();
		
		String description = "description";
		
		for (int i = 0; i < 1000; i++) { 
			as.addAppointment(new Appointment(Integer.toString(i), new Date(200+i, 10, 26), description));
			asqs.addAppointment(new Appointment(Integer.toString(i), new Date(200+i, 10, 26), description));
		}
	}
	
	@Test
	void testFindComparison() {
		// Timers used to calculate performance
		long startTime;
		long endTime;
		long duration;
		
		// Test access speed of non-sorted implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			as.findAppointment(new Date(200+i, 10, 26));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Non-Sorted find took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		// Test access speed of non-sorted implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			asqs.findAppointment(new Date(200+i, 10, 26));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Sorted find took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
				
	}
}
