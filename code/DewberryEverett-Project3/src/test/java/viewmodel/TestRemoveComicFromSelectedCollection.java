package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.model.ComicCollection;
import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;

class TestRemoveComicFromSelectedCollection {

	@Test
	void testWhenNoSelectedCollection() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		
		ccvm.getSelected().set(null);
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.removeComicFromSelectedCollection();
		}, "Asserting no selected collection throw IllegalArgumentException");
	}
	
	@Test
	void testWhenNoSelectedComic() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		
		ccvm.getSelectedComicProperty().set(null);
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.removeComicFromSelectedCollection();
		}, "Asserting no selected comic throw IllegalArgumentException");
	}
	
	@Test
	void testWhenAllIsWell() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		Comic selectedComic = new Comic("Avengers", 1);
		ComicCollection selectedCollection = new ComicCollection("Collection");
		
		ccvm.getSelected().set(selectedCollection);
		ccvm.getSelected().get().getCollection().add(selectedComic);
		assertEquals(selectedComic.getTitle(), ccvm.getSelected().get().getCollection().getFirst().getTitle());
		ccvm.getSelectedComicProperty().set(selectedComic);
		
		ccvm.removeComicFromSelectedCollection();
		assertTrue(ccvm.getSelected().get().getCollection().isEmpty());
		

		
	}

}
