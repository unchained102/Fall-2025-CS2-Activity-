package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

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
		
		int aVal;
		int bVal;
		
		if (taskA.getPriority() == TaskPriority.HIGH) {
			aVal = 3;
		} else if (taskA.getPriority() == TaskPriority.MEDIUM) {
			aVal = 2;
		} else {
			aVal = 1;
		}
		
		if (taskB.getPriority() == TaskPriority.HIGH) {
			bVal = 3;
		} else if (taskB.getPriority() == TaskPriority.MEDIUM) {
			bVal = 2;
		} else {
			bVal = 1;
		}
		
		if (aVal < bVal) {
			return 1;
		} else if (aVal == bVal) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return "Descending Order";
	}
}
