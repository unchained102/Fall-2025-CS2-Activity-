package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.model.ComicCollection;
import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
 
/** Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
    @FXML
    private Button addButton;

    @FXML
    private ListView<ComicCollection> comicCollection;

    @FXML
    private TextField comicNameField;

    @FXML
    private Button removeButton;
    
    @FXML
    private MenuItem contextRemove;
    
    private ComicCollectionViewModel ccvm;
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	this.addButton.setDisable(true);
    	this.ccvm = new ComicCollectionViewModel();
    	this.bindProperties();
    	this.bindBehaviour();
    	
    }
    
    private void bindProperties() {
    	this.ccvm.getName().bind(this.comicNameField.textProperty());
    	this.comicCollection.setItems(this.ccvm.getCollectionList());
    	this.ccvm.getSelected().bind(this.comicCollection.getSelectionModel().selectedItemProperty());
    }
    
    private void bindBehaviour() {
    	this.addButton.setOnAction((event) -> {
    		try {
				this.ccvm.addCollectionToList();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Add Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.removeButton.setOnAction((event) -> {
    		try {
				this.ccvm.removeCollectionFromList();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.contextRemove.setOnAction((event) -> {
    		try {
				this.ccvm.removeCollectionFromList();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.comicNameField.textProperty().addListener((observable, oldVal, newVal) -> {
    		this.addButton.setDisable(newVal.equals(""));
    	});
    }
    
}
