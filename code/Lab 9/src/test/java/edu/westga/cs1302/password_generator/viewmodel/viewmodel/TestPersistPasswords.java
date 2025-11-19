package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestPersistPasswords {

	@Test
	void testValid() {
		ViewModel vm = new ViewModel();
		ArrayList<String> passwords = new ArrayList<String>();
		passwords.add("pass1");
		passwords.add("pass2");
		passwords.add("pass3");

		vm.getPasswordHistory().getValue().addAll(passwords);
		File saveFile = new File("src/test/resources/savetest.txt");
		
		vm.persistPasswords(saveFile);
		
		try (Scanner scnr = new Scanner(saveFile)) {
			for (int i = 0; i < 3; i++) {
				assertEquals("pass" + (i + 1), scnr.nextLine());
			}
		} catch (IOException error) {
			fail();
		}
		
		
	}
	
	@Test
	void testNoPasswords() {
		ViewModel vm = new ViewModel();

		File saveFile = new File("src/test/resources/savetest.txt");
		
		assertThrows(IllegalArgumentException.class, ()-> {
			vm.persistPasswords(saveFile);
		});
		
	}
	
	@Test
	void testNoFile() {
		ViewModel vm = new ViewModel();
		ArrayList<String> passwords = new ArrayList<String>();
		passwords.add("pass1");
		passwords.add("pass2");
		passwords.add("pass3");

		vm.getPasswordHistory().getValue().addAll(passwords);
		
		assertThrows(IllegalArgumentException.class, ()-> {
			vm.persistPasswords(null);
		});
		
	}

}
