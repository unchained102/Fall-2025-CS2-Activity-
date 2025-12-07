package edu.westga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.comic_collection.model.ComicCollection;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
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
	private ComicCollection selected;
	
	/** Creates a new ComicCollectionViewModel
	 * 
	 * @author me
	 * @version 1
	 */
	public ComicCollectionViewModel() {
		this.name = new SimpleStringProperty();
		this.collectionList = new SimpleListProperty<ComicCollection>(FXCollections.observableList(new ArrayList<ComicCollection>()));
		
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
		if (this.selected != null) {
			this.collectionList.remove(this.selected);
		}
	}
}
