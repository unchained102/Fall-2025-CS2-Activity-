package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private Label errorTextLabel;
    @FXML private Button generatePasswordButton;
    @FXML private Label minimumLengthError;
    @FXML private ListView<String> passList;
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.vm.getPassList().bind(this.passList.itemsProperty());
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    	
    	this.minimumLength.textProperty().addListener(
    		(observable, oldValue, newValue) -> {
		       	if (newValue.matches("^0+$")) {
		       		this.minimumLengthError.setText(newValue + " is not greater than 0");
	       			this.minimumLengthError.setVisible(true);
		       		
		       	} else if (newValue.matches("-\\d+")) {
		       		this.minimumLengthError.setText(newValue + " is not greater than 0");
	       			this.minimumLengthError.setVisible(true);
		       	} else if (newValue.matches("\\d+")) {
		       		this.minimumLengthError.setVisible(false);
		       	} else if (newValue.matches("")) {
		       		this.minimumLengthError.setText("Please input an integer greater than 0.");
	       			this.minimumLengthError.setVisible(true);
		       	} else {
		       		this.minimumLengthError.setText(newValue + " is not an integer.");
	        		this.minimumLengthError.setVisible(true);
		       	}
    		}
    	);
    }
}
