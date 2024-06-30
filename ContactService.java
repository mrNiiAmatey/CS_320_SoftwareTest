package contactservice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {
    //data structure to hold the contacts
    private Map<String, Contact> contacts;
    //constructor
    public ContactService() {
        contacts = new ConcurrentHashMap<>();
    }
    //method to add a contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already added");
        }
        contacts.put(contact.getContactID(), contact);
    }
    //method to remove or delete a contact
    public boolean deleteContact(String contactID) {
        return contacts.remove(contactID) != null;
    }
    //method to update a contact
    public void updateContact(String contactID, String lastName, String firstName, String phoneNumber, String address) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setLastName(lastName);
            contact.setFirstName(firstName);
            contact.setPhoneNumber(phoneNumber);
            contact.setAddress(address);
        } else {
            throw new IllegalArgumentException("Contact not found");
        }
    }
    //method to retrieve a contact
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}