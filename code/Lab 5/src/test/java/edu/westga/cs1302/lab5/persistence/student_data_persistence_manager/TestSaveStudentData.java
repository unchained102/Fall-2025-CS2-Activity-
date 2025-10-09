package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;


class TestSaveStudentData {

	@Test
	void testMultipleStudents() {
		Student[] students = new Student[3];
		
		Student student1 = new Student("Everett", 75);
		Student student2 = new Student("Tanner", 100);
		Student student3 = new Student("Dewberry", 20);
		
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.saveStudentData(students, "src/test/resources/testData.txt");
		}
		catch (IOException e) {
			//Won't happen during this test.
		}
		File testData = new File("src/test/resources/testData.txt");
		try (Scanner scnr = new Scanner(testData);) {
			assertEquals("Everett,75", scnr.nextLine(), "Asserting that first student data saved correctly.");
			assertEquals("Tanner,100", scnr.nextLine(), "Asserting that second student data saved correctly.");
			assertEquals("Dewberry,20", scnr.nextLine(), "Asserting that third student data saved correctly.");
		}
		catch (FileNotFoundException e) {
			//Will not occur
		}
	}
	
	@Test
	void testOneStudent() {
		Student[] students = new Student[1];
		
		Student student1 = new Student("Everett", 75);
		
		students[0] = student1;

		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.saveStudentData(students, "src/test/resources/testData.txt");
		}
		catch (IOException e) {
			//Won't happen during this test.
		}
		File testData = new File("src/test/resources/testData.txt");
		try (Scanner scnr = new Scanner(testData);) {
			assertEquals("Everett,75", scnr.nextLine(), "Asserting that student data is saved correctly.");
		}
		catch (FileNotFoundException e) {
			//Will not occur
		}
	}
	
	@Test
	void testNoStudents() {
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.saveStudentData(new Student[0], "src/test/resources/testData.txt");
		}
		catch (IOException e) {
			//Won't happen during this test.
		}
		File testData = new File("src/test/resources/testData.txt");
		try (Scanner scnr = new Scanner(testData);) {
			assertTrue(!scnr.hasNext(), "Asserting that the file is empty. (A list of no students should save an empty file.)");
		}
		catch (FileNotFoundException e) {
			//Will not occur
		}
	}
	
	@Test
	void testNullStudent() {
		Student[] students = new Student[2];
		students[0] = null;
		students[1] = new Student("Everett", 85);
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.saveStudentData(students, "src/test/resources/testData.txt");
		}
		catch (IOException e) {
			//Won't happen during this test.
		}
		File testData = new File("src/test/resources/testData.txt");
		try (Scanner scnr = new Scanner(testData);) {
			assertEquals(scnr.nextLine(),"Everett,85", "Asserting that the file contains the second student first. (Null student should be ignored)");
			assertFalse(scnr.hasNextLine(), "Asserting that the file only contains the second student.");
		}
		catch (FileNotFoundException e) {
			//Will not occur
		}
	}
	
	@Test
	void testNullArray() {
		assertThrows(IllegalArgumentException.class, ()-> { 
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.saveStudentData(null, "src/test/resources/testData.txt");
		});
	}

}
