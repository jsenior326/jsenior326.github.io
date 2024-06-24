// Author: Jacob Senior

package grandStrandSystems;

import java.util.ArrayList;

public class TaskService {

	private ArrayList<Task> taskList;
	
	// Constructor for TaskService
	public TaskService() {
		taskList = new ArrayList<Task>();
	}
	
	// Add task to task list
	public void addTask(Task t) {
		// Search for a task with the given taskID
		for (Task task : taskList) {
			// Throw exception if the taskID is not unique
			if (task.getTaskID().equals(t.getTaskID())) {
				throw new IllegalArgumentException("TaskID must be unique.");
			}
		}
		
		// Add the task to the list
		taskList.add(t);
	}
	
	// Delete task from task list by taskID
	public void deleteTask(String taskID) {
		Task t = null;
		
		// Search for a task with the given taskID
		for (Task task : taskList) {
			if (task.getTaskID().equals(taskID)) {
				t = task;
			}
		}
		
		// If task was found, remove it from the task list
		if (t != null) {
			taskList.remove(t);
		} else {
			throw new IllegalArgumentException("Task with the given taskID not found.");
		}
	}
	
	// Update name and description of the task given the taskID
	public void updateTask(String taskID, String name, String description) {
		Task t = null;
		
		// Search for a task with he given taskID
		for (Task task : taskList) {
			if (task.getTaskID().equals(taskID)) {
				t = task;
			}
		}
		
		// If task found, update info
		if (t != null) {
			t.setName(name);
			t.setDescription(description);
		} else {
			// If no task with the given taskID was found, throw exception
			throw new IllegalArgumentException("Task with the given taskID not found.");
		}
	}
	
	// taskList accessor
	public ArrayList<Task> getTaskList() {
		return taskList;
	}
}
