package edu.westga.cs1302.comic_collection.model;

/** Represents a comic with a title and an issue number.
 * 
 * @author me
 * @version 1
 */
public class Comic {
	private String title;
	private int issueNumber;
	
	/** Creates a new comic.
	 * 
	 * @param title the title of the comic
	 * @param issueNumber the issue number of the comic
	 */
	public Comic(String title, int issueNumber) {
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null");
		}
		if (title.equals("")) {
			throw new IllegalArgumentException("Title cannot be empty");
		}
		if (issueNumber < 1) {
			throw new IllegalArgumentException("Issue Number cannot be less than 1");
		}
		
		this.title = title;
		this.issueNumber = issueNumber;
	}
	
	/** Get the title of the comic.
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/** Get the issue number of the comic.
	 * @return the issueNumber
	 */
	public int getIssueNumber() {
		return this.issueNumber;
	}
	
	/** Checks if is a title
	 * Must have at least one character and can have only letters
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param name the text to be checked
	 * @return true 	if name matches expected style
	 * 		   false 	if name does not match expected style
	 */
	public static boolean checkName(String name) {
		return name != null && name.matches("[a-zA-Z\\s]+");
	}
	
	/** Checks if an entered search is a number
	 * Must have at least one number
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param name the text to be checked
	 * @return true 	if name matches expected style
	 * 		   false 	if name does not match expected style
	 */
	public static boolean checkIssueNumber(String name) {
		return name != null && name.matches("[0-9]+");
	}

	@Override
	public String toString() {
		return "\"" + this.title + "\"" + " issue #" + this.issueNumber;
	}
}
