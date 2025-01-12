package src.Note.actionWithNote;

import java.time.LocalDateTime;

public interface ActionWithNotes {

    void writeNote(String identifier, String notes, LocalDateTime localDateTime);

    void readingNotes();

    void readingSingleNotes(String name);

    void readingSingleNoteDate(LocalDateTime dateTime);




}
