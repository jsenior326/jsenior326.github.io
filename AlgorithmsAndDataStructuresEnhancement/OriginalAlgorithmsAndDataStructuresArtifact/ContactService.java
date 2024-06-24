// Author: Jacob Senior
// Assignment: CS320 Milestone One Contact Service
// Due Date: 11/12/2023

package grandStrandSystems;

import java.util.ArrayList;

public class ContactService {

	private ArrayList<Contact> contactList;
	
	// Default constructor for contact service
	public ContactService() {
		contactList = new ArrayList<Contact>();
	}
	
	// Adds the given contact to the contactList if the given contactID is unique
	public void addContact(Contact c) {
		// Searches for a contact with the given contactID
		for (Contact contact : contactList) {
			// Throw exception if the contactID is not unique
			if (contact.getContactID().equals(c.getContactID())) {
				throw new IllegalArgumentException("ContactID already exists in contacts");
			}
		}
		
		// Adds the given contact if the contactID is unique
		contactList.add(c);
	}
	
	// Deletes the given contact from the contactList using the contactID
	public void deleteContact(String contactID) {
		Contact c = null;
		
		// Searches for a contact with the given contactID
		for (Contact contact : contactList) {
			// Removes the contact from the contactList
			if (contact.getContactID().equals(contactID)) {
				c = contact;
			}
		}
		
		// If contact with the given contactID was found, delete contact. Else throw exception
		if (c != null) {
			contactList.remove(c);
		} else {
			throw new IllegalArgumentException("Contact with the given contactID not found");
		}
	}
	
	// Updates the given contact by contactID and the given fields
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		Contact c = null;
		
		// Searches for a contact with the given contactID
		for (Contact contact : contactList) {
			// Updates the contactID with the new fields
			if (contact.getContactID().equals(contactID)) {
				c = contact;
			}
		}
		
		// If no contact with the given contactID was found, throw exception
		if (c != null) {
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setPhone(phone);
			c.setAddress(address);
		} else {
			throw new IllegalArgumentException("Contact with the given contactID not found");
		}
	}
	
	// contactList accessor
	public ArrayList<Contact> getContactList() {
		return contactList;
	}
	
}
