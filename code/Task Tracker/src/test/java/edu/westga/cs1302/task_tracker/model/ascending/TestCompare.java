package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.Ascending;

class TestCompare {

	@Test
	void testTaskANull() {
		Task taskB = new Task("Garbage", "Take out the garbage.", TaskPriority.HIGH);
		Ascending asc = new Ascending();
		
		assertThrows(IllegalArgumentException.class, ()->{asc.compare(null, taskB);}, "Asserting that taskA being null throws exception.");
	}
	
	@Test
	void testTaskBNull() {
		Task taskA = new Task("Garbage", "Take out the garbage.", TaskPriority.HIGH);
		Ascending asc = new Ascending();
		
		assertThrows(IllegalArgumentException.class, ()->{asc.compare(taskA, null);}, "Asserting that taskB being null throws exception.");
	}
	
	@Test
	void testWhenAHigherPriority() {
		Task taskA = new Task("Garbage", "Take out the garbage.", TaskPriority.HIGH);
		Task taskB = new Task("Garbage", "Take out the garbage.", TaskPriority.MEDIUM);
		Ascending asc = new Ascending();
		
		assertEquals(1, asc.compare(taskA, taskB), "Assert that comparison where task A has higher priority than B returns 1 (Which means they would swap indices during iteration as this is in ascending priority order.)");
	}
	
	@Test
	void testWhenALowerPriority() {
		Task taskA = new Task("Garbage", "Take out the garbage.", TaskPriority.LOW);
		Task taskB = new Task("Garbage", "Take out the garbage.", TaskPriority.HIGH);
		Ascending asc = new Ascending();
		
		assertEquals(-1, asc.compare(taskA, taskB), "Assert that comparison where task A has lower priority than B returns -1 (Which means they would not swap indices during iteration as this is in ascending priority order.)");
	}
	
	@Test
	void testWhenAAndBSamePriority() {
		Task taskA = new Task("Garbage", "Take out the garbage.", TaskPriority.MEDIUM);
		Task taskB = new Task("Garbage", "Take out the garbage.", TaskPriority.MEDIUM);
		Ascending asc = new Ascending();
		
		assertEquals(0, asc.compare(taskA, taskB), "Assert that when a's priority and b's priority are the same, zero is returned (which means nothing would be done during iteration according to Collections:sort docs)");
	}

}
