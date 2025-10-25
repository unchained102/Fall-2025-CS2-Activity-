package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Implements comparator interface to sort ascending.
 * @author overw
 * @version 1
 * 
 */
public class Descending implements Comparator<Task> {
	@Override
	public int compare(Task taskA, Task taskB) {
		if (taskA == null) {
			throw new IllegalArgumentException("Tasks cannot be null");
		}
		if (taskB == null) {
			throw new IllegalArgumentException("Tasks cannot be null");
		}
		
		return taskA.getPriority().compareTo(taskB.getPriority());
		
	}
	
	@Override
	public String toString() {
		return "Descending Order";
	}
}
