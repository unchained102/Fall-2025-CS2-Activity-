package model.Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.Project1.model.Task;


class TestDescriptionSetter {

	@Test
	void testWhenValid() {
		String testName = "Garbage"; 
		String testDesc1 = "Some description."; 
		String testDesc2 = "Some other description."; 
		String testPrio = "High"; 
		
		Task testTask = new Task(testName, testDesc1, testPrio);
		
		testTask.setDescription(testDesc2);
		
		assertEquals(testDesc2, testTask.getDescription());
	}
	
	void testWhenNull() {
		String testName = "Garbage"; 
		String testDesc1 = "Some description."; 
		String testPrio = "High"; 
		
		Task testTask = new Task(testName, testDesc1, testPrio);
		
		
		
		assertThrows(IllegalArgumentException.class, ()-> {
			testTask.setDescription(null);
		});
	}

}
