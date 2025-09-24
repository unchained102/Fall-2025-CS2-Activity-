package edu.westga.cs1302.Project1.model;

import java.util.ArrayList;

/**Contains useful static methods.
 * @author edewber2@my.westga.edu
 * @version 1.0
 */
public class Utility {
	
	/** Gets the number of tasks in a given list of a given priority.
	 * 
	 * @param taskList the list of tasks we're searching through.
	 * @param priority the priority we want to get the number of tasks of
	 * @return numTasks the number of tasks of the priority in the args.
	 */
	public static int getNumTasksPerPriority(ArrayList<Task> taskList, String priority) {
		
		if (taskList == null) {
			throw new IllegalArgumentException("taskList cannot be null!");
		}
		
		if (!(priority.equals("High") || priority.equals("Medium") || priority.equals("Low"))) {
			throw new IllegalArgumentException("Invalid priority: Priority must be High, Medium or Low");
		}
		
		if (taskList.isEmpty()) {
			return 0;
		}
		for (Task task : taskList) {
			if (task == null) {
				throw new IllegalArgumentException("No task in the list can be null.");
			}
		}
		
		int numTasks = 0;
		for (Task task : taskList) {
			if (task.getPriority().equals(priority)) {
				numTasks++;
			}
		}
		
		return numTasks;
	}
}
