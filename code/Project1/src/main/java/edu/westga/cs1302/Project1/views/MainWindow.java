package edu.westga.cs1302.Project1.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import edu.westga.cs1302.Project1.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    @FXML
    private TextArea descriptionBox;

    @FXML
    private TextField nameField;
    
    @FXML
    private TextField selectedNameField;

    @FXML
    private ComboBox<String> priorityBox;
    
    @FXML
    private TextField selectedPriority;
    
    @FXML
    private TextArea selectedDescription;

    @FXML
    private Button submitButton;

    @FXML
    private ListView<Task> taskList;
    
    @FXML
    private Label highPriority;

    @FXML
    private Label lowPriority;

    @FXML
    private Label mediumPriority;
    
    @FXML
    private Label totalTasks;
    
	boolean nameFieldAndDescriptionBoxAndPriorityBoxNotNull() {
		return this.nameField.getText() != null && this.descriptionBox.getText() != null && this.priorityBox.getValue() != null;
	}
    
    void updateDisplayedTask() {
    	if (this.selectedItemNotNull()) {
    		this.selectedNameField.setText(this.getSelectedItemName());
    		this.selectedDescription.setText(this.getSelectedItemDescription());
    		this.selectedPriority.setText(this.getSelectedItemPriority());

    	} else {
    		this.selectedNameField.setText("No Task Selected");
    		this.selectedDescription.setText("");
    		this.selectedPriority.setText("");
    	}
    }

	boolean selectedItemNotNull() {
		return this.taskList.getSelectionModel().getSelectedItem() != null;
	}

	String getSelectedItemPriority() {
		return this.taskList.getSelectionModel().getSelectedItem().getPriority();
	}

	String getSelectedItemDescription() {
		return this.taskList.getSelectionModel().getSelectedItem().getDescription();
	}

	String getSelectedItemName() {
		return this.taskList.getSelectionModel().getSelectedItem().toString();
	}
	
	int selectedItemIndex() {
		return this.taskList.getSelectionModel().getSelectedIndex();
	}
	
	void updateSelectedDescription() {
		this.taskList.getSelectionModel().getSelectedItem().setDescription(this.selectedDescription.getText());
	}
    
    @FXML
    void deleteSelectedTaskPressed(ActionEvent event) {
    	if (this.selectedItemNotNull()) {
    		this.taskList.getItems().remove(this.selectedItemIndex());
    	}
    	this.updateDisplayedTask();
    }
    
    @FXML
    void taskSelectedMouse(MouseEvent event) {
    	this.updateDisplayedTask();
    }
    
    @FXML
    void taskSelectedKeyboard(KeyEvent event) {
    	this.updateDisplayedTask();
    }
    
    @FXML
    void updateDescriptionPressed(ActionEvent event) {
    	if (this.selectedItemNotNull()) {
    		this.updateSelectedDescription();
    	}
    }
    
    @FXML
    void addTaskPressed(ActionEvent event) {
    	if (this.nameFieldAndDescriptionBoxAndPriorityBoxNotNull()) {
    		Task task = new Task(this.nameField.getText(), this.descriptionBox.getText(), this.priorityBox.getValue().toString());
    		this.taskList.getItems().add(task);
    	}
    }
    
    /**
     * Takes the constant PRIORITIES from Task and converts it into JavaFX's weird Observable ArrayList (olPriorities) so that it can be used in the ComboBox.
     */
    public void initialize() {
    	ObservableList<String> olPriorities = FXCollections.observableArrayList(Task.PRIORITIES);
    	this.priorityBox.setItems(olPriorities);
    }
}
