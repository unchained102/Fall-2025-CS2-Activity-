package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.GeneratorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML private Button generate;
    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
    private GeneratorViewModel vm;
    
    @FXML
    void initialize() {
        assert this.mustIncludeDigits != null : "fx:id=\"mustIncludeDigits\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeLowerCaseLetters != null : "fx:id=\"mustIncludeLowerCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeUpperCaseLetters != null : "fx:id=\"mustIncludeUpperCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.minimumLength != null : "fx:id=\"minimumLength\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.output != null : "fx:id=\"output\" was not injected: check your FXML file 'MainWindow.fxml'.";

        this.vm = new GeneratorViewModel();
        this.minimumLength.textProperty().bindBidirectional(this.vm.getMinimumLengthProperty());
        this.mustIncludeDigits.selectedProperty().bindBidirectional(this.vm.getMustIncludeDigitsProperty());
        this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(this.vm.getMustIncludeLowerCaseLettersProperty());
        this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(this.vm.getMustIncludeUpperCaseLettersProperty());
        this.output.textProperty().bind(this.vm.getOutputProperty());
        this.generate.setOnAction((event) -> {
        	try {
        		this.vm.generatePassword();
        	} catch (NumberFormatException numberError) {
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setContentText("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getText());
        		alert.show();
        		return;
        	 } catch (IllegalArgumentException invalidLengthError) {
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setContentText("Invalid Minimum Length: " + invalidLengthError.getMessage());
        		alert.show();
        		return;
        	}
        });
    }
}
