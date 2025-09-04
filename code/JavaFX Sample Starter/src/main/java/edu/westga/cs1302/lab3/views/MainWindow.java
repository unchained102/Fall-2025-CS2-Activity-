package edu.westga.cs1302.lab3.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import edu.westga.cs1302.lab3.model.*;
import edu.westga.cs1302.lab3.views.BillView;


/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML
    private TextArea output;

    @FXML
    private TextField input;
    
    
    @FXML
    void displayText(ActionEvent event) {
    	String input = this.input.getText();
    	this.output.setText(input);
    }
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	
    }
    
    
    
    
}
