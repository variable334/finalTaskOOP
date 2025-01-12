package src.Note.actionWithNote;

import java.time.LocalDateTime;

public interface ChangesNotes {

    void changesLocalDateNote(String ex, LocalDateTime change);

    void changesStringNote(String ex,String note);

    void removeNote(String identifier);

}
