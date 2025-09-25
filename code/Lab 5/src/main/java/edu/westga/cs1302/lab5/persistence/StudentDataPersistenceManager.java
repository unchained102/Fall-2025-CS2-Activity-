package edu.westga.cs1302.lab5.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.lab5.model.Student;

/** Supports saving and loading student data,
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class StudentDataPersistenceManager {
	
	public static final String FILE_LOCATION = "data.txt";
	
	/** Save the students!
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the set of students to save
	 * @param path the String representation of the file path to save to.
	 * @throws IllegalArgumentException if precondition is violated
	 * @throws IOException Unable to write to FILE_LOCATION
	 */
	public static void saveStudentData(Student[] students, String path) throws IOException, IllegalArgumentException {
		if (students == null) {
			throw new IllegalArgumentException("must provide an array of students");
		}
		try (FileWriter writer = new FileWriter(path)) {
			for (Student currStudent : students) {
				writer.write(currStudent.getName() + ",");
				writer.write(currStudent.getGrade() + System.lineSeparator());
			}
		}
	}

	/** Load the students!
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the set of students loaded
	 * @param path the String representation of the file path to save to.
	 * @throws FileNotFoundException no file exists at FILE_LOCATION
	 * @throws IOException unable to read file due to formatting issue 
	 */
	public static Student[] loadStudentData(String path) throws FileNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(path);
		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String wholeNameAndGrade = reader.nextLine();
				String[] splitNameAndGrade = wholeNameAndGrade.split(",");
				String name = splitNameAndGrade[0];
				String sGrade = splitNameAndGrade[1];
				int grade = Integer.parseInt(sGrade);
				students.add(new Student(name, grade));
			}
		} catch (NumberFormatException error) {
			throw new IOException("Data was not formatted as \"name,grade\" (" + error.getMessage() + ")");
		} catch (IllegalArgumentException error) {
			throw new IOException(error.getMessage());
		}
		
		return students.toArray(new Student[0]);
	}
	
}
