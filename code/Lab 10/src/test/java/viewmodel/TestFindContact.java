package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;
import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class TestFindContact {

	@Test
	void testWithCorrectNumberWhenOneContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("One");
		vm.getPhoneNumber().set("1111111");
		vm.getSearchCriteria().set("1111111");
		vm.addContact();
		Contact expected = new Contact("One", "1111111");
		assertEquals(expected.toString(), vm.findContact());
		
	}
	
	@Test
	void testWithCorrectNameWhenOneContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("One");
		vm.getPhoneNumber().set("1111111");
		vm.getSearchCriteria().set("One");
		vm.addContact();
		Contact expected = new Contact("One", "1111111");
		assertEquals(expected.toString(), vm.findContact());
		
	}
	
	@Test
	void testWithCorrectNumberWhenMultipleContacts() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("One");
		vm.getPhoneNumber().set("1111111");
		vm.addContact();
		vm.getName().set("Two");
		vm.getPhoneNumber().set("2222222");
		vm.addContact();
		vm.getName().set("Three");
		vm.getPhoneNumber().set("3333333");
		vm.getSearchCriteria().set("3333333");
		vm.addContact();
		Contact expected = new Contact("Three", "3333333");
		assertEquals(expected.toString(), vm.findContact());
		
	}
	
	@Test
	void testWithCorrectNameWhenMultipleContacts() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("One");
		vm.getPhoneNumber().set("1111111");
		vm.addContact();
		vm.getName().set("Two");
		vm.getPhoneNumber().set("2222222");
		vm.addContact();
		vm.getName().set("Three");
		vm.getPhoneNumber().set("3333333");
		vm.getSearchCriteria().set("Two");
		vm.addContact();
		Contact expected = new Contact("Two", "2222222");
		assertEquals(expected.toString(), vm.findContact());
		
	}
	
	@Test
	void testWhenBadSearchCriteria() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("One");
		vm.getPhoneNumber().set("1111111");
		vm.getSearchCriteria().set("1");
		vm.addContact();
		assertThrows(IllegalArgumentException.class, ()->{
			vm.findContact();
		});
	}
	
	@Test
	void testWhenNoSuchContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("One");
		vm.getPhoneNumber().set("1111111");
		vm.getSearchCriteria().set("2222222");
		vm.addContact();
		String expected = "No contact found.";
		assertEquals(expected, vm.findContact());
		
	}

}
