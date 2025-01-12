package presenter.presentContact;

import src.Contacts.Contact;
import src.Note.Note;

public interface ReadingAndWritingContact {

    void recordsContact(String name, String number,String email);

    void viewingContact();

    void viewingSingleContact(String name);

    Contact searchContact(String name);
}
