package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Comic;

class TestComicToString {

	@Test
	void test() {
		String expected = "\"What If?\" issue #5";
		Comic comic = new Comic("What If?", 5);
		
		assertEquals(expected, comic.toString());
		
	}

}
