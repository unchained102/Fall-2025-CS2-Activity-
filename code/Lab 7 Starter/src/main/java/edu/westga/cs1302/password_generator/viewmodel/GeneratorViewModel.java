package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import java.util.Random;

/** ViewModel for Password Generator.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class GeneratorViewModel {
	
	private StringProperty minimumLengthProperty;
	private BooleanProperty mustIncludeDigitsProperty;
	private BooleanProperty mustIncludeLowerCaseLettersProperty;
	private BooleanProperty mustIncludeUpperCaseLettersProperty;
	private StringProperty outputProperty;
    private PasswordGenerator generator;
	
	/**
	 * Instantiates new GeneratorViewModel.
	 */
	public GeneratorViewModel() {
		this.minimumLengthProperty = new SimpleStringProperty("1");
		this.mustIncludeDigitsProperty = new SimpleBooleanProperty(false);
		this.mustIncludeLowerCaseLettersProperty = new SimpleBooleanProperty(false);
		this.mustIncludeUpperCaseLettersProperty = new SimpleBooleanProperty(false);
		this.outputProperty = new SimpleStringProperty("");
		
		Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
	}

	/**
	 * Gets the minimumLengthProperty
	 * @return the minimumLengthProperty
	 */
	public StringProperty getMinimumLengthProperty() {
		return this.minimumLengthProperty;
	}

	/**
	 * Gets the mustIncludeDigitsProperty
	 * @return the mustIncludeDigitsProperty
	 */
	public BooleanProperty getMustIncludeDigitsProperty() {
		return this.mustIncludeDigitsProperty;
	}

	/**
	 * Gets the mustIncludeLowerCaseLettersProperty
	 * @return the mustIncludeLowerCaseLettersProperty
	 */
	public BooleanProperty getMustIncludeLowerCaseLettersProperty() {
		return this.mustIncludeLowerCaseLettersProperty;
	}

	/**
	 * Gets the mustIncludeUpperCaseLettersProperty
	 * @return the mustIncludeUpperCaseLettersProperty
	 */
	public BooleanProperty getMustIncludeUpperCaseLettersProperty() {
		return this.mustIncludeUpperCaseLettersProperty;
	}
	
	/**
	 * Gets the outputProperty
	 * @return the outputProperty
	 */
	public StringProperty getOutputProperty() {
		return this.outputProperty;
	}

	/**
	 * Generates a password and sets the outputProperty value to that password.
	 * 
	 * @throws NumberFormatException when minimumLengthProperty cannot be parsed into int..
	 * @throws IllegalArgumentException when minimumLengthProperty < 1
	 */
	public void generatePassword() throws NumberFormatException, IllegalArgumentException {
    	int minimumLength = -1;
    	minimumLength = Integer.parseInt(this.minimumLengthProperty.getValue());
    	
    	this.generator.setMinimumLength(minimumLength);
    	
    	this.generator.setMustHaveAtLeastOneDigit(this.mustIncludeDigitsProperty.getValue());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.mustIncludeLowerCaseLettersProperty.getValue());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.mustIncludeUpperCaseLettersProperty.getValue());
    	
    	String password = this.generator.generatePassword();
    	
    	this.outputProperty.setValue(password);
    }
}
