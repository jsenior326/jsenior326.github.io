// Author: Jacob Senior

package grandStrandSystems;

public class Task {

	private String taskID;
	private String name;
	private String description;
	
	// Parameterized constructor for Task
	public Task(String taskID, String name, String description) {
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
	
}
