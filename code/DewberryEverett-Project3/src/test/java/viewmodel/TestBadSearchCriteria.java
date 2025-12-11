package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;

class TestBadSearchCriteria {

	@Test
	void testWhenBadSearchCriteria() {
		String expected = "Bad search criteria. Please input a number or comic title.";
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ccvm.getSearchText().set("-_-");
		
		assertEquals(expected, ccvm.badSearchCriteria());
	}
	
	@Test
	void testWhenGoodSearchCriteria() {
		String expected = "";
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ccvm.getSearchText().set("Avengers");
		
		assertEquals(expected, ccvm.badSearchCriteria());
	}

}
