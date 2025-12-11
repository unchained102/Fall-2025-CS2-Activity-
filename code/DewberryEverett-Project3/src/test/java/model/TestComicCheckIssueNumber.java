package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Comic;

class TestComicCheckIssueNumber {

	@Test
	void testWhenValidNumber() {
		String number = "5";
		assertTrue(Comic.checkIssueNumber(number));
	}
	
	@Test
	void testWhenInvalidNumber() {
		String number = "379i";
		assertFalse(Comic.checkIssueNumber(number));
	}
}