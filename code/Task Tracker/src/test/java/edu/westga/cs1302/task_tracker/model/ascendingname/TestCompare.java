package edu.westga.cs1302.task_tracker.model.ascendingname;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.AscendingName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testO1IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{ascendingName.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("name", "desc", TaskPriority.HIGH);
		Task o2 = new Task("name", "desc", TaskPriority.HIGH);
		AscendingName ascendingName = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{ascendingName.compare(o1, null);});
	}
	
	@Test
	void testO1AfterAndO2Before() {
		Task o1 = new Task("b", "desc", TaskPriority.HIGH);
		Task o2 = new Task("a", "desc", TaskPriority.MEDIUM);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1BeforeAndO2After() {
		Task o1 = new Task("a", "desc", TaskPriority.HIGH);
		Task o2 = new Task("b", "desc", TaskPriority.MEDIUM);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1AndO2Equal() {
		Task o1 = new Task("a", "desc", TaskPriority.HIGH);
		Task o2 = new Task("a", "desc", TaskPriority.MEDIUM);
		AscendingName ascendingName = new AscendingName();
		
		int result = ascendingName.compare(o1, o2);

		assertTrue(result == 0);
	}

}
