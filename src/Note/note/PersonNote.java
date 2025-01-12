package src.Note.note;

import src.Note.Note;
import src.Note.builder.NoteBuilder;

public class PersonNote extends NoteBuilder {

    @Override
    public Note buildNote() {

        if(getIdentifier() != null || getNotes() != null || getData() != null){
            return new Note(getIdentifier(),getNotes(),getData());
        }
        else{
            System.out.println("Не все критерии записки заполнены");
        }
        return null;
    }

    @Override
    public String toString() {
        return "PersonNote{}";
    }
}
