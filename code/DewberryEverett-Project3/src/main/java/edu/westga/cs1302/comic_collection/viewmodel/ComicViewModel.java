package edu.westga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.model.ComicCollection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**ViewModel class for ComicCollection
 * 
 * @author me
 * @version 1
 * 
 */
public class ComicViewModel {
	private StringProperty title;
	private IntegerProperty issueNumber;
	private ListProperty<Comic> comicList;
	private ObjectProperty<Comic> selectedProperty;
	
	/** Creates a new ComicCollectionViewModel
	 * 
	 */
	public ComicViewModel() {
		this.comicList = new SimpleListProperty<Comic>(FXCollections.observableList(new ArrayList<Comic>()));
		this.title = new SimpleStringProperty();
		this.issueNumber = new SimpleIntegerProperty();
		this.selectedProperty = new SimpleObjectProperty<Comic>();
	}
	
	/** Adds the comic to the selected collection.
	 * 
	 * @param collection the comic collection to be added to
	 */
	public void addComicToSelectedCollection(ComicCollection collection) {
		if (this.title == null) {
			throw new IllegalArgumentException("title cannot be null.");
		}
		if (this.title.get().equals("")) {
			throw new IllegalArgumentException("title cannot be null.");
		}
		if (this.selectedProperty.get() == null) {
			throw new IllegalArgumentException("Please select a collection to add a comic.");
		}
		
	}
}
