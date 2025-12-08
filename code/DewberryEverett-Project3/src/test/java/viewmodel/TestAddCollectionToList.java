package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.comic_collection.model.ComicCollection;
import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;
class TestAddCollectionToList {

	@Test
	void testWhenNameNull() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ccvm.getName().setValue(null);
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.addCollectionToList();
		}, "Asserting null name throw IllegalArgumentException");
	}
	
	@Test
	void testWhenNameEmpty() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		ccvm.getName().setValue("");
		assertThrows(IllegalArgumentException.class, ()->{
			ccvm.addCollectionToList();
		}, "Asserting empty name throw IllegalArgumentException");
	}
	
	@Test
	void testWhenNameValid() {
		ComicCollectionViewModel ccvm = new ComicCollectionViewModel();
		String validName = "Valid Name";
		ccvm.getName().setValue(validName);
		ccvm.addCollectionToList();
		assertEquals(validName, ccvm.getCollectionList().getFirst().getName(), "Asserting valid name collection added to list and is accessible");
	}

}
