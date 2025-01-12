package src.NoteBook;

import src.Contacts.Contact;
import src.Contacts.actionWithContact.*;



public class NoteBookContact {

    private ActionWithContact actionWithContact;
    private OperationWithContact operationWithContact;
    private ChangesContact changesContact;
    private SortedByName sortedByName;
    private SearchContact searchContact;



    public NoteBookContact(ActionWithContact actionWithContact,
                           OperationWithContact operationWithContact,
                           ChangesContact changesContact,
                          SortedByName sortedByName,SearchContact searchContact) {

        this.searchContact = searchContact;
        this.actionWithContact = actionWithContact;
        this.operationWithContact = operationWithContact;
        this.changesContact = changesContact;
        this.sortedByName = sortedByName;



    }

    public void writeContact(String name, String number, String email) {
        actionWithContact.writeContact(name, number, email);
    }


    public void readingListContact(){
        actionWithContact.readingContacts();

    }

    public void readingContact(String name){
        actionWithContact.readingSingleContact(name);
    }

    public Contact searchContact(String name){
        return searchContact.contactSearch(name);
    }

    public void changeContact(String ex, String change) {
        changesContact.changesContact(ex, change);
    }

    public void removeContact(String name){
        changesContact.removeContact(name);
    }

    public void saveContact(String path) {
        operationWithContact.save(path);
    }

    public void loadContacts(String name){
        operationWithContact.load(name);
    }

    public void viewLoadContact(String name){
        operationWithContact.viewLoadContact(name);
    }

    public void sortByName(){
        sortedByName.SortByName();
    }
}
