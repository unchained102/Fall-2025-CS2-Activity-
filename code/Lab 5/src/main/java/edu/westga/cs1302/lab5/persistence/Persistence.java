package edu.westga.cs1302.lab5.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.lab5.model.Student;

/** Base class for Persistence of Student Data
 * 
 * @author Ev
 * @version 1
 * 
 */
public abstract class Persistence {
	/**Saves student data using appropriate format (see children for details).
	 * 
	 * @precondition student != null
	 * @param students array of students to save
	 * @throws IllegalArgumentException if precondition is violated
	 * @throws IOException Unable to write to FILE_LOCATION
	 */
	public abstract void saveStudentData(Student[] students) throws IllegalArgumentException, IOException;
	
	/** Load the student data from the file.
	 * 
	 * @return array of students
	 * @throws FileNotFoundException If it cannot find the file.
	 * @throws IOException if unable to read the file due to invalid format.
	 */
	public abstract Student[] loadStudentData() throws FileNotFoundException, IOException;
}
