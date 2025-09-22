package edu.westga.cs1302.Project1.model;

/**
 * Represents a task with a certain priority, name, and description. 
 * @version 1.0
 * @author edewber2@my.westga.edu
 */
public class Task {
	private final String name;
	private String description;
	private final String priority;
	
	/**
	 * Task constructor. 
	 * @param name the name of the task
	 * @param description a description of the task
	 * @param priority the priority of the task.
	 */
	public Task(String name, String description, String priority) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null.");
		}
		if (priority == null) {
			throw new IllegalArgumentException("Priority cannot be null.");
		}
		
		this.name = name;
		this.description = description;
		this.priority = priority;
	}

	/**
	 * Getter for the description.
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Setter for the description.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null.");
		}
		this.description = description;
	}

	/**
	 * Getter for priority
	 * @return the priority
	 */
	public String getPriority() {
		return this.priority;
	}
	
	/**
	 * Returns the string name as a representation of the task.
	 * @return the name
	 */
	public String toString() {
		return this.name;
	}
	
}
