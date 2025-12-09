package edu.westga.cs1302.comic_collection.view;

import java.io.IOException;

import edu.westga.cs1302.comic_collection.Main;
import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.model.ComicCollection;
import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
 
/** The code behind the main window for the Comic Collection application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
    @FXML
    private Button addCollectionButton;
    
    @FXML
    private Button removeCollectionButton;
    
    @FXML
    private Button addComicButton;
    
    @FXML
    private Button removeComicButton;

    @FXML
    private ListView<ComicCollection> comicCollectionList;
    
    @FXML
    private ListView<Comic> comicList;

    @FXML
    private TextField collectionNameField;
    
    @FXML
    private MenuItem contextRemoveCollection;
    
    @FXML
    private MenuItem contextRemoveComic;
    
    @FXML
    private TextField searchBar;
    
    @FXML
    private Button searchButton;
    
    private ComicCollectionViewModel ccvm;
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	this.addCollectionButton.setDisable(true);
    	this.ccvm = new ComicCollectionViewModel();
    	this.bindProperties();
    	this.bindBehaviour();
    	this.bindAddComicButton();
    	
    }
    
    private void bindProperties() {
    	this.ccvm.getName().bind(this.collectionNameField.textProperty());
    	this.comicCollectionList.itemsProperty().bind(this.ccvm.getCollectionList());
    	this.ccvm.getSelected().bind(this.comicCollectionList.getSelectionModel().selectedItemProperty());
    	this.comicList.itemsProperty().bind(this.ccvm.getSelectedCollectionListProperty());
    	this.ccvm.getSelectedComicProperty().bind(this.comicList.getSelectionModel().selectedItemProperty());
    	this.ccvm.getSearchText().bind(this.searchBar.textProperty());
    }
    
    private void bindBehaviour() {
    	this.addCollectionButton.setOnAction((event) -> {
    		try {
				this.ccvm.addCollectionToList();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Add Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.removeCollectionButton.setOnAction((event) -> {
    		try {
				this.ccvm.removeCollectionFromList();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.contextRemoveCollection.setOnAction((event) -> {
    		try {
				this.ccvm.removeCollectionFromList();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.collectionNameField.textProperty().addListener((observable, oldVal, newVal) -> {
    		this.addCollectionButton.setDisable(newVal.equals(""));
    	});
    	
    	this.removeComicButton.setOnAction((event) -> {
    		try {
				this.ccvm.removeComicFromSelectedCollection();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.contextRemoveComic.setOnAction((event) -> {
    		try {
				this.ccvm.removeComicFromSelectedCollection();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Remove Collection: " + error.getMessage());
				alert.showAndWait();
			}
    	});
    	
    	this.searchButton.setOnAction((event) -> {
    		try {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setContentText(this.ccvm.findComic());
    			alert.showAndWait();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to find comic" + error.getMessage());
				alert.showAndWait();
			}
    	});
    }
    
    private void bindAddComicButton() {
    	this.addComicButton.setOnAction((event) -> {
    		FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(Main.class.getResource(Main.ADD_COMIC_WINDOW));
        	try {
    			loader.load();
    	    	Parent parent = loader.getRoot();
    	    	Scene scene = new Scene(parent);
    	    	Stage addComicWindow = new Stage();
    	    	addComicWindow.setTitle("Add a Comic");
    	    	addComicWindow.setScene(scene);
    	    	addComicWindow.initModality(Modality.APPLICATION_MODAL);
    	    	
    	    	AddComicWindow controller = (AddComicWindow) loader.getController();
    	    	controller.setViewModel(this.ccvm);
    	    	
    	    	addComicWindow.showAndWait();
    		} catch (IOException error) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText("Failed to load comic window. Error loading UI components;");
    			alert.showAndWait();
    		} catch (IllegalArgumentException error) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText("Failed to load comic window. Error passing viewmodel to options window.");
    			alert.showAndWait();
    		}
    	});
    }
    
}
