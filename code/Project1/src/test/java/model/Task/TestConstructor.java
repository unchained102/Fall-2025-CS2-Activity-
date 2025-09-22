package model.Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.Project1.model.Task;

class TestConstructor {

	@Test
	void testWhenAllIsWell() {
		String testName = "Garbage";
		String testDesc = "Take out the garbage.";
		String testPrio = "High";
		Task testTask = new Task(testName, testDesc, testPrio);
		
		assertEquals(testName, testTask.toString(), "Asserting name is constructed appropriately.");
		assertEquals(testDesc, testTask.getDescription(), "Asserting description is constructed appropriately.");
		assertEquals(testPrio, testTask.getPriority(), "Asserting priority is constructed appropriately.");
	}
	
	@Test
	void testWhenNameNull() {
		String testDesc = "Take out the garbage.";
		String testPrio = "High";
		
		assertThrows(IllegalArgumentException.class, ()-> {
			Task testTask = new Task(null, testDesc, testPrio);
		});
	}
	
	@Test
	void testWhenDescriptionNull() {
		String testName = "Garbage";
		String testPrio = "High";
		
		assertThrows(IllegalArgumentException.class, ()-> {
			Task testTask = new Task(testName, null, testPrio);
		});
	}
	
	@Test
	void testWhenPriorityNull() {
		String testName = "Garbage";
		String testDesc = "Take out the garbage.";
		
		assertThrows(IllegalArgumentException.class, ()-> {
			Task testTask = new Task(testName, testDesc, null);
		});
	}
}
