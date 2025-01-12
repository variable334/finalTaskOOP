package presenter.presentNote;

import src.Note.Note;
import src.Note.NotesActionManager;
import src.Note.actionWithNote.*;
import src.Note.builder.NoteBuilder;
import src.Note.note.PersonNote;
import src.NoteBook.NoteBookNote;

import java.time.LocalDateTime;

public class PresenterNote implements WritingAndReadingNote,ChangesAndDeleteNote,SavingAndLoadingNote,SortNotes {

//    private ActionWithNotes actionWithNotes;
//    private OperationWithNote operationWithNote;
//    private ChangesNotes changesNotes;
//    private SortByDate sortByDate;
//    private SortByIdentifier sortByIdentifier;
    private NoteBookNote noteBookNote;



    public PresenterNote(ActionWithNotes actionWithNotes, ChangesNotes changesNotes,
                         OperationWithNote operationWithNote, SortByDate sortByDate,
                         SortByIdentifier sortByIdentifier,SearchNotes searchNotes) {

//        this.actionWithNotes = actionWithNotes;
//        this.changesNotes = changesNotes;
//        this.operationWithNote = operationWithNote;
//        this.sortByDate = sortByDate;
//        this.sortByIdentifier = sortByIdentifier;
        this.noteBookNote = new NoteBookNote(actionWithNotes,changesNotes,operationWithNote,sortByDate,sortByIdentifier,searchNotes);


    }



    @Override
    public void recordNote(String identifier, String note, LocalDateTime dateTime) {
//        actionWithNotes.writeNote(identifier,note,dateTime);
        noteBookNote.writeNotes(identifier,note,dateTime);
    }

    @Override
    public void viewingNotes() {
//        actionWithNotes.readingNotes();
        noteBookNote.readingListNotes();
    }

    @Override
    public void viewingSingleNotes(String name) {
//        actionWithNotes.readingSingleNotes(name);
        noteBookNote.readingSingleNote(name);
    }


    @Override
    public void viewingSingleNoteDate(LocalDateTime dateTime) {
//        actionWithNotes.readingSingleNoteDate(dateTime);
        noteBookNote.readingSingleNoteDataTime(dateTime);
    }

    @Override
    public Note searchNote(String identifier) {
        return noteBookNote.SearchNotes(identifier);
    }

    @Override
    public Note searchNoteDataTime(LocalDateTime dateTime) {
        return noteBookNote.searchNotesDataTime(dateTime);
    }


    @Override
    public void amendBysLocalDateNote(String ex, LocalDateTime change) {
//        changesNotes.changesLocalDateNote(ex,change);
        noteBookNote.changesLocalDateNote(ex,change);
    }

    @Override
    public void amendByStringNote(String ex, String change) {
//        changesNotes.changesStringNote(ex, change);
        noteBookNote.changesStringNote(ex,change);
    }

    @Override
    public void deleteNote(String identifier) {
//        changesNotes.removeNote(identifier);
        noteBookNote.removeNote(identifier);
    }


    @Override
    public void save(String name) {
//        operationWithNote.save(name);
        noteBookNote.saveNotes(name);
    }

    @Override
    public void load(String name) {
//        operationWithNote.load(name);
        noteBookNote.loadNotes(name);
    }

    @Override
    public void viewLoad(String name) {
        noteBookNote.viewLoad(name);
    }


    @Override
    public void sortByTime() {
//        sortByDate.sortDate();
        noteBookNote.sortByDate();
    }

    @Override
    public void sortById() {
//        sortByIdentifier.sortIdentifier();
        noteBookNote.sortByIdentifier();

    }
}
