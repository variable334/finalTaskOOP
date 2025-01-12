package src.Note.builder;


import src.Note.Note;

import java.time.LocalDateTime;

public abstract class NoteBuilder {

    private String identifier;
    private String notes;
    private LocalDateTime data;


    public String getIdentifier() {
        return identifier;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getData() {
        return data;
    }

    public NoteBuilder setNote(String note){
        this.notes = note;
        return this;
    }


    public NoteBuilder setIdentifier(String identifier){
        this.identifier = identifier;
        return this;
    }

    public NoteBuilder setData(LocalDateTime localDateTime){
        this.data = localDateTime;
        return this;
    }

    public abstract Note buildNote();


}
