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
public class StudentDataPersistenceManager extends Persistence {
	
	public static final String FILE_LOCATION = "data.txt";
	
	/** Save the students!
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the set of students to save
	 * @throws IllegalArgumentException if precondition is violated
	 * @throws IOException Unable to write to FILE_LOCATION
	 */
	@Override
	public void saveStudentData(Student[] students) throws IOException, IllegalArgumentException {
		if (students == null) {
			throw new IllegalArgumentException("must provide an array of students");
		}
		try (FileWriter writer = new FileWriter(FILE_LOCATION)) {
			for (Student currStudent : students) {
				if (currStudent != null) {
					writer.write(currStudent.getName() + ',');
					writer.write(currStudent.getGrade() + System.lineSeparator());
				}
			}
		}
	}
	
	/** Save the students!
	 * 
	 * 
	 * @precondition students != null (an individual student can be null but will be ignored)
	 * @postcondition Students saved to file defined by path.
	 * 
	 * @param path the path of the file to be saved to
	 * @param students the set of students to save
	 * @throws IllegalArgumentException if precondition is violated
	 * @throws IOException Unable to write to FILE_LOCATION
	 */
	public void saveStudentData(Student[] students, String path) throws IOException, IllegalArgumentException {
		if (students == null) {
			throw new IllegalArgumentException("must provide an array of students");
		}
		try (FileWriter writer = new FileWriter(path)) {
			for (Student currStudent : students) {
				if (currStudent != null) {
					writer.write(currStudent.getName() + ',');
					writer.write(currStudent.getGrade() + System.lineSeparator());
				}
			}
		}
	}

	/** Load the students!
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the set of students loaded
	 * @throws FileNotFoundException no file exists at FILE_LOCATION
	 * @throws IOException unable to read file due to formatting issue 
	 */
	@Override
	public Student[] loadStudentData() throws FileNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(FILE_LOCATION);
		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String[] nameAndGrade = reader.nextLine().split(",");
				if (nameAndGrade.length == 1) {
					throw new IOException("missing grade for " + nameAndGrade[0]);
				}
				String name = nameAndGrade[0];
				int grade = Integer.parseInt(nameAndGrade[1]);
				students.add(new Student(name, grade));
			}
		} catch (NumberFormatException error) {
			throw new IOException("grade value was not formatted as an integer (" + error.getMessage() + ")");
		} catch (IllegalArgumentException error) {
			throw new IOException(error.getMessage());
		}
		
		return students.toArray(new Student[0]);
	}
	
	/** Load the students!
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * 
	 * @param path the filepath to be saved to
	 * @return the set of students loaded
	 * @throws FileNotFoundException no file exists at FILE_LOCATION
	 * @throws IOException unable to read file due to formatting issue 
	 */
	public Student[] loadStudentData(String path) throws FileNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(path);
		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String[] nameAndGrade = reader.nextLine().split(",");
				if (nameAndGrade.length == 1) {
					throw new IOException("missing grade for " + nameAndGrade[0]);
				}
				String name = nameAndGrade[0];
				int grade = Integer.parseInt(nameAndGrade[1]);
				students.add(new Student(name, grade));
			}
		} catch (NumberFormatException error) {
			throw new IOException("grade value was not formatted as an integer (" + error.getMessage() + ")");
		} catch (IllegalArgumentException error) {
			throw new IOException(error.getMessage());
		}
		
		return students.toArray(new Student[0]);
	}
	
}
