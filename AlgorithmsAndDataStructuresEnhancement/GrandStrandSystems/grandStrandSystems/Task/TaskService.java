// Author: Jacob Senior
//
// This file implements services for the Task class and makes use of a priority
// queue and hash map

package grandStrandSystems.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskService {
	private PriorityQueue<Task> taskQueue;
	private Map<String, Task> taskMap; // Necessary for deleting and updating tasks
	
	// Constructor for TaskService
	public TaskService() {
		taskQueue = new PriorityQueue<>();
		taskMap = new HashMap<>();
	}
	
	// Add task to task list
	public void addTask(Task t) {
		// Search for a task with the given taskID
		if (taskMap.containsKey(t.getTaskID())) {
			throw new IllegalArgumentException("TaskID must be unique.");
		}
		
		// Add the task to the queue and map
		taskQueue.add(t);
		taskMap.put(t.getTaskID(), t);
	}
	
	// Delete task from task list by taskID
	public void deleteTask(String taskID) {
		Task t = taskMap.remove(taskID);
		
		// If t is not null, we found a task with a matching taskID in the list
		if (t != null) {
			taskQueue.remove(t);
		} else {
			// Else, no matching task was found
			throw new IllegalArgumentException("Task with the given taskID not found.");
		}
	}
	
	// Update name and description of the task given the taskID
	public void updateTask(String taskID, String name, String description, int priority) {
		Task t = taskMap.get(taskID);
		
		// If task found, update info
		if (t != null) {
			// Remove initial object from priority queue
			taskQueue.remove(t);
			
			// Update task info
			t.setName(name);
			t.setDescription(description);
			t.setPriority(priority);
			
			// Re-add task to priority queue
			taskQueue.add(t);
		} else {
			// If no task with the given taskID was found, throw exception
			throw new IllegalArgumentException("Task with the given taskID not found.");
		}
	}
	
	// taskList accessor
	public PriorityQueue<Task> getTaskList() {
		return taskQueue;
	}
	
	// Return task with the highest priority
	public Task getNextTask() {
		Task t = taskQueue.poll();
		
		if (t != null) {
			taskMap.remove(t.getTaskID());
		}
		
		return t;
	}
	
	// Print all tasks to the screen
	public void displayTasks() {
		List<Task> taskList = new ArrayList<>(taskQueue);
		
		for(Task t : taskList) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		TaskService ts = new TaskService();
		
		// Add tasks
		ts.addTask(new Task("taskID1", "name", "description", 2));
		ts.addTask(new Task("taskID2", "name2", "description2", 1));
		ts.addTask(new Task("taskID3", "name3", "description", 10));
		
		// Display initial task list
		System.out.println("Initial tasks:");
		ts.displayTasks();
		System.out.println();
		
		// Get task with highest priority
		System.out.println("-Polling next task-");
		System.out.println("Highest priority task: " + ts.getNextTask().toString());
		System.out.println();
		
		// Display resulting task list
		System.out.println("New task list:");
		ts.displayTasks();
		System.out.println();
		
		// Update task's priority
		System.out.println("-Updating task-");
		ts.updateTask("taskID3", "newName3", "newDescription3", 0);
		System.out.println("New task list:");
		ts.displayTasks();
		System.out.println();
		
		// Remove a task
		System.out.println("-Removing task-");
		ts.deleteTask("taskID1");
		System.out.println("New task list:");
		ts.displayTasks();
	}
}
