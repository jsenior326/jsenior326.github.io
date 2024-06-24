// Author: Jacob Senior

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Task;

class TaskTest {

	@Test
	void testTask() {
		Task t = new Task("taskID", "name", "description");
		assertEquals(t.getTaskID(), "taskID");
		assertEquals(t.getName(), "name");
		assertEquals(t.getDescription(), "description");
	}

	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task t = new Task("taskID12345", "name", "description");
		});
	}
	
	@Test
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task t = new Task(null, "name", "description");
		});
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task t = new Task("taskID", "name12345678901234567890", "description");
		});
	}
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task t = new Task("taskID", null, "description");
		});
	}
	
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task t = new Task("taskID", "name", "description12345678901234567890123456789012345678901234567890");
		});
	}
	
	@Test
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task t = new Task("taskID", "name", null);
		});
	}
	
	@Test
	void testTaskSetName() {
		Task t = new Task("taskID", "name", "description");
		t.setName("newName");
		assertEquals(t.getName(), "newName");
	}
	
	@Test
	void testTaskSetNameTooLong() {
		Task t = new Task("taskID", "name", "description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			t.setName("newName12345678901234567890");
		});
	}
	
	@Test
	void testTaskSetNameNull() {
		Task t = new Task("taskID", "name", "description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			t.setName(null);
		});
	}
	
	@Test
	void testTaskSetDescription() {
		Task t = new Task("taskID", "name", "description");
		t.setDescription("newDescription");
		assertEquals(t.getDescription(), "newDescription");
	}
	
	@Test
	void testTaskSetDescriptionTooLong() {
		Task t = new Task("taskID", "name", "description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			t.setDescription("newDescription1234567890123456789012345678901234567890");
		});
	}
	
	@Test
	void testTaskSetDescriptionNull() {
		Task t = new Task("taskID", "name", "description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			t.setDescription(null);
		});
	}
}
