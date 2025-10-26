package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

/**A task with a list of subTasks.
 * 
 * @author me
 * @version 1
 * 
 */
public class ContainerTask extends Task {
	
	private ArrayList<Task> subTasks;
	
	/** ContainerTask Constructor.
	 * 
	 * @param name the Name of the ContainerTask
	 * @param description the Description of the ContainerTask
	 * @param priority the Priority of the ContainerTask
	 */
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
	}
	
	@Override
	public ArrayList<Task> getSubTasks() {
		return this.subTasks;
	}
	
	@Override
	public ContainerTask addTask(Task task) {
		this.subTasks.add(task);
		return this;
	}
	
	@Override
	public String toString() {
	return this.getName() + " (+)";
	}
	
}
