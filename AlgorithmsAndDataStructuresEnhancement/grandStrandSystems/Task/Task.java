// Author: Jacob Senior
//
// This file provides the definition for the Task class

package grandStrandSystems.Task;

public class Task implements Comparable<Task> {

	private String taskID;
	private String name;
	private String description;
	private int priority;
	
	// Parameterized constructor for Task when priority not supplied
	public Task(String taskID, String name, String description) {
		this(taskID, name, description, -1);
	}
	
	// Parameterized constructor for Task
	public Task(String taskID, String name, String description, int priority) {
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid taskID.");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		
		this.taskID = taskID;
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	// Accessors and Mutators for Task class
	public String getTaskID() {
		return taskID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		this.description = description;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) { 
		this.priority = priority;
	}
	
	// Override compareTo method orders tasks by their priority
	@Override
	public int compareTo(Task t) {
		return Integer.compare(this.priority, t.priority);
	}
	
	@Override
	public String toString() {
		return "{ name: " + this.name + ", priority: " + this.priority + " }";
	}
}
