package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.model.ComicCollection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
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
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
}
