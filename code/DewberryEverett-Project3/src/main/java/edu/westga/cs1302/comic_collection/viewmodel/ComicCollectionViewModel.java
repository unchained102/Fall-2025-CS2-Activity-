package edu.westga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.model.ComicCollection;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
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
public class ComicCollectionViewModel {
	private StringProperty name;
	private ListProperty<ComicCollection> collectionList;
	private ObjectProperty<ComicCollection> selectedProperty;
	
	/** Creates a new ComicCollectionViewModel
	 * 
	 */
	public ComicCollectionViewModel() {
		this.name = new SimpleStringProperty();
		this.collectionList = new SimpleListProperty<ComicCollection>(FXCollections.observableList(new ArrayList<ComicCollection>()));
		this.selectedProperty = new SimpleObjectProperty<ComicCollection>();
		
	}
	
	/**Gets the name
	 * @return the name
	 */
	public StringProperty getName() {
		return this.name;
	}

	/**Gets the list
	 * @return the collectionList
	 */
	public ListProperty<ComicCollection> getCollectionList() {
		return this.collectionList;
	}

	/**Gets the currently selected ComicCollection's property
	 * @return the selectedProperty
	 */
	public ObjectProperty<ComicCollection> getSelected() {
		return this.selectedProperty;
	}

	/** Adds a ComicCollection to the list based on the name in the text field.
	 * 
	 *@precondition name != null && name != ""
	 *@postcondition ComicCollection of the name this.name will be added to the collectionList.
	 */
	public void addCollectionToList() {
		if (this.name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (this.name.equals("")) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		this.collectionList.add(new ComicCollection(this.name.getValue()));
	}
	
	/** Removes a ComicCollection to the list based on the selected ComicCollection.
	 * 
	 * @precondition selected != null
	 *@postcondition ComicCollection selected will be removed from the collectionList.
	 */
	public void removeCollectionFromList() {
		if (this.selectedProperty.get() == null) {
			throw new IllegalArgumentException("Please select a Collection to remove it.");
		}
		this.collectionList.remove(this.selectedProperty.get());
	}
	
	/** Adds the comic to the selected collection.
	 * 
	 * @param comic the comic to be added
	 */
	public void addComicToSelectedCollection(Comic comic) {
		if (comic == null) {
			throw new IllegalArgumentException("comic cannot be null.");
		}
		if (this.selectedProperty.get() == null) {
			throw new IllegalArgumentException("Please select a collection to add a comic.");
		}
		this.selectedProperty.get().getCollection().add(comic);
	}
}
