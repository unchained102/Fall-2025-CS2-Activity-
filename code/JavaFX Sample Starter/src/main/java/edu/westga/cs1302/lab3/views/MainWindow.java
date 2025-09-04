package edu.westga.cs1302.lab3.views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import edu.westga.cs1302.lab3.model.*;


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
    private TextField inputName;
    
    @FXML
    private TextField inputAmount;
    
    @FXML
    private Button button;

	private String name;

	private String sAmount;

	private Double dAmount;
	
	private BillItem item;
	
	private Bill bill;
	
	private BillView view;
    
    
    @FXML
    void displayText(ActionEvent event) {
    	this.name = this.inputName.getText();
    	this.sAmount = this.inputAmount.getText();
    	this.dAmount = Double.parseDouble(this.sAmount);
    	this.item = new BillItem(this.name, this.dAmount);
    	this.bill.addItem(item);
    	this.output.setText(this.view.getText(this.bill));
    	
    }
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	Platform.runLater( () -> button.requestFocus() );
    	this.bill = new Bill();
    	this.view = new BillView();
    }
    
    
    
    
}
