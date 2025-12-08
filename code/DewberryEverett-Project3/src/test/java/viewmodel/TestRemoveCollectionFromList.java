package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.ComicCollection;
import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;

class TestRemoveCollectionFromList {

	@Test
	void testWhenSelectedPropertyNull() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ccvm.getSelected().setValue(null);
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.removeCollectionFromList();
		});
	}
	
	@Test
	void testWhenValidSelection() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		
		ComicCollection one = new ComicCollection("One");
		ComicCollection two = new ComicCollection("Two");
		
		ComicCollection three = new ComicCollection("Three");
		
		ArrayList<ComicCollection> list = new ArrayList<ComicCollection>();
		
		list.add(one);
		list.add(two);
		list.add(three);

		
		ccvm.getCollectionList().get().addAll(list);
		
		ccvm.getSelected().setValue(three);
		
		ccvm.removeCollectionFromList();
		
		for (ComicCollection col : ccvm.getCollectionList()) {
			if (col == three) {
				fail();
			}
			else {
				assertTrue(col == two || col == one, "Asserting that, col not having been the removed collection, that it for sure is one of the ones not removed");
			}
		}
	}

}
