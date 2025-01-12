package src.NoteBook;

import src.Note.Note;
import src.Note.actionWithNote.*;

import java.time.LocalDateTime;

public class NoteBookNote {

    private ChangesNotes changesNotes;
    private ActionWithNotes actionWithNotes;
    private OperationWithNote operationWithNote;
    private SortByDate sortByDate;
    private SortByIdentifier sortByIdentifier;
    private SearchNotes searchNotes;

    public NoteBookNote(ActionWithNotes actionWithNotes, ChangesNotes changesNotes,
                        OperationWithNote operationWithNote, SortByDate sortByDate,
                        SortByIdentifier sortByIdentifier,SearchNotes searchNotes) {

        this.actionWithNotes = actionWithNotes;
        this.changesNotes = changesNotes;
        this.operationWithNote = operationWithNote;
        this.sortByDate = sortByDate;
        this.sortByIdentifier = sortByIdentifier;
        this.searchNotes = searchNotes;
    }

    public void writeNotes(String identifer, String note, LocalDateTime localDateTime) {
        actionWithNotes.writeNote(identifer, note, localDateTime);

    }



    public void FindRecordByDate(LocalDateTime dateTime){
        actionWithNotes.readingSingleNoteDate(dateTime);
    }
    public Note searchNotesDataTime(LocalDateTime dateTime){
        return searchNotes.searchNoteDate(dateTime);
    }

    public void readingListNotes(){
        actionWithNotes.readingNotes();
    }

    public Note SearchNotes(String identifier){
       return searchNotes.searchNote(identifier);
    }


    public void readingSingleNote(String identifier){
        actionWithNotes.readingSingleNotes(identifier);

    }
    public void readingSingleNoteDataTime(LocalDateTime dateTime){
        actionWithNotes.readingSingleNoteDate(dateTime);
    }

    public void changesLocalDateNote(String ex, LocalDateTime change) {
        changesNotes.changesLocalDateNote(ex, change);
    }

    public void changesStringNote(String ex,String identifier){
        changesNotes.changesStringNote(ex,identifier);
    }

    public void removeNote(String identifier){
        changesNotes.removeNote(identifier);
    }

    public void saveNotes(String path){
        operationWithNote.save(path);
    }

    public void loadNotes(String name){
        operationWithNote.load(name);
    }

    public void viewLoad(String name) {
        operationWithNote.viewLoad(name);
    }

    public void sortByDate(){
        sortByDate.sortDate();
    }

    public void sortByIdentifier(){
        sortByIdentifier.sortIdentifier();
    }



}
