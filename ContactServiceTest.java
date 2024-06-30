package contactservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    //initialized contact service before each test case
    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }
    //test case to add contact
    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "Tagoe", "Nii Amatey", "1234567890", "75154 RX st");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }
    //test case to check contacts for adding duplicates
    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("1234567890", "Tagoe", "Nii Amatey", "1234567890", "75154 RX st");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
    }
    //test case to check removing or deleting contact
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "Tagoe", "Nii Amatey", "1234567890", "75154 RX st");
        service.addContact(contact);
        assertNotNull(service.getContact("1234567890"));
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }
    //test case to check removing or deleting a non existing contact
    @Test
    public void testDeleteNonExistentContact() {
        assertFalse(service.deleteContact("ID Not Found"));
    }
    //test case to check for updating contact
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "Tagoe", "Nii Amatey", "1234567890", "75154 RX st");
        service.addContact(contact);
        service.updateContact("1234567890", "Attoh", "Prince", "0987654321", "2520 Cross st");
        
        Contact updatedContact = service.getContact("1234567890");
        assertEquals("Attoh", updatedContact.getLastName());
        assertEquals("Prince", updatedContact.getFirstName());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("2520 Cross st", updatedContact.getAddress());
    }
    //test case to check for updating a non existing contact
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("ID Not Found", "Tagoe", "Nii Amatey", "0987654321", "75154 RX st");
        });
    }
}
