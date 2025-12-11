package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.comic_collection.model.Comic;

class TestComicCheckName {

	@Test
	void testWhenValidName() {
		String name = "Avengers too";
		assertTrue(Comic.checkName(name));
	}
	
	@Test
	void testWhenInvalidName() {
		String name = "Av3ngers 2";
		assertFalse(Comic.checkName(name));
	}

}
