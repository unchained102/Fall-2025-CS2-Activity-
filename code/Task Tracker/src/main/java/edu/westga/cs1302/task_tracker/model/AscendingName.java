package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** Compare two Tasks to identify the correct AscendingName ordering of the tasks.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class AscendingName implements Comparator<Task> {

	/** Returns a value indicating ordering of the two tasks based 
	 * on Ascending Name.
	 * 
	 * @precondition o1 != null && o2 != null
	 * @postcondition none
	 * 
	 * @param o1 the first task to compare
	 * @param o2 the second task to compare
	 * 
	 * @return -1 if o1 goes first
	 * 			0 if o1 and o2 are same
	 * 			1 if o1 goes last
	 */
	@Override
	public int compare(Task o1, Task o2) {
		if (o1 == null) {
			throw new IllegalArgumentException("o1 must not be null");
		}
		if (o2 == null) {
			throw new IllegalArgumentException("o2 must not be null");
		}
		
		if (o1.getName().equals(o2.getName())) {
			return 0;
		} else if (o1.getName().compareTo(o2.getName()) > 0) {
			return 1;
		} else {
			return -1;
		}
	}

	/** Returns the name of the task to represent the task as a String
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the task
	 */
	@Override
	public String toString() {
		return "Ascending Name";
	}

}
