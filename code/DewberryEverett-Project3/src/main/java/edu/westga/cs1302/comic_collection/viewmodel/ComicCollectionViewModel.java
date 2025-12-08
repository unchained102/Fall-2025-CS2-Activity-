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
public class ComicCollectionViewModel {
	private StringProperty collectionNameProperty;
	private ListProperty<ComicCollection> collectionListProperty;
	private ObjectProperty<ComicCollection> selectedCollectionProperty;
	
	private StringProperty title;
	private IntegerProperty issueNumber;
	private ListProperty<Comic> selectedCollectionListProperty;
	private ObjectProperty<Comic> selectedComicProperty;
	
	/** Creates a new ComicCollectionViewModel
	 * 
	 */
	public ComicCollectionViewModel() {
		this.collectionNameProperty = new SimpleStringProperty();
		this.collectionListProperty = new SimpleListProperty<ComicCollection>(FXCollections.observableList(new ArrayList<ComicCollection>()));
		this.selectedCollectionListProperty = new SimpleListProperty<Comic>(FXCollections.observableList(new ArrayList<Comic>()));
		this.selectedCollectionProperty = new SimpleObjectProperty<ComicCollection>();
		this.title = new SimpleStringProperty();
		this.issueNumber = new SimpleIntegerProperty();
		this.selectedComicProperty = new SimpleObjectProperty<Comic>();
		
	}
	
	/**Gets the name
	 * @return the name
	 */
	public StringProperty getName() {
		return this.collectionNameProperty;
	}

	/**Gets the list
	 * @return the collectionList
	 */
	public ListProperty<ComicCollection> getCollectionList() {
		return this.collectionListProperty;
	}

	/**Gets the currently selected ComicCollection's property
	 * @return the selectedProperty
	 */
	public ObjectProperty<ComicCollection> getSelected() {
		return this.selectedCollectionProperty;
	}

	/** Adds a ComicCollection to the list based on the name in the text field.
	 * 
	 *@precondition name != null && name != ""
	 *@postcondition ComicCollection of the name this.name will be added to the collectionList.
	 */
	public void addCollectionToList() {
		if (this.collectionNameProperty == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (this.collectionNameProperty.equals("")) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		this.collectionListProperty.add(new ComicCollection(this.collectionNameProperty.getValue()));
	}
	
	/** Removes a ComicCollection to the list based on the selected ComicCollection.
	 * 
	 * @precondition selected != null
	 *@postcondition ComicCollection selected will be removed from the collectionList.
	 */
	public void removeCollectionFromList() {
		if (this.selectedCollectionProperty.get() == null) {
			throw new IllegalArgumentException("Please select a Collection to remove it.");
		}
		this.collectionListProperty.remove(this.selectedCollectionProperty.get());
	}
	
	/** Adds the comic to the selected collection.
	 * 
	 */
	public void addComicToSelectedCollection() {
		if (this.selectedCollectionProperty.get() == null) {
			throw new IllegalArgumentException("Please select a collection to add a comic.");
		}
		this.selectedCollectionProperty.get().getCollection().add(new Comic(this.title.get(), this.issueNumber.get()));
		this.selectedCollectionListProperty = new SimpleListProperty<Comic>(FXCollections.observableList(this.selectedCollectionProperty.get().getCollection()));
	}
}
