package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.viewmodel.ComicCollectionViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Node;

/** The code behind the add comic window for the Comic Collection application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class AddComicWindow {
    @FXML
    private Button addComicButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField comicTitleField;

    @FXML
    private TextField issueNumberField;
    
    private ComicCollectionViewModel ccvm;
    
    @FXML
    void initialize() {
    	this.addComicButton.setDisable(true);
    }
    
    private void bindBehavior() {
		this.addComicButton.setOnAction((event) -> {
			try {
				this.ccvm.addComicToSelectedCollection();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to Add Comic: " + error.getMessage());
				alert.showAndWait();
			}
			});
		
		this.cancelButton.setOnAction((event) -> {
			((Node) (event.getSource())).getScene().getWindow().hide();
		});
		
		this.comicTitleField.textProperty().addListener((observable, oldVal, newVal) -> {
			if (!this.issueNumberField.getText().isEmpty()) {
				this.addComicButton.setDisable(newVal.equals(""));
			}
    	});
		
		this.issueNumberField.textProperty().addListener((observable, oldVal, newVal) -> {
			if (!this.comicTitleField.getText().isEmpty()) {
				this.addComicButton.setDisable(newVal.equals(""));
			}
    	});
		
		this.issueNumberField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
		    String character = event.getCharacter();
		    if (!character.matches("[0-9]")) { 
		        event.consume(); 
		    }
		});
		
	}
    
    private void bindProperties() {
    	this.ccvm.getTitle().bind(this.comicTitleField.textProperty());
    	Bindings.bindBidirectional(this.issueNumberField.textProperty(), this.ccvm.getIssueNumber(), new NumberStringConverter());
    }

    /** sets the viewmodel
     * 
     * @param ccvm the viewmodel to set
     */
    public void setViewModel(ComicCollectionViewModel ccvm) {
    	this.ccvm = ccvm;
    	this.bindBehavior();
    	this.bindProperties();
    }
}
