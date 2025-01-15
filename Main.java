import presenter.presentContact.*;
import presenter.presentNote.*;
import src.Contacts.ContactActionManager;
import src.Contacts.ContactBuilder;
import src.Contacts.actionWithContact.*;
import src.Contacts.personContact;

import src.Note.*;
import src.Note.actionWithNote.*;
import src.Note.note.PersonNote;
import src.Note.builder.NoteBuilder;
import src.NoteBook.NoteBookContact;
import src.NoteBook.NoteBookNote;
import view.ConsoleUI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ContactBuilder contactBuilder = new personContact();
        ContactActionManager contactActionManager = new ContactActionManager(contactBuilder);

        ActionWithContact actionWithContact = contactActionManager;
        OperationWithContact operationWithContact = contactActionManager;
        ChangesContact changesContact = contactActionManager;
        SortedByName sortedByName = contactActionManager;
        SearchContact searchContact = contactActionManager;

        NoteBuilder noteBuilder = new PersonNote();
        NotesActionManager notesActionManager = new NotesActionManager(noteBuilder);


        ActionWithNotes actionWithNotes = notesActionManager;
        OperationWithNote operationWithNote = notesActionManager;
        ChangesNotes changesNotes = notesActionManager;
        SortByDate sortByDate = notesActionManager;
        SortByIdentifier sortByIdentifier = notesActionManager;
        SearchNotes searchNotes = notesActionManager;


        NoteBookContact noteBookContact = new NoteBookContact(actionWithContact,
                operationWithContact, changesContact, sortedByName, searchContact);

        NoteBookNote noteBookNote = new NoteBookNote(actionWithNotes, changesNotes,
                operationWithNote, sortByDate, sortByIdentifier, searchNotes);


        PresenterContact presenterContact = new PresenterContact(actionWithContact, changesContact,
                operationWithContact, sortedByName, searchContact);


        ChangeAndDeleteContact changeAndDeleteContact = presenterContact;
        ReadingAndWritingContact readingAndWritingContact = presenterContact;
        SavingAndLoadingContact savingAndLoadingContact = presenterContact;
        SortContact sortContact = presenterContact;

        PresenterNote presenterNote = new PresenterNote(actionWithNotes, changesNotes,
                operationWithNote, sortByDate,
                sortByIdentifier, searchNotes);

        ChangesAndDeleteNote changesAndDeleteNote = presenterNote;
        WritingAndReadingNote writingAndReadingNote = presenterNote;
        SavingAndLoadingNote savingAndLoadingNote = presenterNote;
        SortNotes sortNotes = presenterNote;


        ConsoleUI consoleUI = new ConsoleUI(changeAndDeleteContact, readingAndWritingContact,
                savingAndLoadingContact, sortContact, changesAndDeleteNote,
                writingAndReadingNote, savingAndLoadingNote, sortNotes);

        consoleUI.run();

    }
}
