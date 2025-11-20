package edu.westga.cs1302.contact_manager.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.westga.cs1302.contact_manager.model.Contact;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** View model for the MainWindow view
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindowViewModel {
	private StringProperty name;
	private StringProperty phoneNumber;
	private StringProperty searchCriteria;
	private ListProperty<Contact> contacts;
	private Map<String, Contact> numberMap;
	private Map<String, Contact> nameMap;
	
	/** Initialize the MainWindowViewModel
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public MainWindowViewModel() {
		this.name = new SimpleStringProperty("");
		this.phoneNumber = new SimpleStringProperty("");
		this.searchCriteria = new SimpleStringProperty("");
		this.contacts = new SimpleListProperty<Contact>(FXCollections.observableList(new ArrayList<Contact>()));
		this.nameMap = new HashMap<String, Contact>();
		this.numberMap = new HashMap<String, Contact>();

	}
	
	/** Return the name property used when adding a contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name property used when adding a contact
	 */
	public StringProperty getName() {
		return this.name;
	}
	
	/** Return the phone number property used when adding a contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the phone number property used when adding a contact
	 */
	public StringProperty getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/** Return the search criteria property used when finding a contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the search criteria property used when finding a contact
	 */
	public StringProperty getSearchCriteria() {
		return this.searchCriteria;
	}
	
	/** Return the list property containing all contacts added to the system
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list property containing all contacts added to the system
	 */
	public ListProperty<Contact> getContacts() {
		return this.contacts;
	}
	
	/** Adds a new contact with name and phone number set by the appropriate property
	 * 
	 * @precondition none
	 * @postcondition a new contact with name and phone number provided has been added
	 * 
	 * @throws IllegalArgumentException if either name or phone number are invalid (see Contact class)
	 */
	public void addContact() throws IllegalArgumentException {
		if (this.nameMap.containsKey(this.name.get())) {
			throw new IllegalArgumentException("Contact with name " + this.name.get() + " already on file.");
		}
		if (this.numberMap.containsKey(this.phoneNumber.get())) {
			throw new IllegalArgumentException("Contact with number " + this.phoneNumber.get() + " already on file.");
		}
		Contact contact = new Contact(this.name.get(), this.phoneNumber.get());
		this.contacts.add(contact);
		this.numberMap.put(contact.getPhoneNumber(), contact);
		this.nameMap.put(contact.getName(), contact);
	}
	
	/** Finds a contact with name or phone number matches provide search criteria
	 * 
	 * @precondition none
	 * @postcondition getResultContact().get() is set to the appropriate contact (if contact found) OR null (if no contact found)
	 * 
	 * @return A string representation of the contact found.
	 */
	public String findContact() {
		if (!Contact.checkName(this.searchCriteria.get()) && !Contact.checkPhoneNumber(this.searchCriteria.get())) {
			throw new IllegalArgumentException("Search criteria is not a valid name or phone number");
		}

		if (Contact.checkName(this.searchCriteria.getValue())) {
			Contact found = this.nameMap.get(this.searchCriteria.get());
			if (found != null) {
				return found.toString();
			}
		}
		if (Contact.checkPhoneNumber(this.searchCriteria.getValue())) {
			Contact found = this.numberMap.get(this.searchCriteria.get());
			if (found != null) {
				return found.toString();
			}		
		}
		return "No contact found.";
	}
	
}
