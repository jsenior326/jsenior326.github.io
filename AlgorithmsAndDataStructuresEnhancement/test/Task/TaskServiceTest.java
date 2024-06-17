// Author: Jacob Senior

package test.Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grandStrandSystems.Task.Task;
import grandStrandSystems.Task.TaskService;

class TaskServiceTest {
	
	private TaskService ts;
	
	@BeforeEach
	void setup() {
		ts = new TaskService();
	}

	@Test
	void testTaskServiceAddTask() {
		ts.addTask(new Task("taskID", "name", "description", 0));
		
		Task t = ts.getNextTask();
		
		assertEquals(ts.getTaskList().size(), 0);
		assertEquals(t.getName(), "name");
		assertEquals(t.getDescription(), "description");
	}
	
	@Test
	void testTaskServiceAddMultipleTasks() {
		ts.addTask(new Task("taskID", "name", "description", 0));
		ts.addTask(new Task("taskID2", "name2", "description2", 1));
		ts.addTask(new Task("taskID3", "name3", "description3", 2));
		
		Task t1 = ts.getNextTask();
		Task t2 = ts.getNextTask();
		Task t3 = ts.getNextTask();
		
		assertEquals(ts.getTaskList().size(), 0);
		
		// Test task 1
		assertEquals(t1.getName(), "name");
		assertEquals(t1.getDescription(), "description");
		
		// Test task 2
		assertEquals(t2.getName(), "name2");
		assertEquals(t2.getDescription(), "description2");
		
		// Test task 3
		assertEquals(t3.getName(), "name3");
		assertEquals(t3.getDescription(), "description3");
	}
	
	@Test
	void testAddTaskNotUnique() {
		ts.addTask(new Task("taskID", "name", "description"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ts.addTask(new Task("taskID", "name", "description"));
		});
	}
	
	@Test
	void testDeleteTask() {
		ts.addTask(new Task("taskID", "name", "description"));
		ts.deleteTask("taskID");
		
		assertEquals(ts.getTaskList().size(), 0);
	}
	
	@Test
	void testDeleteTaskMultipleElements() {
		ts.addTask(new Task("taskID", "name", "description"));
		ts.addTask(new Task("taskID2", "name2", "description2"));
		ts.deleteTask("taskID");
		
		assertEquals(ts.getTaskList().size(), 1);
		assertEquals(ts.getNextTask().getTaskID(), "taskID2");
	}
	
	@Test
	void testDeleteTasktNoElements() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ts.deleteTask("none");
		});
	}
	
	@Test
	void testDeleteTaskBadTaskID() {
		ts.addTask(new Task("taskID", "name", "description"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ts.deleteTask("taskID2");
		});
	}
	
	@Test
	void testDeleteTaskTaskIDNull() {
		ts.addTask(new Task("taskID", "name", "description"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ts.deleteTask(null);
		});
	}
	
	@Test
	void testUpdateTask() {
		ts.addTask(new Task("taskID", "name", "description", 0));
		ts.updateTask("taskID", "name2", "description2", 1);
		
		Task t = ts.getNextTask();
		
		assertEquals(ts.getTaskList().size(), 0);
		assertEquals(t.getTaskID(), "taskID");
		assertEquals(t.getName(), "name2");
		assertEquals(t.getDescription(), "description2");
	}
	
	@Test
	void testUpdateTaskEmptyList() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ts.updateTask("taskID", "name", "description", 0);
		});
	}
	
	@Test
	void testUpdateTaskBadTaskID() {
		ts.addTask(new Task("taskID", "name", "description"));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ts.updateTask("badtaskID", "name", "description", 0);
		});
	}
	
	@Test
	void testUpdateTaskTaskIDNull() {
		ts.addTask(new Task("taskID", "name", "description", 0));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ts.updateTask(null, "name", "description", 1);
		});
	}
}
