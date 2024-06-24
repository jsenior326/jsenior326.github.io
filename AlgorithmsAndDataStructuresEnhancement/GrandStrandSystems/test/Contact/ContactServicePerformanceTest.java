package test.Contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Contact.Contact;
import grandStrandSystems.Contact.ContactService;
import grandStrandSystems.Contact.ContactServiceWithHashMap;

public class ContactServicePerformanceTest {
	
	private ContactService cs;
	private ContactServiceWithHashMap cshm;

	@BeforeEach
	void setup() {
		cs = new ContactService();
		cshm = new ContactServiceWithHashMap();

		String first = "first";
		String last = "last";
		String phone = "1111111111";
		String address = "address";
		
		// Timers used to calculate performance
		long startTime;
		long endTime;
		long duration;
		
		// Test adding speed of non-hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cs.addContact(new Contact(Integer.toString(i), first, last, phone, address));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Non-HashMap add took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		// Test adding speed of hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cshm.addContact(new Contact(Integer.toString(i), first, last, phone, address));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("HashMap add took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		System.out.println();
	}
	
	@Test
	void testUpdateComparison() {
		String first = "first";
		String last = "last";
		String phone = "1111111111";
		String address = "address";
		
		// Timers used to calculate performance
		long startTime;
		long endTime;
		long duration;
		
		// Test update speed of non-hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cs.updateContact(Integer.toString(i), first, last, phone, address);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Non-HashMap update took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		// Test update speed of hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cshm.updateContact(Integer.toString(i), first, last, phone, address);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("HashMap update took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		System.out.println();
	}
	
	@Test
	void testDeleteComparison() {
		String first = "first";
		String last = "last";
		String phone = "1111111111";
		String address = "address";
		
		// Timers used to calculate performance
		long startTime;
		long endTime;
		long duration;
		
		// Test delete speed of non-hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cs.deleteContact(Integer.toString(i));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Non-HashMap delete took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		// Test delete speed of hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cshm.deleteContact(Integer.toString(i));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("HashMap delete took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		System.out.println();
	}
	
	@Test
	void testFindComparison() {
		String first = "first";
		String last = "last";
		String phone = "1111111111";
		String address = "address";
		
		// Timers used to calculate performance
		long startTime;
		long endTime;
		long duration;
		
		// Test access speed of non-hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cs.findContact(Integer.toString(i));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Non-HashMap find took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		// Test access speed of hashmap implementation
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			cshm.findContact(Integer.toString(i));
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("HashMap find took: " + duration + " nanoseconds (" + duration / 1000000 + " ms)");
		
		System.out.println();
	}
}
