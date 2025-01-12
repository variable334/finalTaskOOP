package src.Note;

import src.Note.actionWithNote.GetElementNote;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements GetElementNote, Serializable {

    private String identifier;
    private String note;
    private LocalDateTime data;

    public Note(String identifier, String note, LocalDateTime localDateTime) {
        this.identifier = identifier;
        this.note = note;
        this.data = localDateTime;
    }


    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public LocalDateTime getData() {
        return data;
    }


    public void setStringNote(String stringNote) {
        note = stringNote;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Note{" +
                "identifier='" + identifier + '\'' +
                ", note='" + note + '\'' +
                ", data=" + data +
                '}';
    }
}
