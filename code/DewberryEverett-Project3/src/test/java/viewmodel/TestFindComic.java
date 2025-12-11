package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;
import edu.westga.cs1302.comic_collection.model.ComicCollection;


class TestFindComic {

	@Test
	void testWhenInvalidSearchCriteria() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ccvm.getSearchText().set("-_-");
		assertThrows(IllegalArgumentException.class, ()-> {
			ccvm.findComic();
		});
	}
	
	@Test
	void testWhenEmptyList() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ccvm.getSearchText().set("1");
		String expected = "No comic found.";
		assertEquals(expected, ccvm.findComic());
	}
	
	@Test
	void testWhenRealListButNoMatch() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ComicCollection selected = new ComicCollection("Test");
		ccvm.getTitle().set("Avengers");
		ccvm.getIssueNumber().set(1);
		ccvm.getSelected().set(selected);
		ccvm.addComicToSelectedCollection();
		ccvm.getSearchText().set("2");
		String expected = "No comic found.";
		assertEquals(expected, ccvm.findComic());
	}
	
	@Test
	void testWhenRealListAndMatch() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ComicCollection selected = new ComicCollection("Test");
		ccvm.getTitle().set("Avengers");
		ccvm.getIssueNumber().set(1);
		ccvm.getSelected().set(selected);
		ccvm.addComicToSelectedCollection();
		ccvm.getSearchText().set("1");
		String expected = "\"Avengers\" issue #1";
		assertEquals(expected, ccvm.findComic());
	}

}
