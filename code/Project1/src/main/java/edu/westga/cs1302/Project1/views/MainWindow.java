package edu.westga.cs1302.Project1.views;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private ComboBox<?> priorityBox;

    @FXML
    private Button submitButton;

    @FXML
    private ListView<?> taskList;
    
    @FXML
    void submitPressed(ActionEvent event) {

    }
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
}
