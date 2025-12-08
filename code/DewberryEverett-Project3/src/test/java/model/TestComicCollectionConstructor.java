package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.ComicCollection;

class TestComicCollectionConstructor {

	@Test
	void testWhenNameNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new ComicCollection(null);
		}, "Asserting null name throw IllegalArgumentException");
	}
	
	@Test
	void testWhenNameEmpty() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new ComicCollection("");
		}, "Asserting empty name throw IllegalArgumentException");
	}
	
	@Test
	void testWhenValidName() {
		String validName = "Valid Name";
		ComicCollection col = new ComicCollection(validName);
		assertEquals(validName, col.getName(), "Asserting valid name is passed through and accessible.");
	}

}
