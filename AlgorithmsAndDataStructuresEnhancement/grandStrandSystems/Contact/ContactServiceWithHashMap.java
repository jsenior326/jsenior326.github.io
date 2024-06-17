// Author: Jacob Senior
//
// This file implements services for the Contact class but instead uses a
// hashmap to improve performance

package grandStrandSystems.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactServiceWithHashMap {
	private Map<String, Contact> contactList;
	
	public ContactServiceWithHashMap() {
		this.contactList = new HashMap<>();
	}
	
	// Add new contact
	public void addContact(Contact c) {
		// Check for duplicate
		if (contactList.containsKey(c.getContactID())) {
			throw new IllegalArgumentException("ContactID already exists in contacts");
		}
		
		// Add the contact where the key is the contactID
		contactList.put(c.getContactID(), c);
	}
	
	// Deletes the given contact by contactID
	public void deleteContact(String contactID) {
		if (contactList.remove(contactID) == null) {
			throw new IllegalArgumentException("Contact with the given contactID not found");
		}
	}
	
	// Update the given contact by contactID
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		Contact c = contactList.get(contactID);
		
		// If null, no matching contactID was found
		if (c != null) {
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setPhone(phone);
			c.setAddress(address);
		} else {
			throw new IllegalArgumentException("Contact with the given contactID not found");
		}
	}
	
	// Returns a single contact given contactID
	public Contact findContact(String contactID) {
		Contact c = contactList.get(contactID);
		
		if (c != null) {
			return c;
		} else {
			throw new IllegalArgumentException("Contact with the given contactID not found");
		}
	}
	
	// contactList accessor
	public Map<String, Contact> getContactList() {
		return contactList;
	}
}
