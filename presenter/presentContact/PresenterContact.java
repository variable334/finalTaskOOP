package presenter.presentContact;

import src.Contacts.Contact;
import src.Contacts.actionWithContact.*;
import src.NoteBook.NoteBookContact;


public class PresenterContact implements ReadingAndWritingContact, ChangeAndDeleteContact, SavingAndLoadingContact, SortContact {

//    private ActionWithContact actionWithContact;
//    private ChangesContact changesContact;
//    private OperationWithContact operationWithContact;
//    private SortedByName sortedByName;
    private NoteBookContact noteBookContact;



    public PresenterContact(ActionWithContact actionWithContact,ChangesContact changesContact,
                            OperationWithContact operationWithContact,SortedByName sortedByName,SearchContact searchContact) {

//        this.actionWithContact = actionWithContact;
//        this.changesContact = changesContact;
//        this.operationWithContact = operationWithContact;
//        this.sortedByName = sortedByName;
        this.noteBookContact = new NoteBookContact(actionWithContact,
                operationWithContact,changesContact,sortedByName,searchContact);

    }


    @Override
    public void recordsContact(String name, String number, String email) {

//        actionWithContact.writeContact(name,number,email);
        noteBookContact.writeContact(name,number,email);

    }

    @Override
    public void viewingContact() {
//        actionWithContact.readingContacts();
        noteBookContact.readingListContact();
    }

    @Override
    public void viewingSingleContact(String name) {
//        actionWithContact.readingSingleContact(name);
        noteBookContact.readingContact(name);
    }

    @Override
    public Contact searchContact(String name) {
        return noteBookContact.searchContact(name);
    }


    @Override
    public void amendContact(String ex, String change) {
//        changesContact.changesContact(ex,change);
        noteBookContact.changeContact(ex,change);
    }

    @Override
    public void deleteContact(String name) {
//        changesContact.removeContact(name);
        noteBookContact.removeContact(name);
    }


    @Override
    public void saving(String name) {
//        operationWithContact.save(name);
        noteBookContact.saveContact(name);
    }

    @Override
    public void loading(String name) {
//        operationWithContact.load(name);
        noteBookContact.loadContacts(name);
    }

    @Override
    public void viewLoad(String name) {
        noteBookContact.viewLoadContact(name);
    }


    @Override
    public void triageByName() {
//        sortedByName.SortByName();
        noteBookContact.sortByName();
    }



}
