package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.ContainerTask;


import org.junit.jupiter.api.Test;

class TestAddTask {

	@Test
	void testWhenTaskIsNull() {
		Task task = new Task("A", "B", Task.TaskPriority.HIGH);
		assertThrows(IllegalArgumentException.class, ()->{
			task.addTask(null);
		});
	}
	
	@Test
	void testWhenTaskIsNotNull() {
		Task task = new Task("A", "B", Task.TaskPriority.HIGH);
		Task subTask = new Task("B", "C", Task.TaskPriority.LOW);
		ContainerTask cTask = task.addTask(subTask);
		
		assertEquals("A", cTask.getName());
		assertEquals("B", cTask.getDescription());
		assertEquals(Task.TaskPriority.HIGH, cTask.getPriority());
		
		assertEquals("B", cTask.getSubTasks().getFirst().getName());
		assertEquals("C", cTask.getSubTasks().getFirst().getDescription());
		assertEquals(Task.TaskPriority.LOW, cTask.getSubTasks().getFirst().getPriority());


	}

}
