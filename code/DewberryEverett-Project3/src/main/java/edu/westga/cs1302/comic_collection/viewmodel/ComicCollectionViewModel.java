package edu.westga.cs1302.comic_collection.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import javafx.collections.ObservableList;

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
	private StringProperty searchText;
	private Map<Integer, Comic> numberMap;
	private Map<String, Comic> titleMap;
	
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
		this.titleMap = new HashMap<String, Comic>();
		this.numberMap = new HashMap<Integer, Comic>();
		
		this.selectedCollectionProperty.addListener((obs, oldCol, newCol) -> {
		    if (newCol != null) {
		    	ObservableList<Comic> observableList = FXCollections.observableArrayList(newCol.getCollection());
		        this.selectedCollectionListProperty.set(observableList);
		    } else {
		        this.selectedCollectionListProperty.set(FXCollections.observableArrayList());
		    }
		});
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

	/** gets the title
	 * @return the title
	 */
	public StringProperty getTitle() {
		return this.title;
	}

	/** gets the issueNumber
	 * @return the issueNumber
	 */
	public IntegerProperty getIssueNumber() {
		return this.issueNumber;
	}

	/** gets the selectedCollectionListProperty
	 * @return the selectedCollectionListProperty
	 */
	public ListProperty<Comic> getSelectedCollectionListProperty() {
		return this.selectedCollectionListProperty;
	}

	/** gets the selectedComicProperty
	 * @return the selectedComicProperty
	 */
	public ObjectProperty<Comic> getSelectedComicProperty() {
		return this.selectedComicProperty;
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
	    
	    if (this.titleMap.containsKey(this.title.get())) {
			throw new IllegalArgumentException("Comic with name " + this.title.get() + " already on file.");
		}
		if (this.numberMap.containsKey(this.issueNumber.get())) {
			throw new IllegalArgumentException("Comic with number " + this.issueNumber.get() + " already on file.");
		}
		
	    Comic newComic = new Comic(this.title.get(), this.issueNumber.get());
	    
	    this.numberMap.put(this.getIssueNumber().get(), newComic);
	    this.titleMap.put(this.getTitle().get(), newComic);

	    this.selectedCollectionProperty.get().getCollection().add(newComic);

	    this.selectedCollectionListProperty.add(newComic);
	}
	
	/** Removes the comic from the selected collection.
	 * 
	 */
	public void removeComicFromSelectedCollection() {
	    ComicCollection selected = this.selectedCollectionProperty.get();
	    if (selected == null) {
	        throw new IllegalArgumentException("Please select a collection to add a comic.");
	    }

	    selected.getCollection().remove(this.selectedComicProperty.get());
	    this.numberMap.remove(this.selectedComicProperty.get().getIssueNumber());

	    this.selectedCollectionListProperty.remove(this.selectedComicProperty.get());
	}

	/** Returns the searchText property
	 * @return the searchText
	 */
	public StringProperty getSearchText() {
		return this.searchText;
	}
	
	/** Finds a comic with name or issue number that matches provided searchText
	 * 
	 * @precondition none
	 * @postcondition Comic found or return no comic found.
	 * 
	 * @return A string representation of the comic found.
	 */
	public String findComic() {
		if (!Comic.checkName(this.searchText.get()) && !Comic.checkIssueNumber(this.searchText.get())) {
			throw new IllegalArgumentException("Search criteria is not a valid name or issue number");
		}

		if (Comic.checkName(this.searchText.getValue())) {
			Comic found = this.titleMap.get(this.searchText.get());
			if (found != null) {
				return found.toString();
			}
		}
		if (Comic.checkIssueNumber(this.searchText.getValue())) {
			int parsedNum = Integer.parseInt(this.searchText.get());
			Comic found = this.numberMap.get(parsedNum);
			if (found != null) {
				return found.toString();
			}		
		}
		return "No comic found.";
	}
}
