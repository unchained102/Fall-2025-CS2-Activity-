package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

	@Test
	void testWhenOneFormattedCorrectly() {
		Student ev = new Student("Everett", 89);
		Student[] students = new Student[1];
		Student[] testStudents = null;
		students[0] = ev;
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.saveStudentData(students, "src/test/resources/testData.txt");
		} catch (Exception e) {
			//Will not occur.
		}
		
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			testStudents = studentDataPersistenceManager.loadStudentData("src/test/resources/testData.txt");
		} catch (IOException error) {
			//Will not occur
		}
		assertEquals(ev.getName(), testStudents[0].getName(), "Asserting name is the same before and after save and load.");
		assertEquals(ev.getGrade(), testStudents[0].getGrade(), "Asserting grade is the same before and after save and load.");

	}
	
	@Test
	void testWhenMultipleFormattedCorrectly() {
		Student ev = new Student("Everett", 89);
		Student tan = new Student("Tanner", 55);
		Student dewb = new Student("Dewberry", 66);
		
		Student[] students = new Student[3];
		Student[] testStudents = null;
		students[0] = ev;
		students[1] = tan;
		students[2] = dewb;
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.saveStudentData(students, "src/test/resources/testData.txt");
		} catch (Exception e) {
			//Will not occur.
		}
		
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();

			testStudents = studentDataPersistenceManager.loadStudentData("src/test/resources/testData.txt");
		} catch (IOException error) {
			//Will not occur
		}
		
		/*
		 * Asserting that the objects can be recovered intact with all data being the same.
		 */
		assertEquals(ev.getName(), testStudents[0].getName());
		assertEquals(ev.getGrade(), testStudents[0].getGrade());
		assertEquals(tan.getName(), testStudents[1].getName());
		assertEquals(tan.getGrade(), testStudents[1].getGrade());
		assertEquals(dewb.getName(), testStudents[2].getName());
		assertEquals(dewb.getGrade(), testStudents[2].getGrade());

	}
	
	@Test
	void testWhenMissingGrade() {
		File testData = new File("src/test/resources/testData.txt");
		try (FileWriter writer = new FileWriter(testData)) {
			writer.write("Everett,");
		} catch (Exception e) {
			//Will not occur
		}
		
		assertThrows(IOException.class, ()-> {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.loadStudentData("src/test/resources/testData.txt");
		}, "Asserting that missing grade throw IOException.");
		
	}
	
	@Test
	void testWhenGradeNotInteger() {
		File testData = new File("src/test/resources/testData.txt");
		try (FileWriter writer = new FileWriter(testData)) {
			writer.write("Everett,twenty-five");
		} catch (Exception e) {
			//Will not occur
		}
		
		assertThrows(IOException.class, ()-> {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.loadStudentData("src/test/resources/testData.txt");
		}, "Asserting that Non-Integer grade throw IOException.");
		
	}
	
	@Test
	void testWhenNoStudentData() {
		File testData = new File("src/test/resources/testData.txt");
		try (FileWriter writer = new FileWriter(testData)) {
			writer.write("");
		} catch (Exception e) {
			//Will not occur
		}
		Student[] testStudents;
		try {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			testStudents = studentDataPersistenceManager.loadStudentData("src/test/resources/testData.txt");
		} catch (Exception e) {
			//Will not occur.
			testStudents = new Student[1];
		}
		assertEquals(0, testStudents.length, "Asserting that no data creates empty array.");
		
	}
	
	@Test
	void testNoSuchFile() {		
		assertThrows(FileNotFoundException.class, ()-> {
			StudentDataPersistenceManager studentDataPersistenceManager = new StudentDataPersistenceManager();
			studentDataPersistenceManager.loadStudentData("src/test/resources/DNE.txt");
		}, "Asserting that a nonexistent file path throws FileNotFound");
	}
}
