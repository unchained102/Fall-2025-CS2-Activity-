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
    void submitPressed(ActionEvent event) {
    	Task task = new Task(this.nameField.getText(), this.descriptionBox.getText(), this.priorityBox.getValue().toString());
    	this.taskList.getItems().add(task);
    }
    
    @FXML
    void taskSelectedMouse(MouseEvent event) {
    	if (this.taskList.getSelectionModel().getSelectedItem() != null) {
    		this.selectedNameField.setText(this.taskList.getSelectionModel().getSelectedItem().toString());
    		this.selectedDescription.setText(this.taskList.getSelectionModel().getSelectedItem().getDescription());
    		this.selectedPriority.setText(this.taskList.getSelectionModel().getSelectedItem().getPriority());

    	} else {
    		this.selectedNameField.setText("No Task Selected");
    	}
    }
    
    @FXML
    void taskSelectedKeyboard(KeyEvent event) {
    	if (this.taskList.getSelectionModel().getSelectedItem() != null) {
    		this.selectedNameField.setText(this.taskList.getSelectionModel().getSelectedItem().toString());
    		this.selectedDescription.setText(this.taskList.getSelectionModel().getSelectedItem().getDescription());
    		this.selectedPriority.setText(this.taskList.getSelectionModel().getSelectedItem().getPriority());

    	} else {
    		this.selectedNameField.setText("No Task Selected");
    	}
    }
    
    @FXML
    void updateDescriptionPressed(ActionEvent event) {
    	if (this.taskList.getSelectionModel().getSelectedItem() != null) {
    		this.taskList.getSelectionModel().getSelectedItem().setDescription(this.selectedDescription.getText());
    	}
    }
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	String[] aPriorities = {"High", "Medium", "Low"};
    	ObservableList<String> olPriorities = FXCollections.observableArrayList(aPriorities);
    	this.priorityBox.setItems(olPriorities);
    }
}
