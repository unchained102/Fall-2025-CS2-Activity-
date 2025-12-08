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

	@Override
	public String toString() {
		return this.title;
	}
}
