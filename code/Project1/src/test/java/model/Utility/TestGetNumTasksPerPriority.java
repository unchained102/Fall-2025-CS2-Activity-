package model.Utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Project1.model.Task;
import edu.westga.cs1302.Project1.model.Utility;

class TestGetNumTasksPerPriority {

	@Test
	void testWhenListIsNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			Utility.getNumTasksPerPriority(null, "High");
		}, "Asserting that a null list throws exception");
	}
	
	@Test
	void testWhenBadPriority() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		Task testTask = new Task("Garbage", "take it out.", "High");
		taskList.add(testTask);
		assertThrows(IllegalArgumentException.class, ()-> {
			Utility.getNumTasksPerPriority(taskList, "Seven");
		}, "Asserting that using an invalid priority throws exception.");
	}
	
	@Test
	void testWhenListIsEmpty() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		assertEquals(Utility.getNumTasksPerPriority(taskList, "Medium"), 0, "Asserting that an empty list returns zero always.");
	}
	
	@Test
	void testWhenNullItem() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList.add(null);
		assertThrows(IllegalArgumentException.class, ()-> {
			Utility.getNumTasksPerPriority(taskList, "High");
		}, "Asserting that a null list item throws exception.");
	}
	
	@Test
	void testWhenOneItemOfLowPriority() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		Task testTask1 = new Task("Garbage", "take it out.", "High");
		Task testTask2 = new Task("Garbage", "take it out.", "Medium");
		Task testTask3 = new Task("Garbage", "take it out.", "Low");
		
		taskList.add(testTask1);
		taskList.add(testTask2);
		taskList.add(testTask3);
		
		assertEquals(1, Utility.getNumTasksPerPriority(taskList, "Low"));

		
	}
	
	@Test
	void testWhenOneItemOfMediumPriority() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		Task testTask1 = new Task("Garbage", "take it out.", "High");
		Task testTask2 = new Task("Garbage", "take it out.", "Medium");
		Task testTask3 = new Task("Garbage", "take it out.", "Low");
		
		taskList.add(testTask1);
		taskList.add(testTask2);
		taskList.add(testTask3);
		
		assertEquals(1, Utility.getNumTasksPerPriority(taskList, "Medium"));

		
	}
	
	@Test
	void testWhenOneItemOfHighPriority() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		Task testTask1 = new Task("Garbage", "take it out.", "High");
		Task testTask2 = new Task("Garbage", "take it out.", "Medium");
		Task testTask3 = new Task("Garbage", "take it out.", "Low");
		
		taskList.add(testTask1);
		taskList.add(testTask2);
		taskList.add(testTask3);
		
		assertEquals(1, Utility.getNumTasksPerPriority(taskList, "High"));

		
	}
	
	@Test
	void testWhenNoItemOfGivenPriority() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		Task testTask2 = new Task("Garbage", "take it out.", "Medium");
		Task testTask3 = new Task("Garbage", "take it out.", "Low");
		
		taskList.add(testTask2);
		taskList.add(testTask3);
		
		assertEquals(0, Utility.getNumTasksPerPriority(taskList, "High"));

		
	}
	@Test
	void testWhenThreeItemsOfGivenPriority() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		Task testTask1 = new Task("Garbage", "take it out.", "Medium");
		Task testTask2 = new Task("Garbage", "take it out.", "Medium");
		Task testTask3 = new Task("Garbage", "take it out.", "Medium");
		
				
		taskList.add(testTask1);
		taskList.add(testTask2);
		taskList.add(testTask3);
		
		assertEquals(3, Utility.getNumTasksPerPriority(taskList, "Medium"));

		
	}

}
