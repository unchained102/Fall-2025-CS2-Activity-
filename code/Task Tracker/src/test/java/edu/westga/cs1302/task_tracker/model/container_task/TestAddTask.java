package edu.westga.cs1302.task_tracker.model.container_task;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.ContainerTask;

import org.junit.jupiter.api.Test;

class TestAddTask {

	@Test
	void testWhenTaskIsNull() {
		ContainerTask task = new ContainerTask("A", "B", Task.TaskPriority.HIGH);
		assertThrows(IllegalArgumentException.class, ()->{
			task.addTask(null);
		});
	}
	
	@Test
	void testWhenTaskIsNotNull() {
		ContainerTask task = new ContainerTask("A", "B", Task.TaskPriority.HIGH);
		Task subTask = new Task("B", "C", Task.TaskPriority.LOW);
		task.addTask(subTask);
		
		assertEquals("A", task.getName());
		assertEquals("B", task.getDescription());
		assertEquals(Task.TaskPriority.HIGH, task.getPriority());
		
		assertEquals("B", task.getSubTasks().getFirst().getName());
		assertEquals("C", task.getSubTasks().getFirst().getDescription());
		assertEquals(Task.TaskPriority.LOW, task.getSubTasks().getFirst().getPriority());


	}

}
