package edu.westga.cs1302.password_generator.view;

import java.io.File;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

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
    @FXML private Label minLengthErrorText;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> passwordHistory;
    @FXML private MenuItem fileClose;
    @FXML private MenuItem fileSave;
    @FXML private MenuItem fileAbout;

    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.passwordHistory.setItems(this.vm.getPasswordHistory());
    	
    	this.minimumLength.textProperty().addListener((observable, newValue, oldValue) -> {
    		this.minLengthErrorText.setVisible(!oldValue.matches("\\d+") || Integer.parseInt(oldValue) == 0);
    		this.generatePasswordButton.setDisable(this.minLengthErrorText.visibleProperty().get());
    	});
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    	
    	this.fileClose.setOnAction(
    			(event) -> {
    			    this.endProgram();
    			}
    	);
    	
    	this.fileAbout.setOnAction(
    			(event) -> {
    				this.showAppInfo();
    			}
    	);
    	
    	this.fileSave.setOnAction(
    			(event) -> {
    				this.savePasswords();
    			}
    	);
    }

	void endProgram() {
		((Node) (this.errorTextLabel)).getScene().getWindow().hide();
	}
	
	void savePasswords() {
		FileChooser save = new FileChooser();
		save.setTitle("Save to Text File");
		save.getExtensionFilters().add(new ExtensionFilter("Text File", "*.txt"));
		File saveFile = save.showOpenDialog((this.errorTextLabel).getScene().getWindow());
		try {
			this.vm.persistPasswords(saveFile);
		} catch (IllegalArgumentException error) {
			Alert fileNotFound = new Alert(AlertType.ERROR);
			fileNotFound.setContentText(error.getMessage());
			fileNotFound.showAndWait();
		}
	}

	void showAppInfo() {
		Alert about = new Alert(AlertType.INFORMATION);
		about.setHeaderText("Password Generator");
		about.setContentText("A project that generates a list of passwords." 
		+ System.lineSeparator() + "By Everett Dewberry."
		);
		about.setTitle("Project Information");
		about.setGraphic(null);
		about.showAndWait();
	}
}
