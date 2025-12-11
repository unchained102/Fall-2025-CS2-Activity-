package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Comic;
class TestComicConstructor {

	@Test
	void testWhenTitleNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Comic(null, 1);
		}, "Asserting null title throw IllegalArgumentException");
	}
	
	@Test
	void testWhenTitleEmpty() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Comic("", 1);
		}, "Asserting empty title throw IllegalArgumentException");
	}
	
	@Test
	void testWhenValidTitle() {
		String validName = "Valid Name";
		Comic com = new Comic(validName, 1);
		assertEquals(validName, com.getTitle(), "Asserting valid title is passed through and accessible.");
	}
	
	@Test
	void testWhenIssueNumberLessThanOne() {
		String validName = "Valid Name";
		assertThrows(IllegalArgumentException.class, ()-> {
			new Comic(validName, 0);
		}, "Asserting that bad issueNumber throw IllegalArgumentException");
	}

}
