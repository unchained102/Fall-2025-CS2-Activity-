package edu.westga.cs1302.password_generator.tests.viewmodel.generator_view_model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.GeneratorViewModel;

class TestGeneratePassword {

	@Test
	void testWhenMinLength1() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.generatePassword();
		
		assert(vm.getOutputProperty().getValue().length() >= 1);
	}
	
	@Test
	void testWhenMinLength5() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.getMinimumLengthProperty().setValue("5");
		vm.generatePassword();
		
		assert(vm.getOutputProperty().getValue().length() >= 5);
	}
	
	@Test
	void testWhenMinLength25() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.getMinimumLengthProperty().setValue("25");
		vm.generatePassword();
		
		assert(vm.getOutputProperty().getValue().length() >= 25);
	}
	
	@Test
	void testWhenMustContainDigits() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.getMustIncludeDigitsProperty().setValue(true);
		vm.generatePassword();
		for (char c : vm.getOutputProperty().getValue().toCharArray()) {
			if (c >= '0' && c <= '9') {
				return;
			}
		}
		fail("No Digits in: " + vm.getOutputProperty().getValue());
		
	}
	
	@Test
	void testWhenMustContainUpperCaseLetters() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.getMustIncludeUpperCaseLettersProperty().setValue(true);
		vm.generatePassword();
		for (char c : vm.getOutputProperty().getValue().toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				return;
			}
		}
		fail("No UpperCase Letters in: " + vm.getOutputProperty().getValue());
		
	}
	
	@Test
	void testWhenMustContainLowerCaseLetters() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.getMustIncludeLowerCaseLettersProperty().setValue(true);
		vm.generatePassword();
		for (char c : vm.getOutputProperty().getValue().toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				return;
			}
		}
		fail("No LowerCase Letters in: " + vm.getOutputProperty().getValue());
		
	}
	
	@Test
	void testWhenMinimumLengthNotInteger() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.getMinimumLengthProperty().setValue("");
		assertThrows(NumberFormatException.class, ()-> {
			vm.generatePassword();
		});
	}
	
	@Test
	void testWhenMinimumLengthLessThanOne() {
		GeneratorViewModel vm = new GeneratorViewModel();
		vm.getMinimumLengthProperty().setValue("0");
		assertThrows(IllegalArgumentException.class, ()-> {
			vm.generatePassword();
		});
	}

}
