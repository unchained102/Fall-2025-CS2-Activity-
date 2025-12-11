package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.model.ComicCollection;
import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;

class TestAddComicToSelectedCollection {

	@Test
	void testWhenNoSelectedCollection() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		
		ccvm.getSelected().set(null);
		ccvm.getTitle().set("Avengers");
		ccvm.getIssueNumber().set(1);
		
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.addComicToSelectedCollection();
		}, "Asserting no selection throw IllegalArgumentException");
	}
	
	@Test
	void testWhenComicTitleAlreadyExists() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		Comic comic = new Comic("Avengers", 1);
		ComicCollection selected = new ComicCollection("Collection");
		
		ccvm.getSelected().set(selected);
		ccvm.getSelected().get().getCollection().add(comic);
		ccvm.getTitle().set("Avengers");
		ccvm.getIssueNumber().set(2);
		
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.addCollectionToList();
		}, "Asserting existing comic with title throw IllegalArgumentException");
	}
	
	@Test
	void testWhenComicIssueNumberAlreadyExists() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		Comic comic = new Comic("Avengers", 1);
		ComicCollection selected = new ComicCollection("Collection");
		
		ccvm.getSelected().set(selected);
		ccvm.getSelected().get().getCollection().add(comic);
		ccvm.getTitle().set("X Men");
		ccvm.getIssueNumber().set(1);
		
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.addCollectionToList();
		}, "Asserting existing comic with title throw IllegalArgumentException");
	}
	
	@Test
	void testWhenAllIsWell() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		Comic comic = new Comic("Avengers", 1);
		ComicCollection selected = new ComicCollection("Collection");
		
		ccvm.getTitle().set("Avengers");
		ccvm.getIssueNumber().set(1);
		ccvm.getSelected().set(selected);
		ccvm.addComicToSelectedCollection();
		
		assertEquals(comic.getTitle(), ccvm.getSelectedCollectionListProperty().get().getFirst().getTitle());
		assertEquals(comic.getIssueNumber(), ccvm.getSelectedCollectionListProperty().get().getFirst().getIssueNumber());

		
	}

}
