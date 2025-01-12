package src.Note.actionWithNote;

import src.Note.Note;

import java.time.LocalDateTime;

public interface SearchNotes {

    Note searchNote(String identifier);

    Note searchNoteDate(LocalDateTime dateTime);
}
