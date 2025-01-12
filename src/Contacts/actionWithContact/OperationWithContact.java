package src.Contacts.actionWithContact;

import src.Contacts.Contact;

import java.util.List;

public interface OperationWithContact {

    void save(String name);

    List<Contact> load(String path);

    void viewLoadContact(String name);
}
